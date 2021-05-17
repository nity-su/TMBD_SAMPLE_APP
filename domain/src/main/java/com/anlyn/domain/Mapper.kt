package com.anlyn.domain

abstract open class Mapper<in E,T> {
    abstract fun mapFrom(from:E):T
}