package org.cabradati.betteritens.itens.hidromel

import org.bukkit.NamespacedKey
import org.cabradati.betteritens.DIContainer
import org.cabradati.betteritens.itens.hidromel.events.HidromelConsumirEvent
import org.cabradati.betteritens.itens.hidromel.item.HidromelItem
import org.cabradati.betteritens.itens.hidromel.recipes.HidromelRecipe
import org.cabradati.betteritens.utils.ItemContainer

class HidromelContainer(private val diContainer: DIContainer) : ItemContainer {

    private val parametroAtivarItem = diContainer.config.getBoolean(HidromelConsts.ATIVAR_ITEM)

    override fun registerConfig() {

        val config = diContainer.config
        val plugin = diContainer.plugin

        diContainer.log("item - hidromel - registrando configurações")
        config.addDefault(HidromelConsts.ATIVAR_ITEM, true)
        config.addDefault(HidromelConsts.NUTRICAO, 10)
        config.options().copyDefaults(true)
        plugin.saveConfig()

    }

    override fun registerEvents() {
        if (!parametroAtivarItem) {
            diContainer.log("item - hidromel - item está desativado, nenhum evento será registrado")
        }

        val plugin = diContainer.plugin
        val server = diContainer.server

        diContainer.log("item - hidromel - registrando eventos")
        server.pluginManager.registerEvents(
            HidromelConsumirEvent(diContainer),
            plugin
        )

    }

    override fun registerRecipe() {
        if (!parametroAtivarItem) {
            diContainer.log("item - hidromel - item está desativado, nenhum recipe será registrado")
        }

        val plugin = diContainer.plugin
        val server = diContainer.server

        diContainer.log("item - hidromel - registrando recipe")
        val key = NamespacedKey(plugin, "hidromel")
        val item = HidromelItem.buildItem()
        val recipe = HidromelRecipe.build(key, item)

        server.addRecipe(recipe)

    }

}