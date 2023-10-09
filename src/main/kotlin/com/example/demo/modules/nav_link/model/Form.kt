package com.example.demo.modules.nav_link.model

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AddForm(
    @field:NotNull(message = "name不能为空")
    @field:NotEmpty(message = "name不能为空")
    @field:Size(max = 255, message = "url长度在50字符内")
    val name: String?,

    @field:NotNull(message = "url不能为空")
    @field:NotEmpty(message = "url不能为空")
    @field:Size(max = 255, message = "url长度在255字符内")
    val url: String?,

    @field:NotNull(message = "categoryId不能为空")
    val categoryId: Long?,

    @field:Size(max = 255, message = "logo长度在255字符内")
    val logo: String?,

    @field:Min(0, message = "sort在0-9999范围内")
    @field:Max(9999, message = "sort在0-9999范围内")
    val sort: Int?,

    var id: Long? = null
)