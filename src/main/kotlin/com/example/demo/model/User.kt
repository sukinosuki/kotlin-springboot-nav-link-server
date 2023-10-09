package com.example.demo.model

import com.baomidou.mybatisplus.annotation.*
import java.time.LocalDateTime

@TableName("user")
data class User(
    @TableId(type = IdType.AUTO)
    val id: Long = 0,

    val username: String,

    val password: String,

    @field:TableField("created_at", fill = FieldFill.INSERT)
    val createdAt: LocalDateTime? = null,

    @field:TableField("updated_at", fill = FieldFill.INSERT_UPDATE)
    val updatedAt: LocalDateTime? = null
)
