package org.cabradati.betteritens

import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.betteritens.itens.hidromel.HidromelContainer
import org.cabradati.betteritens.utils.extensions.ItemContainer

class App : JavaPlugin() {

    companion object {
        const val ATIVAR_PLUGIN = "plugin.enabled"
        const val ATIVAR_DEBUG = "plugin.debug"
        const val ITEM_PREFIX = "item."
    }

    override fun onEnable() {

        config.addDefault(ATIVAR_PLUGIN, true)
        config.addDefault(ATIVAR_DEBUG, false)
        config.options().copyDefaults(true)

        val diContainer = DIContainer(
            this,
            server,
            config,
            logger
        )

        val listaContainer: List<ItemContainer> = listOf(
            HidromelContainer(diContainer)
        )

        listaContainer.forEach { config ->
            config.registerConfig()
        }

        if (config.getBoolean(ATIVAR_PLUGIN)) {

            listaContainer.forEach { config ->
                config.registerRecipe()
                config.registerEvents()
            }

        }

        saveConfig()

        super.onEnable()
    }

}