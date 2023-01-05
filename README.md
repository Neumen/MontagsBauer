# MontagsBauer

The .jar file can be found in the "target" folder.

---
## Commands

```
/montagsbauer createGame <GameName>
```
Creates a new game and sets the teleport location of the newly created game to the players current location.

---
```
/montagsbauer deleteGame <GameName>
```
Deletes a game.

---
```
/montagsbauer addPlayer <GameName> <PlayerName>
```
Adds a player to a game.

---
```
/montagsbauer removePlayer <GameName> <PlayerName>
```
Removes a player from a game.


---
```
/montagsbauer setGameArenaTeleportLocation <GameName>
```
Sets the teleport location of a game.


---
```
/montagsbauer startGame <GameName>
```
Starts a game. When a game is started all players of the game are teleported to the games teleport location. From then on all chat messages from any player of the game are only visible to other players of the game.

---
```
/montagsbauer stopGame <GameName>
```
Stops a game.


---
```
/montagsbauer addWords <Word1> <Word2> etc...
```
Adds new words to the config file.


---
```
/montagsbauer listGamePlayers <GameName>
```
Lists all players of a game.


---
```
/montagsbauer listGames
```
Lists all games.