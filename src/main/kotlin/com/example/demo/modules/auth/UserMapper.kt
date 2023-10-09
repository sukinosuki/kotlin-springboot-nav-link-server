package com.example.demo.modules.auth

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.model.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User>