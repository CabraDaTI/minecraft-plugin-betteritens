package org.cabradati.betteritens.utils.extensions

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataType
import org.cabradati.betteritens.App
import org.cabradati.betteritens.models.BetterItensType

fun ItemMeta.setBetterItemType(tipo: BetterItensType) {
    val identificador = NamespacedKey.fromString(App.NAMESPACEKEY_ITEM)
    persistentDataContainer.set(identificador!!, PersistentDataType.STRING, tipo.valor)
}

fun ItemMeta.getBetterItemType(): String {
    val identificador = NamespacedKey.fromString(App.NAMESPACEKEY_ITEM)
    return persistentDataContainer.get(identificador!!, PersistentDataType.STRING) ?: "null"
}

fun ItemMeta.isBetterItemType(tipo: BetterItensType): Boolean {
    return getBetterItemType() == tipo.valor
}