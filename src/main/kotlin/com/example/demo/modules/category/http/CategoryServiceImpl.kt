package com.example.demo.modules.category.http

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import com.example.demo.common.AppException
import com.example.demo.model.Category
import com.example.demo.modules.category.CategoryDao
import com.example.demo.modules.category.CategoryMapper
import com.example.demo.modules.category.model.AddForm
import com.example.demo.modules.category.model.UpdateForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CategoryServiceImpl: CategoryService {

    @Autowired
    lateinit var categoryMapper: CategoryMapper

    @Autowired
    lateinit var categoryDao: CategoryDao

    // 新增
    override fun add(form: AddForm): Long {
        val category = Category(
            name = form.name,
            pid = form.pid ?: 0
        )

        categoryMapper.insert(category)

        return category.id
    }

    // 更新
    override fun update(form: UpdateForm) {

        val uw = UpdateWrapper<Category>()
            .eq(Category::id.name, form.id)
            .set(Category::name.name, form.name)
            // TODO:
            .set("updated_at", LocalDateTime.now())

        if (form.pid != null) {
            uw.set(Category::pid.name, form.pid)
        }
        if (form.sort != null) {
            uw.set(Category::sort.name, form.sort)
        }

        val ok = categoryDao.update(uw)

        // 更新失败，可能是id对应的数据被删除了
        if (!ok) {
            throw AppException.actionFailError()
        }

    }

    override fun delete(ids: List<Long>) {

        // TODO: 是否需要删除子级数据，是否不可删除有绑定数据的分类
        val ok = categoryDao.removeByIds(ids)

        if (!ok) {
            throw AppException.actionFailError()
        }
    }

    override fun getAll(): List<Category> {

        val list = categoryDao.list()

        return list
    }
}