package org.cabradati.betteritens.models

enum class BetterItensType(val valor: String) {
    HIDROMEL("hidromel");

    companion object {
        fun entryOf(valor: String): BetterItensType {

            return values().first { item ->
                item.valor == valor
            }

        }
    }
}