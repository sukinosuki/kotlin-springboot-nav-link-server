package com.example.demo.filter

import com.example.demo.common.AppException
import com.example.demo.components.thread_local.LocalUserContext
import com.example.demo.util.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// 预校验filter
// 1. 从header获取token, 如果不存在则通过
// 2. 解析token, token过期或者解析失败则通过, 解析成功得到用户id, 通过id从缓存对比token是否一致, 不一致(抛出未授权错误)表示太久没登录被其他用户登录了
@Order(20)
@Component
class PreAuthorizeFilter : OncePerRequestFilter() {

    @Autowired
    lateinit var localUserContext: LocalUserContext


    @Autowired
    lateinit var jwtUtil: JWTUtil

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        logger.info("预认证开始, token: $token")

        // 放行
        if (token == "" || token == null) {
            logger.info("[doFilterInternal] 没有获取到token")

            localUserContext.set(0, null, AppException.unAuthorizeError())

            filterChain.doFilter(request, response)

            return
        }

        val (claims, exception) = jwtUtil.parseToken(token)

        if (exception != null) {
            logger.info("解析token失败, e: $exception")
            localUserContext.set(0, null, exception)
        } else {
            logger.info("解析token成功, claims: $claims")

            // TODO: 用户登录时缓存用户信息到redis, 然后在这里从缓存获取，再设置到localUserContext里

            localUserContext.set(claims!!.subject.toLong(), null, null)
        }

        filterChain.doFilter(request, response)

        logger.info("预认证filter结束")
    }
}