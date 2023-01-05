package de.neumen.minecraft.Gamemode;

import java.util.ArrayList;

public class MontagsBauerGamesManager {
    private static MontagsBauerGamesManager instance = null;
    private final ArrayList<MontagsBauerGame> games = new ArrayList<>();

    public ArrayList<MontagsBauerGame> getGames() {
        return games;
    }

    private MontagsBauerGamesManager() {}

    public static MontagsBauerGamesManager getInstance() {
        if (instance == null) {
            instance = new MontagsBauerGamesManager();
        }
        return instance;
    }

    public MontagsBauerGame getGame(String gameTitle) throws Exception {
        for (MontagsBauerGame game: games) {
            if (game.getGameTitle().equals(gameTitle)) {
                return game;
            }
        }
        throw new Exception("No such game" + " " + gameTitle);
    }

    public boolean newGame(String gameTitle) throws Exception {
        for (MontagsBauerGame mbg: games) {
            if (mbg.getGameTitle().equals(gameTitle)) {
                throw new Exception("A game with this title already exists...");
            }
        }
        return games.add(new MontagsBauerGame(gameTitle));
    }

    public boolean removeGame(MontagsBauerGame game) {
        games.remove(game);
        return true;
    }
}
