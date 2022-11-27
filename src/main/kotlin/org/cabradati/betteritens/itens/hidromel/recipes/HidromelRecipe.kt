package org.cabradati.betteritens.itens.hidromel.recipes

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapedRecipe

class HidromelRecipe {
    companion object {
        fun build(namespacedKey: NamespacedKey, item: ItemStack): Recipe {

            val recipe = ShapedRecipe(namespacedKey, item)

            recipe.shape("T", "M", "G")
            recipe.setIngredient('T', Material.WHEAT)
            recipe.setIngredient('M', Material.HONEYCOMB)
            recipe.setIngredient('G', Material.GLASS_BOTTLE)

            return recipe

        }
    }
}