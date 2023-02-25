package com.lpbigfish.kycm.listeners;

import com.lpbigfish.kycm.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onDisconnect implements Listener {

    private final Main plugin;

    public onDisconnect(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDisconnectEvent(PlayerQuitEvent event) {
        plugin.waitingList.remove(event.getPlayer().getName());
    }
}
