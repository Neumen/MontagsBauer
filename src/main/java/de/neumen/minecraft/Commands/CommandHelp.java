package de.neumen.minecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHelp extends CustomCommand {
    public CommandHelp() {
        super("help");
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("/montagsbauer createGame <GameName>");
        commandSender.sendMessage("/montagsbauer deleteGame <GameName>");
        commandSender.sendMessage("/montagsbauer addPlayer <GameName> <PlayerName>");
        commandSender.sendMessage("/montagsbauer setRoundAmount <GameName> <round amount>");
        commandSender.sendMessage("/montagsbauer removePlayer <GameName> <PlayerName>");
        commandSender.sendMessage("/montagsbauer setGameArenaTeleportLocation <GameName>");
        commandSender.sendMessage("/montagsbauer startGame <GameName>");
        commandSender.sendMessage("/montagsbauer stopGame <GameName>");
        commandSender.sendMessage("/montagsbauer addWords <Word1> <Word2> etc...");
        commandSender.sendMessage("/montagsbauer listGamePlayers <GameName>");
        commandSender.sendMessage("/montagsbauer listGames");
        return true;
    }
}
