package com.example.demo.modules.nav_link.http

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.example.demo.common.AppException
import com.example.demo.model.Category
import com.example.demo.model.NavLink
import com.example.demo.modules.category.CategoryDao
import com.example.demo.modules.nav_link.NavLinkDao
import com.example.demo.modules.nav_link.NavLinkMapper
import com.example.demo.modules.nav_link.model.AddForm
import com.example.demo.modules.nav_link.model.ResNavSimple
import com.example.demo.util.listToTree
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NavLinkServiceImpl : NavLinkService {

    @Autowired
    lateinit var navLinkDao: NavLinkDao


    @Autowired
    lateinit var navLinkMapper: NavLinkMapper

    @Autowired
    lateinit var categoryDao: CategoryDao

    override fun add(form: AddForm) {

        // TODO: 校验category是否存在
        val navLink = NavLink(
            name = form.name!!,
            url = form.url!!,
            categoryId = form.categoryId!!,
            logo = form.logo ?: "",
            sort = form.sort ?: 0,
            id = 0
        )

        navLinkMapper.insert(navLink)
    }

    override fun update(form: AddForm) {
        val uw = UpdateWrapper<NavLink>()
            .eq(NavLink::id.name, form.id)
            .set(NavLink::name.name, form.name)
            .set(NavLink::url.name, form.url)
            .set("category_id", form.categoryId)
            .set("updated_at", LocalDateTime.now())

        if (form.logo != null) {
            uw.set(NavLink::logo.name, form.logo)
        }

        if (form.sort != null) {
            uw.set(NavLink::sort.name, form.sort)
        }

        val ok = navLinkDao.update(uw)

        if (!ok) {
            throw AppException.actionFailError()
        }
    }

    // 删除
    override fun delete(ids: List<Long>) {
        val ok = navLinkDao.removeByIds(ids)

        if (!ok) {
            throw AppException.actionFailError()
        }
    }

    override fun getAll(): List<ResNavSimple> {

        val categories = categoryDao.list()
        val links = navLinkDao.list(QueryWrapper<NavLink>().orderBy(true, true, "sort"))

        val linkGroup = links.groupBy { it.categoryId }

//        val categoryGroup = categories.groupBy { it.pid }

        val navs = categories.map { category ->
            val links = linkGroup[category.id] ?: listOf()

            ResNavSimple(
                id = category.id,
                pid = category.pid,
                name = category.name,
                sort = category.sort,
                web = links.map { link ->
                    ResNavSimple.Web(
                        id = link.id,
                        name = link.name,
                        url = link.url,
                        logo = link.logo,
                        sort = link.sort
                    )
                }
            )
        }

        return listToTree(navs, false)
    }
}