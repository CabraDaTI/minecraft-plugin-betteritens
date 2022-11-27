package org.cabradati.betteritens.utils

interface SistemaEvent<T> {

    fun on(event: T)

}