package com.github.sgehrendev.whitelisterbot.core;

import com.github.sgehrendev.whitelisterbot.core.botcommands.WhitelistPlayer;
import com.vdurmont.emoji.EmojiParser;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Bot extends Thread{

    public static String username = null;

    public void run() {
        String token = "";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addListener(new WhitelistPlayer());

        api.addReactionAddListener(event -> {
            if(event.getEmoji().equalsEmoji(EmojiParser.parseToUnicode(":white_check_mark:"))) {
                //Check if the channel the command was fired in is the proper channel
                if(event.getChannel().equals(api.getChannelById("717824828739944549"))) {
                    event.getChannel().sendMessage("This person will now be added to the whitelist!");
                    //Fire the onWhitelistCommand here
                    manager.callWhiteListCommand(new Member(username, username), "add");
                }
            } else if(event.getEmoji().equalsEmoji(EmojiParser.parseToUnicode(":x:"))) {
                if(event.getChannel().equals(api.getChannelById("717824828739944549"))) {
                    event.getChannel().sendMessage("This person will not be added to the whitelist!");
                }
            }
        });
        //Print the url of the bot
        System.out.println("Invite the bot using: " + api.createBotInvite());
    }

    BotManager manager;

    protected Member callingMember = null;

    public Bot(BotManager manager) { this.manager = manager; }

    public Member getCallingMember() { return callingMember; }
}
