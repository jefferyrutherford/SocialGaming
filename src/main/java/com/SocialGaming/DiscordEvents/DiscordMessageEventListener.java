package com.SocialGaming.DiscordEvents;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DiscordMessageEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (!event.getAuthor().isBot()) {
            super.onMessageReceived(event);
            event.getChannel().sendMessage("We can send a message back !!!!!!!").queue();
            System.out.println("User Sent: " + event.getMessage().getContentDisplay());

            Guild guild = event.getGuild();

            System.out.println(guild.getChannels());
        }
    }
}
