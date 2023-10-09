package com.example.demo.modules.category

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.model.Category
import org.springframework.stereotype.Service

@Service
class CategoryDao : ServiceImpl<CategoryMapper, Category>() {

}