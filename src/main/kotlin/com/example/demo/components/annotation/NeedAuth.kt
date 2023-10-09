package com.example.demo.components.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class NeedAuth(
    val title: String = "",
)

