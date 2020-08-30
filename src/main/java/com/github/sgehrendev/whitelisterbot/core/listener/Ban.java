package com.github.sgehrendev.whitelisterbot.core.listener;

import com.github.sgehrendev.whitelisterbot.core.BotManager;
import com.github.sgehrendev.whitelisterbot.core.Member;
import com.github.sgehrendev.whitelisterbot.listeners.BanListener;
import io.graversen.minecraft.rcon.MinecraftRcon;
import io.graversen.minecraft.rcon.commands.BanCommand;
import io.graversen.minecraft.rcon.commands.WhiteListCommand;
import io.graversen.minecraft.rcon.util.WhiteListModes;

import java.time.Duration;

public class Ban implements BanListener {

    BotManager manager;

    public Ban(BotManager manager) { this.manager = manager; }

    @Override
    public void onBanCommand(Member member) {
        //Add the Member to the whitelist using RCON
        manager.getMinecraftRconService().connectBlocking(Duration.ofSeconds(3));
        // After connecting, we can (crudely) fetch the underlying Minecraft RCON provider
        final MinecraftRcon minecraftRcon = manager.getMinecraftRconService().minecraftRcon().orElseThrow(IllegalStateException::new);
        final BanCommand banCommand = new BanCommand(member.getMinecraftUsername(), "You have been banned due to breaking rules");
        minecraftRcon.sendAsync(banCommand);
        System.out.println("User " + member.getMinecraftUsername() + " added to the whitelist.");
    }
}
