package org.cabradati.betteritens.itens.hidromel.item

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BlockDataMeta

interface HidromelItem {
    companion object {
        fun buildItem(): ItemStack {

            val hidromel = ItemStack(Material.HONEY_BOTTLE)
            val hidromelMeta = hidromel.itemMeta as BlockDataMeta

            hidromelMeta.displayName(Component.text("Hidromel"))
            hidromelMeta.lore(
                listOf(
                    Component.text("nutritivo e levemente alcoolico")
                )
            )

            hidromelMeta.getBlockData(Material.HONEY_BOTTLE).hidromel.itemMeta = hidromelMeta

            return hidromel

        }
    }
}