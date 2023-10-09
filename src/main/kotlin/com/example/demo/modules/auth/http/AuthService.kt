package com.example.demo.modules.auth.http

import com.example.demo.modules.auth.model.LoginRes
import com.example.demo.modules.auth.model.RegisterForm

interface AuthService {

    fun register(form: RegisterForm): String

    fun login(form: RegisterForm): String
}