package com.example.demo.common

interface BaseTree<T> {

    var id: Long

    var pid: Long

    var children: List<T>?
}