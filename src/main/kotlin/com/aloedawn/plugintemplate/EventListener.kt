package io.yutari.plugintemplate

import net.kyori.adventure.text.Component.text
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class EventListener: Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        e.joinMessage(text("${e.player.name}가 입장!"))
    }

    @EventHandler
    fun onPlayerLeave(e: PlayerQuitEvent) {
        e.quitMessage(text("${e.player.name}가 퇴장!"))
    }
}