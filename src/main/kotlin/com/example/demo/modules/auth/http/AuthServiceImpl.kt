package com.example.demo.modules.auth.http

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.example.demo.common.AppException
import com.example.demo.model.User
import com.example.demo.modules.auth.UserDao
import com.example.demo.modules.auth.UserMapper
import com.example.demo.modules.auth.model.LoginRes
import com.example.demo.modules.auth.model.RegisterForm
import com.example.demo.util.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {

    @Autowired
    lateinit var userDao: UserDao

    @Autowired
    lateinit var userMapper: UserMapper

    @Autowired
    lateinit var jwtUtil: JWTUtil

    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    override fun register(form: RegisterForm): String {
        val user = User(
            username = form.username!!,
            password = passwordEncoder.encode(form.password!!)
        )

        val ok = userDao.save(user)
        if (!ok) {
            throw AppException.actionFailError()
        }

        val token = jwtUtil.createToken(user.id)

        return token
    }

    override fun login(form: RegisterForm): String {
        val qw = QueryWrapper<User>().eq(User::username.name, form.username).last("LIMIT 1")
        // user可能为null
        val user = userDao.getOne(qw, true) ?: throw AppException.loginError()

        val ok = passwordEncoder.matches(form.password, user.password)
        if (!ok) {
            throw AppException.loginError()
        }

        val token = jwtUtil.createToken(user.id)

        return token

    }
}