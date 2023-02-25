package com.lpbigfish.kycm;

import com.google.inject.Inject;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import com.velocitypowered.api.proxy.messages.ChannelMessageSource;
import org.slf4j.Logger;

@Plugin(
        id = "KYCM",
        name = "KYCM",
        version = "1.0-SNAPSHOT",
        description = "A Velocity side of a KYC bundle",
        authors = {"LPbigFish"}
)
public class Main {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {

    }

    @Subscribe
    public void onMessageReceived(PluginMessageEvent event) {

    }
}
