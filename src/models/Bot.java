package models;

import Stratergy.BotPlayingStratergy;
import Stratergy.EasyBotPlayingStratergy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStratergy botPlayingStratergy;
    public Bot(char c,String name,BotDifficultyLevel botDifficultyLevel){
        super(c,name,PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        //better way is via factory based on the bot difficulty level
        this.botPlayingStratergy= new EasyBotPlayingStratergy();
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
    public Move decideMove(Board board){
        return botPlayingStratergy.decideMove(this,board);
    }
}
