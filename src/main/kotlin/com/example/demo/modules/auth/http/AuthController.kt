package com.example.demo.modules.auth.http

import com.example.demo.common.R
import com.example.demo.modules.auth.model.RegisterForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api/v1/auth")
class AuthController {

    @Autowired
    lateinit var authService: AuthService

    @PostMapping("/register")
    fun register(@Valid @RequestBody @NotNull form: RegisterForm): R<String> {

        val token = authService.register(form)

        return R.ok(token)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody @NotNull form: RegisterForm): R<String> {
        val token = authService.login(form)

        return R.ok(token)
    }
}