package de.neumen.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventListenerOnPlayerChat implements Listener {


    public EventListenerOnPlayerChat() {
    }

    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        ChatBus.getInstance().addChatEvent(new ChatEvent(event.getPlayer().getName(), event.getMessage()));
        StringBuilder stringBuilder = new StringBuilder();
        for (ChatEvent ce:ChatBus.getInstance().getChatBus()) {
            stringBuilder.append(ce.getPlayerName() + " : " + ce.getMessage());
            stringBuilder.append(", ");
        }

        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        event.getPlayer().sendMessage(stringBuilder.toString());
    }
}
