package com.example.demo.modules.auth.model

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RegisterForm(
    @field:NotNull(message = "username不能为空")
    @field:NotEmpty(message = "username不能为空")
    @field:Size(min = 2, max = 12, message = "username在2-12字符内")
    val username: String?,

    @field:NotNull(message = "password不能为空")
    @field:NotEmpty(message = "password不能为空")
    @field:Size(min = 2, max = 12, message = "password在4-12字符内")
    val password: String?
)