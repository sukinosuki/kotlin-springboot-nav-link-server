package com.example.demo.util

import com.example.demo.common.BaseTree
import java.util.stream.Collectors

fun <T : BaseTree<T>> listToTree(list: List<T>, nullableEmptyChildren: Boolean = true): List<T> {
    val zoneByParentIdMap: Map<String, List<T>> =
        list.stream().collect(Collectors.groupingBy { it.pid.toString() })

    list.forEach { zone ->
        println("zone $zone")

        val list = zoneByParentIdMap[zone.id.toString()]
        if (nullableEmptyChildren) {
            zone.children = list
        } else {
            zone.children = list ?: listOf()
        }
    }

//        val stream = menuList.stream()
//
//        val filter1 = stream.filter { v ->
//            val b = v.pid.equals(0)
//
//            println("b $b")
//            b
//        }
//
//        return filter1.collect(Collectors.toList())

    return list.filter { it.pid == 0L }
}