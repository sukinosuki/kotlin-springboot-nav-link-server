package com.example.demo.modules.nav_link.http

import com.example.demo.common.R
import com.example.demo.components.annotation.NeedAuth
import com.example.demo.modules.nav_link.model.AddForm
import com.example.demo.modules.nav_link.model.NavLinkMapperGetAllResult
import com.example.demo.modules.nav_link.model.ResNavSimple
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
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api/v1/nav-link")
class NavLinkController {

    @Autowired
    lateinit var navLinkService: NavLinkService

    @NeedAuth
    @PostMapping
    fun add(@Valid @RequestBody @NotNull form: AddForm): R<Nothing> {

        navLinkService.add(form)

        return R.ok()
    }

    @NeedAuth
    @PutMapping("/{id}")
    fun update(@Valid @RequestBody @NotNull form: AddForm, @PathVariable id: Long): R<Nothing> {
        form.id = id

        navLinkService.update(form)

        return R.ok()
    }

    @NeedAuth
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): R<Nothing> {
        navLinkService.delete(listOf(id))

        return R.ok()
    }

    @NeedAuth
    @GetMapping
    fun getAll(): R<List<ResNavSimple>> {

        val all = navLinkService.getAll()

        return R.ok(all)
    }
}