package de.neumen.minecraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventListenerOnPlayerChat extends AbstractSubject implements Listener {
    private static EventListenerOnPlayerChat instance = null;

    private EventListenerOnPlayerChat() {
        super();
    }

    public static EventListenerOnPlayerChat getInstance() {
        if (instance == null) {
            instance = new EventListenerOnPlayerChat();
        }
        return instance;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        super.onChange(new ChatEvent(event.getPlayer(), event.getMessage()));
    }
}
