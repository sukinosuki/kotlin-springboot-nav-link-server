package com.example.demo.modules.category.http

import com.example.demo.model.Category
import com.example.demo.common.R
import com.example.demo.modules.category.model.AddForm
import com.example.demo.modules.category.model.UpdateForm
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/category")
class CategoryController {

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping
    fun getAll(): R<List<Category>> {

        val list = categoryService.getAll()

        return R.ok(list)
    }

    @PostMapping
    fun add(@Valid @RequestBody @NotNull form: AddForm): R<Nothing> {

        categoryService.add(form)

        return R.ok()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody form: UpdateForm): R<Nothing> {
        form.id = id

        categoryService.update(form)

        return R.ok()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): R<NotNull> {
        categoryService.delete(listOf(id))

        return R.ok()
    }
}