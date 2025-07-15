package com.SocialGaming.discordEvents;


import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;


import java.awt.*;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DiscordReadyEventListener implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        // if the
        if (event instanceof ReadyEvent) {
            System.out.print("The bot is online!");
            //InitAdminChannel(event.getJDA().getGuilds());
        } else if (event instanceof GuildJoinEvent) {
            //InitAdminChannel(event.getJDA().getGuilds());
        }
    }

    private void InitAdminChannel(List<Guild> guilds) {
        guilds.forEach(guild -> {
            System.out.println(guild.getChannels());
            AtomicReference<Boolean> channelExists = new AtomicReference<>(false);

            Role role = guild.createRole().setName("game-night-admin").setColor(Color.red).setHoisted(true).setMentionable(false).complete();

            String adminId = null;

            if (guild.getTextChannelsByName("game-night-admin", true).isEmpty()) {
                TextChannel textChannel = guild.createTextChannel("game night admin")
                        .addPermissionOverride(role, EnumSet.of(Permission.VIEW_CHANNEL),null)
                        .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                        .complete();
                textChannel.sendMessage("Game Night Admin Created.").queue();
                textChannel.sendMessage("Discord Server is connected to Game Night Bot").queue();

                adminId = textChannel.getId();
            }
            else {
                adminId = guild.getTextChannelsByName("game-night-admin", true).get(0).getId();
            }


            guild

                    .upsertCommand("create", "Brings up gui to build out a tournament (Admin Only Channel)")
                    .addOptions(
                            new OptionData(OptionType.STRING, "type", "type of form to select")
                                    .addChoice("tournament", "tournament")
                                    .addChoice("game night", "gameNight")
                                    .addChoice("league", "league")
                    )
                    .queue();
        });
    }
}
