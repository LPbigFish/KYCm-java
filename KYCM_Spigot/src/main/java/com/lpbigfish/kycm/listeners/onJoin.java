package com.lpbigfish.kycm.listeners;

import com.lpbigfish.kycm.Main;
import com.lpbigfish.kycm.rest.ApiConnection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class onJoin implements Listener {

    private final Main plugin;
    public onJoin(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        plugin.waitingList.add(event.getPlayer().getName());
        plugin.getServer().getScheduler().runTaskLaterAsynchronously(plugin, () -> {
            if (plugin.waitingList.contains(event.getPlayer().getName())) {
                if (checkVerification(event.getPlayer().getName())) {
                    event.getPlayer().sendMessage("You are verified!");
                } else {
                    event.getPlayer().kickPlayer("You are not verified!");
                }
            }
        }, 20 * 10);
    }

    private boolean checkVerification(String playerName) {
        return ApiConnection.getResponse(playerName) == 200;
    }

    private void constatCheck() {
        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            for (String playerName : plugin.waitingList) {
                if (checkVerification(playerName)) {
                    Objects.requireNonNull(plugin.getServer().getPlayer(playerName)).kickPlayer("You are verified!");
                    plugin.waitingList.remove(playerName);
                }
            }
        }, 20 * 10, 20 * 10);
    }
}
