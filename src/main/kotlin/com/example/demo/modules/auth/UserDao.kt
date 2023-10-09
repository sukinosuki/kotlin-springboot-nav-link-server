package com.example.demo.modules.auth

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.model.User
import org.springframework.stereotype.Service

@Service
class UserDao: ServiceImpl<UserMapper, User>()