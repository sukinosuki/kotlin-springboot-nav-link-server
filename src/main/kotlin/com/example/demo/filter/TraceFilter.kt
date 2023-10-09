package com.example.demo.filter

import com.example.demo.components.thread_local.TraceIdContext
import com.example.demo.util.generateTraceId
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.AbstractRequestLoggingFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Order(10)
@Component
class TraceFilter : AbstractRequestLoggingFilter() {

    val headerTraceIdKey = "trace-id"

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val traceId = generateTraceId()

        logger.info("trace 请求开始, trace id: $traceId")

        response.setHeader(headerTraceIdKey, traceId)
        TraceIdContext.setTraceId(traceId)

        super.doFilterInternal(request, response, filterChain)
    }

    override fun beforeRequest(request: HttpServletRequest, message: String) {

    }

    override fun afterRequest(request: HttpServletRequest, message: String) {
        val traceId = TraceIdContext.getTraceId()

        logger.info("trace 请求结束, trace id: $traceId")
        TraceIdContext.clearTraceId()
    }
}