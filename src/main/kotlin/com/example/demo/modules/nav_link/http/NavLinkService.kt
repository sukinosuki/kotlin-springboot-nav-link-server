package com.example.demo.modules.nav_link.http

import com.example.demo.modules.nav_link.model.AddForm
import com.example.demo.modules.nav_link.model.NavLinkMapperGetAllResult
import com.example.demo.modules.nav_link.model.ResNavSimple

interface NavLinkService {

    fun add(form: AddForm)

    fun update(form: AddForm)

    fun delete(ids: List<Long>)

    fun getAll(): List<ResNavSimple>
}