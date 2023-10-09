package com.example.demo.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime

//自动填充: https://baomidou.com/pages/4c6bcf/
@Component
class MybatisMetaObjectHandler : MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject?) {
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime::class.java, LocalDateTime.now())
        this.strictInsertFill(metaObject, "updatedAt", LocalDateTime::class.java, LocalDateTime.now())
    }

    override fun updateFill(metaObject: MetaObject?) {
        this.strictInsertFill(metaObject, "updatedAt", LocalDateTime::class.java, LocalDateTime.now())
    }
}