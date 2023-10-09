package com.example.demo.modules.nav_link

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.model.NavLink
import org.springframework.stereotype.Service

@Service
class NavLinkDao : ServiceImpl<NavLinkMapper, NavLink>()