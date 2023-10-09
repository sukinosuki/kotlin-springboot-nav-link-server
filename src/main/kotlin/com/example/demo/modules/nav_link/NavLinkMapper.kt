package com.example.demo.modules.nav_link

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.model.NavLink
import com.example.demo.modules.nav_link.model.NavLinkMapperGetAllResult
import com.example.demo.modules.nav_link.model.ResNavSimple
import org.apache.ibatis.annotations.Mapper

@Mapper
interface NavLinkMapper : BaseMapper<NavLink> {

    fun getAll(): List<ResNavSimple>
}