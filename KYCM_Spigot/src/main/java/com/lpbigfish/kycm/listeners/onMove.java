package com.lpbigfish.kycm.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.net.URLConnection;

public class onMove implements Listener {
    @EventHandler
    public void onMoveEvent(PlayerMoveEvent event) {
        event.setCancelled(true);
        event.getPlayer().teleport(event.getFrom());
    }
}
