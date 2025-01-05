package Stratergy;

import models.Board;
import models.Move;
import models.Player;

public interface BotPlayingStratergy {
    Move decideMove(Player player, Board board);
}
