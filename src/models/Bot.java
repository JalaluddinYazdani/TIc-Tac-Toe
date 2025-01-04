package models;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(char c,String name,BotDifficultyLevel botDifficultyLevel){
        super(c,name,PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
