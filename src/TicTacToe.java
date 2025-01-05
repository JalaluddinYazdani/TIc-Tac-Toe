import Controller.Gamecontroller;
import models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Hello World! Welcome to Tictactoe");
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the dimension of the game :");
        int dimensions = scanner.nextInt();

        System.out.println("No of Players");
        int noOfPlayers = scanner.nextInt();

        List<Player> players = new LinkedList<>();

        System.out.println("Will there be a bot ? y/n");
        String isBot = scanner.next();

        if(isBot.equals("y")){
            //since one is bot
            noOfPlayers=noOfPlayers-1;

            //Enter the symbol for the bot
            System.out.println("Enter the name of the bot");
            String name = scanner.next();

            //ENter the symbol of the bot
            System.out.println("Enter the symbol of the bot");
            String botSymbol = scanner.next();

            System.out.println("Enter bot difficulty level : 1-Easy 2-Medium -Hard");
            int difficultyLevel = scanner.nextInt();

            players.add(new Bot(botSymbol.charAt(0),name,
                    BotDifficultyLevel.EASY));

        }

        for(int i=0;i<noOfPlayers;i++){
            //Enter the symbol for the bot
            System.out.println("Enter the name of the player"+i+1 );
            String name = scanner.next();

            //ENter the symbol of the bot
            System.out.println("Enter the symbol of the player"+i+1);
            String symbol = scanner.next();

            Player player = new Player(symbol.charAt(0),name, PlayerType.HUMAN);
            players.add(player);
        }

//        Game game = Game.getBuilder().
//                setDimensions(dimensions)
//                .setPlayers(players)
//                .build();

        Gamecontroller gamecontroller = new Gamecontroller();

        Game game = gamecontroller.createGame(dimensions,players);

        while(gamecontroller.getGameStatus(game)== GameStatus.INPROGRESS){
            // TODO play the game
            //break;
            System.out.println("Current Board:");
            gamecontroller.displayBoard(game);

            gamecontroller.executeNextMove(game);
        }

        if(gamecontroller.getGameStatus(game)==GameStatus.DRAW){
            System.out.println("Game has drawn");
        }else{
            System.out.println("Game has been won by: "
                    +gamecontroller.getWinnerName(game));
        }
    }
}