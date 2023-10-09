package com.example.demo

import com.example.demo.property.JWTProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableConfigurationProperties(value = [JWTProperty::class])
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class DemoApplication {
	@Bean
	fun passwordEncoder(): BCryptPasswordEncoder {
		return BCryptPasswordEncoder()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
