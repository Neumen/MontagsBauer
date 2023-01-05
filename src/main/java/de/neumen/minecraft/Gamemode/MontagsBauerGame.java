package de.neumen.minecraft.Gamemode;

import de.neumen.minecraft.ChatEvent;
import de.neumen.minecraft.Config;
import de.neumen.minecraft.EventListenerOnPlayerChat;
import de.neumen.minecraft.IObserver;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;

public class MontagsBauerGame implements IObserver {

    private ArrayList<PlayerScore> playerScores = new ArrayList<>();
    private boolean wordGuessed = false;
    private Player currentBuilder = null;
    private int currentGameRound = 0;
    private Location arenaTeleportLocation = null;
    private final double[] arena = new double[6];
    private String gameTitle;
    private boolean isRunning = false;
    private final ArrayList<Player> players = new ArrayList<>();
    private String currentWord;

    public MontagsBauerGame(String gameTitle) {
        this.gameTitle = gameTitle;
        EventListenerOnPlayerChat.getInstance().registerObserver(this);
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean addPlayer(Player player) throws Exception {
        if (players.contains(player)) {
            throw new Exception("Player is already in the game...");
        }
        return players.add(player);
    }

    public double[] getArena() {
        return arena;
    }

    public boolean setArenaTeleportLocation(Location location) {
        this.arenaTeleportLocation = location;
        return true;

    }

    public boolean removePlayer(Player player) {
        players.remove(player);
        return true;
    }

    public boolean setArena(String arg, double x, double y , double z) {
        switch (arg) {
            case "p1":
                this.arena[0] = x;
                this.arena[1] = y;
                this.arena[2] = z;
                break;
            case "p2":
                this.arena[3] = x;
                this.arena[4] = y;
                this.arena[5] = z;
                break;
            default:
                break;

        }
        return true;
    }

    public boolean startGame() throws Exception {
        if (isRunning) {
            throw new Exception("Game is already running...");
        }

        isRunning = true;

        for (Player player: players) {

            player.teleport(arenaTeleportLocation);
        }

        for (Player player:players) {
            playerScores.add(new PlayerScore(player, 0));
        }

        Collections.shuffle(players);

        game();

        return true;
    }

    private void game() throws InterruptedException {
        Thread game = new Thread(new Runnable() {
            @Override
            public void run() {

                for (Player player : players) {
                    player.sendMessage("Game starts in ...");
                }

                int i = 0;
                while(i < 4 && isRunning) {

                    currentBuilder = players.get(0);
                    Collections.rotate(players, 1);

                    for (Player player:players) {
                        player.sendMessage("Next Builder: " + currentBuilder.getName());
                    }

                    ArrayList<String> words = (ArrayList<String>) Config.getInstance().getConfig().getStringList("words");
                    currentWord = words.get((int)(Math.random() * words.size()));

                    currentBuilder.sendMessage("Your word is: " + currentWord);

                    for (int j = 3; j > 0; j--) {
                        for (Player player : players) {
                            player.sendMessage(String.valueOf(j));
                            player.playNote(player.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.E));
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int j = 120;
                    while (j > 0 && !wordGuessed && isRunning) {
                        for (Player player : players) {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.valueOf(j)));
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        j--;
                    }
                    wordGuessed = false;
                    currentGameRound += 1;
                    i++;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (PlayerScore ps:playerScores) {
                    stringBuilder.append(ps.getPlayer().getName() +": " + ps.getScore());
                    stringBuilder.append(", ");
                }
                stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
                String score = stringBuilder.toString();
                for (Player player:players) {
                    player.sendMessage(score);
                }
                isRunning = false;
            }
        });
        game.start();
    }

    public void stopGame() {
        isRunning = false;
    }

    @Override
    public void update(ChatEvent ce) {
        if (this.getPlayers().contains(ce.getPlayer())) {
            for (Player player: players) {
                player.sendMessage(player.getName() + ": " + ce.getMessage());
            }
            if (ce.getMessage().equals(currentWord) && !ce.getPlayer().equals(currentBuilder)) {
                for (Player player:players) {
                    player.sendMessage("Player " + ce.getPlayer().getName() + " guessed the right word!");
                    player.playNote(player.getLocation(), Instrument.BELL, Note.natural(0, Note.Tone.E));
                }
                for (PlayerScore ps:playerScores) {
                    if (ps.getPlayer().getName().equals(ce.getPlayer().getName()) ||
                    ps.getPlayer().equals(currentBuilder)) {
                        ps.setScore(ps.getScore() + 1);
                    }
                }

                this.wordGuessed = true;
            }
        }
    }
}
