package org.cabradati.betteritens.itens.hidromel.item

import net.kyori.adventure.text.Component
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.cabradati.betteritens.models.BetterItensType
import org.cabradati.betteritens.utils.extensions.setBetterItemType

interface HidromelItem {
    companion object {
        fun buildItem(): ItemStack {

            val hidromel = ItemStack(Material.POTION)
            val hidromelMeta = hidromel.itemMeta as PotionMeta

            hidromelMeta.displayName(Component.text("Hidromel"))
            hidromelMeta.lore(
                listOf(
                    Component.text("nutritivo e levemente alcoolico")
                )
            )

            hidromelMeta.color = Color.YELLOW
            hidromelMeta.addCustomEffect(PotionEffect(PotionEffectType.BLINDNESS, 100, 2), true)
            hidromelMeta.setBetterItemType(BetterItensType.HIDROMEL)
            hidromelMeta.itemFlags.add(ItemFlag.HIDE_POTION_EFFECTS)
            hidromel.maxStackSize

            hidromel.itemMeta = hidromelMeta

            return hidromel

        }
    }
}