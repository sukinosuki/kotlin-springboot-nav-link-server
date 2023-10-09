package com.example.demo.common

import com.fasterxml.jackson.annotation.JsonValue

enum class QueryOrder(
    override var label: String = "asc",
    @get:JsonValue override var value: String = "asc"
) : ILabelValue {

    ASC("asc", "asc"),

    DESC("desc", "desc");

    fun isAsc(): Boolean {
        return this.value == ASC.value
    }
}