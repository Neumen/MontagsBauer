package de.neumen.minecraft;

import java.util.ArrayList;

public class MontagsBauerGamesManager {
    private final ArrayList<MontagsBauerGame> games = new ArrayList<>();

    public ArrayList<MontagsBauerGame> getGames() {
        return games;
    }

    public MontagsBauerGamesManager() {

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
}
