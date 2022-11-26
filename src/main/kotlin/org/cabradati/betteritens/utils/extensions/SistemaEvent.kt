package org.cabradati.betteritens.utils.extensions

interface SistemaEvent<T> {

    fun on(event: T)

}