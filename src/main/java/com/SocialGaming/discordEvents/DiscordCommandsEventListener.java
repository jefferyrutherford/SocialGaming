package com.SocialGaming.discordEvents;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DiscordCommandsEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        event.getName();

            switch (event.getName()) {
                case "create":
                    if (!event.getChannel().getName().equals("game-night-admin")) {
                        event.getChannel().
                                sendMessage("invalid command: wrong channel")
                                .queue();
                        break;
                    }
                    event.getChannel().sendMessage("Create tournament hit").queue();
                    break;
                default:
                    event.getChannel().sendMessage("invalid command").queue();
                    break;
            }
        }

    }

