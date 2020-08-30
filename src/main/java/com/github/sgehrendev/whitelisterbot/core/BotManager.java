package com.github.sgehrendev.whitelisterbot.core;

import com.github.sgehrendev.whitelisterbot.listeners.Listener;
import com.github.sgehrendev.whitelisterbot.listeners.RegisterListener;
import io.graversen.minecraft.rcon.service.ConnectOptions;
import io.graversen.minecraft.rcon.service.MinecraftRconService;
import io.graversen.minecraft.rcon.service.RconDetails;

import java.util.List;

public class BotManager {

    //Create a new RegisterListener to get the Listeners
    private RegisterListener registerListener = new RegisterListener();

    final MinecraftRconService minecraftRconService = new MinecraftRconService(RconDetails.localhost("test"), ConnectOptions.defaults());

    public void addListeners(Listener listener) {
        registerListener.addListener(listener);
    }

    public List<Listener> getListeners() {
        return registerListener.getListeners();
    }

    public void callWhiteListCommand(Member member, String s) {
        registerListener.callWhitelistListener(member, s);
    }

    public void callBanCommand(Member member) {
        registerListener.callBanListener(member);
    }

    public MinecraftRconService getMinecraftRconService() { return this.minecraftRconService; }
}
