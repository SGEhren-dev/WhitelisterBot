package com.github.sgehrendev.whitelisterbot.core.listener;

import com.github.sgehrendev.whitelisterbot.core.BotManager;
import com.github.sgehrendev.whitelisterbot.core.Member;
import com.github.sgehrendev.whitelisterbot.listeners.WhitelistListener;
import io.graversen.minecraft.rcon.MinecraftRcon;
import io.graversen.minecraft.rcon.commands.WhiteListCommand;
import io.graversen.minecraft.rcon.util.WhiteListModes;

import java.time.Duration;

public class Whitelist implements WhitelistListener {

    BotManager manager;

    public Whitelist(BotManager manager) { this.manager = manager; }

    @Override
    public void onWhitelistCommand(Member member, String s) {
        if(s.equalsIgnoreCase("add")) {
            //Add the Member to the whitelist using RCON
            manager.getMinecraftRconService().connectBlocking(Duration.ofSeconds(3));
            // After connecting, we can (crudely) fetch the underlying Minecraft RCON provider
            final MinecraftRcon minecraftRcon = manager.getMinecraftRconService().minecraftRcon().orElseThrow(IllegalStateException::new);
            final WhiteListCommand whiteListCommand = new WhiteListCommand(WhiteListModes.ADD, member.getMinecraftUsername());
            minecraftRcon.sendAsync(whiteListCommand);
            System.out.println("User " + member.getMinecraftUsername() + " added to the whitelist.");
        } else {
            //Remove the Member from the whitelist using RCON
            manager.getMinecraftRconService().connectBlocking(Duration.ofSeconds(3));
            // After connecting, we can (crudely) fetch the underlying Minecraft RCON provider
            final MinecraftRcon minecraftRcon = manager.getMinecraftRconService().minecraftRcon().orElseThrow(IllegalStateException::new);
            final WhiteListCommand whiteListCommand = new WhiteListCommand(WhiteListModes.REMOVE, member.getMinecraftUsername());
            minecraftRcon.sendAsync(whiteListCommand);
            System.out.println("User " + member.getMinecraftUsername() + " removed from the whitelist.");
        }
    }
}
