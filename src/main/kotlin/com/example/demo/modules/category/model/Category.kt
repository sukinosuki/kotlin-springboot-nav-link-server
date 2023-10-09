package com.example.demo.modules.category.model

import com.example.demo.common.QueryOrder
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AddForm(
    @field:NotNull(message = "name不能为空")
    @field:NotEmpty(message = "name不能为空")
    @field:Size(min = 1, max = 50, message = "name长度在1-50字符内")
    val name: String?,

    val pid: Long?,

    val sort: Int?
)

data class UpdateForm(
    @field:NotNull(message = "name不能为空")
    @field:NotEmpty(message = "name不能为空")
    @field:Size(min = 1, max = 50, message = "name长度在1-50字符内")
    val name: String?,

    val pid: Long?,

    var id: Long = 0,

    val sort: Int?
)

data class QueryForm(
    val order: QueryOrder,
    val orderField: String = "order"
)