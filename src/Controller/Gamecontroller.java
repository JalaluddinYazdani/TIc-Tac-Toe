package Controller;

import models.Game;
import models.GameStatus;
import models.Player;

import java.util.List;

public class Gamecontroller {
    public Game createGame(int dimensions, List<Player> players){
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .build();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatuss();
    }

    public String getWinnerName(Game game){
        return game.getWinningPlayer().getName();
    }
//    public void displayBoard(Game game){
//        game.getBoard().;
//    }
    public void setGameStatus(Game game , GameStatus gameStatus){
        game.setGameStatuss(gameStatus);
    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }
}
