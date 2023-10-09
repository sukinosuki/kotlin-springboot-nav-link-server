package com.example.demo.modules.category.http

import com.example.demo.model.Category
import com.example.demo.modules.category.model.AddForm
import com.example.demo.modules.category.model.UpdateForm

interface CategoryService {

    fun add(form: AddForm): Long

    fun update(form: UpdateForm)

    fun getAll(): List<Category>

    fun delete(ids: List<Long>)
}