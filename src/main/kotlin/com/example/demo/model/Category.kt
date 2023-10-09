package com.example.demo.model

import com.baomidou.mybatisplus.annotation.*
import com.example.demo.common.BaseTree
import java.time.LocalDateTime

@TableName("category")
data class Category(
    @TableId(type = IdType.AUTO)
    override var id: Long = 0,

    val name: String = "",

    override var pid: Long = 0,

    val sort: Int = 0,

    @TableField("created_at", fill = FieldFill.INSERT)
    val createdAt: LocalDateTime? = null,

    @TableField("updated_at", fill = FieldFill.INSERT_UPDATE)
    val updatedAt: LocalDateTime? = null,

    @TableField(exist = false)
    override var children: List<Category>? = null
) : BaseTree<Category>
