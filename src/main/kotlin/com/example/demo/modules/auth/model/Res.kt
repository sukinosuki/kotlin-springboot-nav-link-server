package com.example.demo.modules.auth.model

data class LoginRes(

    val user: User,
    val token: String
) {
    data class User(
        val username: String
    )
}