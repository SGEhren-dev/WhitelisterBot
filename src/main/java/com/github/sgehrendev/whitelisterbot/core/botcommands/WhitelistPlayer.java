package com.github.sgehrendev.whitelisterbot.core.botcommands;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Optional;

public class WhitelistPlayer implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message message = event.getMessage();
        if(message.getContent().contains("!whitelist")) {
            event.getMessage().addReaction(":thumbsup:");
            String user = getUsername(event.getMessageContent());
            event.getChannel().sendMessage("Awaiting approval to whitelist  " + user);

            //Here we need to message a moderator and wait for approval
            Optional<TextChannel> channel = event.getApi().getTextChannelById("717824828739944549");
            if(channel.isPresent()) {
                new MessageBuilder()
                        .append("Waiting for moderator to approve ")
                        .append(user, MessageDecoration.BOLD, MessageDecoration.UNDERLINE)
                        .append(" to be whitelisted! ")
                        .append("Please react with :white_check_mark: or :x:.")
                        .send(channel.get());

            }
        }
    }

    private String getUsername(String string) {
        String[] params = string.split(" ");
        return params[1];
    }
}