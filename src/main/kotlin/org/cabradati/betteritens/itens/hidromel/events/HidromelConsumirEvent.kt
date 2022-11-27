package org.cabradati.betteritens.itens.hidromel.events

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.cabradati.betteritens.DIContainer
import org.cabradati.betteritens.itens.hidromel.HidromelConsts
import org.cabradati.betteritens.models.BetterItensType
import org.cabradati.betteritens.utils.SistemaEvent
import org.cabradati.betteritens.utils.extensions.getBetterItemType
import org.cabradati.betteritens.utils.extensions.isBetterItemType

class HidromelConsumirEvent(private val diContainer: DIContainer) : Listener, SistemaEvent<PlayerItemConsumeEvent> {

    private val parametroNutricao = diContainer.config.getInt(HidromelConsts.NUTRICAO)

    @EventHandler(priority = EventPriority.LOW)
    override fun on(event: PlayerItemConsumeEvent) {
        if (event.item.itemMeta.isBetterItemType(BetterItensType.HIDROMEL)) {
            diContainer.log(event.item.itemMeta.getBetterItemType())
        }
    }

}