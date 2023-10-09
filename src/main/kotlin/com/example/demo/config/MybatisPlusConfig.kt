package com.example.demo.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
class MybatisPlusConfig {

    // 配置mybatis plus分页
    // 需要配置分页才生效
    @Bean
    fun paginationInterception(): MybatisPlusInterceptor {
        val interceptor = MybatisPlusInterceptor()

        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))

        return interceptor
    }
}
