package com.example.demo.modules.nav_link.model

import com.baomidou.mybatisplus.annotation.TableField
import com.example.demo.common.BaseTree
import com.fasterxml.jackson.annotation.JsonIgnore

data class ResNavSimple(
    override var id: Long = 0,

    override var pid: Long = 0,

    var name: String = "",

    var sort: Int = 0,

    @JsonIgnore
    var webName: String = "",
    @JsonIgnore
    var webUrl: String = "",
    @JsonIgnore
    var webLogo: String = "",
    @JsonIgnore
    var webSort: Int = 0,
    @JsonIgnore
    var webCategoryId: Long = 0,
    @JsonIgnore
    var webId: Long = 0,

    @TableField(exist = false)
    override var children: List<ResNavSimple>? = listOf(),

    @TableField(exist = false)
    var web: List<Web> = listOf()
): BaseTree<ResNavSimple> {

    data class Web(
        val name: String,
        val url: String,
        val logo: String,
        val sort: Int,
        val id: Long
    )
}

data class NavLinkMapperGetAllResult(
    val cId: Long?,

    val cSort: Int?,

    val cPid: Long?,

    val cName: String?,

    val lLogo: String?,

    val lUrl: String?,

    val lId: Long?,

    val lName: String?,

    val lSort: Int?,

    val lCategoryId: Long?
)
