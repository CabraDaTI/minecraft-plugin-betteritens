package org.cabradati.betteritens.itens.hidromel.events

import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.cabradati.betteritens.DIContainer
import org.cabradati.betteritens.itens.hidromel.HidromelConsts
import org.cabradati.betteritens.utils.extensions.SistemaEvent

class HidromelConsumirEvent(private val diContainer: DIContainer) : Listener, SistemaEvent<PlayerItemConsumeEvent> {

    private val parametroNutricao = diContainer.config.getInt(HidromelConsts.NUTRICAO)

    @EventHandler(priority = EventPriority.LOW)
    override fun on(event: PlayerItemConsumeEvent) {
        diContainer.log(event.item.displayName().contains(Component.text("Hidromel")).toString())
        if (event.item.displayName().equals("Hidromel")) {
            event.player.foodLevel.plus(parametroNutricao)
            event.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 1000, 1))
        }
    }

}