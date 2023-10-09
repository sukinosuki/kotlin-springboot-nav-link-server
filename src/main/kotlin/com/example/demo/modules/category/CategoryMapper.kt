package com.example.demo.modules.category

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.model.Category
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryMapper: BaseMapper<Category>