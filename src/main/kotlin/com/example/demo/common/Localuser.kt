package com.example.demo.common

import com.example.demo.model.User

data class LocalUser(
    var id: Long,
    var user: User? = null,
    var exception: Exception? = null
) {
    fun isAuthorized(): Boolean {
        return id.toInt() != 0
    }
}
