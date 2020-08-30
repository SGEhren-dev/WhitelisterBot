package com.github.sgehrendev.whitelisterbot.core;

import com.github.sgehrendev.whitelisterbot.core.listener.Ban;
import com.github.sgehrendev.whitelisterbot.core.listener.Whitelist;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Core {

    protected static final BotManager botManager = new BotManager();

    public static void main(String[] args) {
        System.out.println("Starting discord bot controller....");
        System.out.println("Created By: SG_Ehren-dev");
        System.out.println("Build: 1.0-SNAPSHOT");
        System.out.println("Date: 08/29/2020\n");

        System.out.println("Registering Events...");
        //Here we will register the events prior to starting the command input
        getBotManager().addListeners(new Whitelist(getBotManager()));
        getBotManager().addListeners(new Ban(getBotManager()));

        Bot bot = new Bot(getBotManager());
        bot.start();

        System.out.println("Bot has been started...");

        //Create the scanner to accept input
        Scanner scanner = new Scanner(System.in);
        try {
            while(true) {
                String line = scanner.nextLine();
                //Add support for the "hook" command
                if(line.equalsIgnoreCase("hook")) {
                    //Create the new Jar and "hook" into the Spigot console
                } else if(line.equalsIgnoreCase("stop")) {
                    System.out.println("Stopping the program...");
                    break;
                } else if(line.equalsIgnoreCase("accept")) {

                } else if(line.equalsIgnoreCase("deny")) {

                } else if(line.equalsIgnoreCase("whitelist")) {
                    System.out.println("Please use whitelist [add | remove]");
                } else if(line.contains("whitelist add")) {
                    //Add the user to the whitelist using RCON
                    System.out.println("Adding user to whitelist!");
                    getBotManager().callWhiteListCommand(new Member(getNameFromWhitelistCommand(line), getNameFromWhitelistCommand(line)), "add");
                } else if(line.contains("whitelist remove")) {
                    //Remove the user from the whitelist using RCON
                    System.out.println("Removing user from whitelist...");
                    getBotManager().callWhiteListCommand(new Member(getNameFromWhitelistCommand(line), getNameFromWhitelistCommand(line)), "remove");
                } else if(line.contains("ban")) {
                    //Ban the user from the Minecraft server
                    System.out.println("Banning user from server...");
                    getBotManager().callBanCommand(new Member(getNameFromBanCommand(line), getNameFromBanCommand(line)));
                } else {
                    System.out.println("Unknown command! Please see the documentation for supported commands");
                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    private static BotManager getBotManager() {
        return botManager;
    }

    private static String getNameFromWhitelistCommand(String string) {
        String[] parsed = string.split(" ");
        return parsed[2];
    }

    private static String getNameFromBanCommand(String string) {
        String[] parsed = string.split(" ");
        return parsed[1];
    }
}
