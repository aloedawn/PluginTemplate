package io.yutari.plugintemplate

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class MainClass: JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        logger.info("Hello World")
        Bukkit.getServer().pluginManager.registerEvents(EventListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}