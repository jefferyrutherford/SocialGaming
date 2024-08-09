package com.SocialGaming.DiscordEvents;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;


import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DiscordReadyEventListener implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        // if the
        if (event instanceof ReadyEvent) {
            System.out.print("The bot is read and online!");
            InitAdminChannel(event.getJDA().getGuilds());
        } else if (event instanceof GuildJoinEvent) {
            InitAdminChannel(event.getJDA().getGuilds());
        }
    }

    private void InitAdminChannel(List<Guild> guilds) {
        guilds.forEach(guild -> {
            AtomicReference<Boolean> channelExists = new AtomicReference<>(false);

            if (guild.getTextChannelsByName("Game Night Admin", false).isEmpty()) {
                TextChannel textChannel = guild.createTextChannel("Game Night Admin").complete();
                textChannel.sendMessage("Game Night Admin Created.").queue();
                textChannel.sendMessage("Discord Server is connected to Game Night Bot").queue();
            }
            ;
        });
    }
}
