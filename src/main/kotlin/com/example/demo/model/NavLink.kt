package com.example.demo.model

import com.baomidou.mybatisplus.annotation.*
import java.time.LocalDateTime

@TableName("nav_link")
data class NavLink(
    @TableId(type = IdType.AUTO)
    val id: Long = 0,

    val name: String = "",

    val url: String = "",

    val logo: String = "",

    val sort: Int = 0,

    @field:TableField(value = "category_id")
    val categoryId: Long = 0,

    @field:TableField("created_at", fill = FieldFill.INSERT)
    val createdAt: LocalDateTime? = null,

    @field:TableField("updated_at", fill = FieldFill.INSERT_UPDATE)
    val updatedAt: LocalDateTime? = null
)