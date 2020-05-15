package org.kilocraft.kilocord;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BotManager {

    public static void main(String[] args) throws LoginException{
        new BotManager();
    }

    private BotManager() throws LoginException {
        final Logger logger = LoggerFactory.getLogger(BotManager.class);

        try {
            String ipAdress = InetAddress.getLocalHost().getHostAddress();

            String token = "token";
            String info = "Started production bot";

            if (ipAdress.equals(EnvHandler.get("devIp"))) {
                token = "devToken";
                info = "Started developer bot";
            }

            DefaultShardManagerBuilder
                    .create(EnvHandler.get(token), GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .addEventListeners(new eventListener())
                    .setActivity(Activity.playing("20w20b"))
                    .build();
            logger.info(info);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
