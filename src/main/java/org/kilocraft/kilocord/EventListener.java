package org.kilocraft.kilocord;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

public class EventListener extends ListenerAdapter {
    final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onReady(@Nonnull ReadyEvent event){
        logger.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        //This is where we are getting all messages. We can in theory do all commands here.
        //User is the command sender.
        User user = event.getAuthor();

        String prefix = EnvHandler.get("prefix");
        if (event.getJDA().getSelfUser().getAsTag().equals("KiloCord-dev#3795")) {
            prefix = EnvHandler.get("devPrefix");
        }

        if (event.getMessage().getContentRaw().startsWith(prefix)) {

        }


    }
}
