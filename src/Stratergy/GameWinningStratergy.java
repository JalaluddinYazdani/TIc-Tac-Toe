package Stratergy;

import models.Board;
import models.Move;

public interface GameWinningStratergy {
    boolean checkWinner(Board board, Move move);

}
