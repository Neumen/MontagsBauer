package de.neumen.minecraft;

import java.util.ArrayList;

public class ChatBus {
    private static ChatBus instance = null;
    private final ArrayList<ChatEvent> chatBus = new ArrayList<>();

    private ChatBus() {

    }

    public static ChatBus getInstance() {
        if (instance == null) {
            instance = new ChatBus();
        }
        return instance;
    }

    public boolean addChatEvent(ChatEvent ce) {
        if (chatBus.size() > 49) {
            chatBus.remove(49);
        }

        chatBus.add(0, ce);
        return true;
    }

    public boolean removeChatEvent(ChatEvent ce) {
        return chatBus.remove(ce);
    }

    public ArrayList<ChatEvent> getChatBus() {
        return chatBus;
    }
}
