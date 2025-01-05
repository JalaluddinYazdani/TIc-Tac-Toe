package Stratergy;

import models.Board;
import models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStratergy implements GameWinningStratergy{
    List<HashMap<Character,Integer>> rowSymbolCounts =
            new ArrayList<>();

    List<HashMap<Character,Integer>> colSymbolCounts =
            new ArrayList<>();

    HashMap<Character,Integer> topLeftDiagonalSymbolCounts =
            new HashMap<>();

    HashMap<Character,Integer> topRightDiagonalSymbolCounts =
            new HashMap<>();


    public OrderOneGameWinningStratergy(int dimension){
        for(int i=0;i<dimension;i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
//        char symbol = move.getPlayer().getSymbol();
//        int row = move.getCell().getRow();
//        int col = move.getCell().getCol();
//        int dimension = board.getBoard().size();
//
//        //updated the count
//        if(!rowSymbolCounts.get(row).containsKey(symbol)){
//            rowSymbolCounts.get(row).put(symbol,0);
//        }
//        rowSymbolCounts
//                .get(row) // get row map
//                .put(symbol,// update symbol in row map
//                        rowSymbolCounts
//                                .get(row)
//                                .get(symbol)+1);
//
//        if(!colSymbolCounts.get(col).containsKey(symbol)){
//            colSymbolCounts.get(col).put(symbol,0);
//        }
//        colSymbolCounts
//                .get(col) // get row map
//                .put(symbol,// update symbol in row map
//                        rowSymbolCounts
//                                .get(col)
//                                .get(symbol)+1);
//
//        if(row==col){
//            if(!topLeftDiagonalSymbolCounts.containsKey(symbol)){
//                topLeftDiagonalSymbolCounts.put(symbol,0);
//            }
//            topLeftDiagonalSymbolCounts
//                    .put(symbol,
//                            topLeftDiagonalSymbolCounts
//                                    .get(symbol)+1);
//        }
//        if(row+col==dimension-1){
//            if(!topRightDiagonalSymbolCounts.containsKey(symbol)){
//                topRightDiagonalSymbolCounts.put(symbol,0);
//            }
//            topRightDiagonalSymbolCounts
//                    .put(symbol,
//                            topRightDiagonalSymbolCounts
//                                    .get(symbol)+1);
//        }
//
//        //check the winner
//        if(rowSymbolCounts.get(row).get(symbol)==dimension
//                ||colSymbolCounts.get(col).get(symbol)==dimension){
//            return true;
//        }
//
//        if(row==col && topLeftDiagonalSymbolCounts
//                .get(symbol)==dimension){
//            return true;
//        }
//        if(row+col==dimension-1&&topRightDiagonalSymbolCounts.
//                get(symbol)==dimension-1){
//            return true;
//        }
//        return false;
        char symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int dimension = board.getBoard().size();

        // updated the count
        if(!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts
                .get(row) // get row map
                .put(symbol, // update symbol in row map
                        rowSymbolCounts
                                .get(row)
                                .get(symbol) + 1);

        if (!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts
                .get(col)
                .put(symbol,
                        colSymbolCounts
                                .get(col)
                                .get(symbol) + 1);

        if (row == col) {
            if (!topLeftDiagonalSymbolCounts.containsKey(symbol)) {
                topLeftDiagonalSymbolCounts.put(symbol, 0);
            }
            topLeftDiagonalSymbolCounts
                    .put(symbol,
                            topLeftDiagonalSymbolCounts
                                    .get(symbol) + 1);
        }

        if (row + col == dimension - 1) {
            if (!topRightDiagonalSymbolCounts.containsKey(symbol)) {
                topRightDiagonalSymbolCounts.put(symbol, 0);
            }
            topRightDiagonalSymbolCounts
                    .put(symbol,
                            topRightDiagonalSymbolCounts
                                    .get(symbol) + 1);
        }

        // check winner
        if(rowSymbolCounts.get(row).get(symbol) == dimension
                || colSymbolCounts.get(col).get(symbol) == dimension) {
            return true;
        }

        if(row == col && topLeftDiagonalSymbolCounts
                .get(symbol) == dimension) {
            return true;
        }

        if(row + col == dimension - 1 && topRightDiagonalSymbolCounts
                .get(symbol) == dimension) {
            return true;
        }

        return false;
    }
}
