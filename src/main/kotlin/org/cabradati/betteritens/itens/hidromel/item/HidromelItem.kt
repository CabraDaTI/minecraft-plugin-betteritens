package org.cabradati.betteritens.itens.hidromel.item

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BlockDataMeta
import org.cabradati.betteritens.models.BetterItensType
import org.cabradati.betteritens.utils.extensions.setBetterItemType

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

            hidromelMeta.setBetterItemType(BetterItensType.HIDROMEL)

            hidromel.itemMeta = hidromelMeta

            return hidromel

        }
    }
}