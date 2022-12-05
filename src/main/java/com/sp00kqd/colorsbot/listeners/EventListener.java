package com.sp00kqd.colorsbot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String getChannel = String.valueOf(event.getGuildChannel());
        String message = event.getMessage().getContentRaw();
        String[] splitMessage = message.split("\n");

        if ((getChannel.equals("TC:suggestions-input(1049177576855326790)")) && !event.getAuthor().isBot()) {
            try {
                String l1 = splitMessage[0];
                String l2 = splitMessage[1];
                String l3 = splitMessage[2];

                System.out.println(l1 + l2 + l3);
            } catch (ArrayIndexOutOfBoundsException e) {
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", invalid format.").queue(m -> m.delete().queueAfter(3, TimeUnit.SECONDS));
                event.getMessage().delete().queue();
            }

        }
    }

}
