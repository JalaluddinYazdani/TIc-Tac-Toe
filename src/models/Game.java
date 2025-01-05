package models;

import Exceptions.InvalidGameDimensionException;
import Stratergy.GameWinningStratergy;
import Stratergy.OrderOneGameWinningStratergy;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;

    public GameWinningStratergy getGameWinningStratergy() {
        return gameWinningStratergy;
    }

    public void setGameWinningStratergy(GameWinningStratergy gameWinningStratergy) {
        this.gameWinningStratergy = gameWinningStratergy;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    private GameWinningStratergy gameWinningStratergy;

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    private Player winningPlayer;
    

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatuss() {
        return gameStatuss;
    }

    public void setGameStatuss(GameStatus gameStatuss) {
        this.gameStatuss = gameStatuss;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    private List<Move> moves;
    private GameStatus gameStatuss;
    private int nextPlayerIndex;

    public void makeNextMove() {
        Player playerWhoMoveItis = players.get(nextPlayerIndex);
        System.out.println("It is "+playerWhoMoveItis.getName()+"s turn");

        Move move = playerWhoMoveItis.decideMove(board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
             board.applyMove(move);
             moves.add(move);

             //check winner
             if(gameWinningStratergy.checkWinner(board,move)){
                  gameStatuss = gameStatuss.ENDED;
                  winningPlayer=playerWhoMoveItis;
             }

             //DRAW
            if(moves.size()== board.getSize()* board.getSize()){
                gameStatuss=GameStatus.DRAW;
            }

            nextPlayerIndex +=1;
            nextPlayerIndex%=players.size();
        }else{
            //throw an exception
        }
        
        
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimensions(int dimension){
            this.dimension=dimension;
            return this;
        }
        public Game build(){
            //Validtaion
            try{
                isValid();
            }catch(InvalidGameDimensionException e){
                 return null;
            }

            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new LinkedList<>());
            game.setNextPlayerIndex(0);
            game.setGameStatuss(GameStatus.INPROGRESS);
            game.setGameWinningStratergy(new
                    OrderOneGameWinningStratergy(dimension));
            return game;

        }

        private boolean isValid() throws InvalidGameDimensionException{
            if(dimension<3){
                throw new InvalidGameDimensionException
                        ("Dimension should be greater than 2");
            }
            // TODO to add more validation
            
            return true;
        }
    }
}
