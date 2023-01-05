package de.neumen.minecraft;

import org.bukkit.entity.Player;

public class ChatEvent {
    private Player player;
    private String message;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }
}
