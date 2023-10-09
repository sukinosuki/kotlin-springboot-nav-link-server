package com.example.demo.components.thread_local

import com.example.demo.common.LocalUser
import com.example.demo.model.User
import org.springframework.stereotype.Component


@Component
class LocalUserContext {

    val local = ThreadLocal<LocalUser>()

    fun set(id: Long, user: User? = null, exception: Exception? = null) {

        local.set(LocalUser(id, user, exception))
    }

    fun get(): LocalUser {
        return local.get() ?: LocalUser(id = 0)
    }

    fun clear() {
        local.remove()
    }
}