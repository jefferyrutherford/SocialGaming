package com.SocialGaming.DiscordEvents;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class DiscordReadyEventListener implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof ReadyEvent) System.out.print("The bot is read and online!");
    }
}
