package com.SocialGaming;

import com.SocialGaming.discordEvents.DiscordReadyEventListener;
import com.SocialGaming.discordEvents.DiscordCommandsEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.redis.core.RedisTemplate;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class SocialGamingApplication {

   /* @Autowired
    private RedisTemplate<String, String> redisTemplate;*/

    public static void main(String[] args) throws LoginException {

        SpringApplication.run(SocialGamingApplication.class, args);
/*
        final String TOKEN = "**";
        final String SERVER_ID = "**";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);


        JDA jda = jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new DiscordReadyEventListener(), new DiscordCommandsEventListener())
                .build();*/
    }
}
