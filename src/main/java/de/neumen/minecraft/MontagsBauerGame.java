package de.neumen.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MontagsBauerGame {
    private double[] arena = new double[6];
    private String gameTitle;
    private boolean isRunning = false;
    private final ArrayList<String> players = new ArrayList<String>();

    public MontagsBauerGame(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public boolean addPlayer(String playerName) throws Exception {
        if (players.contains(playerName)) {
            throw new Exception("Player is already in the game...");
        }
        return players.add(playerName);
    }

    public double[] getArena() {
        return arena;
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
        for (String playerName: players) {
            Bukkit.getPlayer(playerName).sendMessage("Game starts in ...");
        }

        Thread startCountdown = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i > 0; i--) {
                    for (String playerName: players) {
                        Player p = Bukkit.getPlayer(playerName);
                        p.sendMessage(String.valueOf(i));
                        p.playNote(p.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.E));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        startCountdown.start();
        return true;
    }
}
