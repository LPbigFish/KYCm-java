package com.lpbigfish.kycm;

import com.lpbigfish.kycm.listeners.onDisconnect;
import com.lpbigfish.kycm.listeners.onJoin;
import com.lpbigfish.kycm.listeners.onMove;
import com.lpbigfish.kycm.rest.ApiConnection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    public List<String> waitingList;
    public ApiConnection apiConnection;

    @Override
    public void onEnable() {
        //Config init
        saveDefaultConfig();
        //Api connection init
        apiConnection = new ApiConnection(this);

        //Listeners init
        getServer().getPluginManager().registerEvents(new onJoin(this), this);
        getServer().getPluginManager().registerEvents(new onDisconnect(this), this);
        getServer().getPluginManager().registerEvents(new onMove(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
