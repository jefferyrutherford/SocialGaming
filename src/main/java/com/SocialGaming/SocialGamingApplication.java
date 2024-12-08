package com.SocialGaming;

import com.SocialGaming.DiscordEvents.DiscordReadyEventListener;
import com.SocialGaming.DiscordEvents.DiscordCommandsEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class SocialGamingApplication {

    public static void main(String[] args) throws LoginException {

        SpringApplication.run(SocialGamingApplication.class, args);

        final String TOKEN = "MTE0Mzc0NDY3MTIzNTk3NzI4Nw.Gy-OPs.53JhurRc5rQkbEuaMczFjdbRp3pEmJWappbfew";
        final String SERVER_ID = "1143758964065054820";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);


        JDA jda = jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new DiscordReadyEventListener(), new DiscordCommandsEventListener())
                .build();
    }
}
