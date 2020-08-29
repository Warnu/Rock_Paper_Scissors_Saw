package rock.paper.scissors.saw.game;

public class Statistics {
    private int roundWonCount;
    private int roundLostCount;
    private int roundTiedCount;
    private int gameWonCount;
    private int gameLostCount;
    private int gameTiedCount;
    Statistics(int rwc, int rlc, int rtc, int gwc, int glc, int gtc){
        roundWonCount = rwc;
        roundLostCount = rlc;
        roundTiedCount = rtc;
        gameWonCount = gwc;
        gameLostCount = glc;
        gameTiedCount = gtc;
    }
    Statistics(){
        roundWonCount = 0;
        roundLostCount = 0;
        roundTiedCount = 0;
        gameWonCount = 0;
        gameLostCount = 0;
        gameTiedCount = 0;
    }
    public void setRoundWonCount(int rwc){
        roundWonCount = rwc;
    }public int getRoundWonCount(){
        return roundWonCount;
    }
    public void setRoundLostCount(int rlc){
        roundLostCount = rlc;
    }public int getRoundLostCount(){
        return roundLostCount;
    }
    public void setRoundTiedCount(int rtc){
        roundTiedCount = rtc;
    }public int getRoundTiedCount(){
        return roundTiedCount;
    }
    public void setGameWonCount(int gwc){
        gameWonCount = gwc;
    }public int getGameWonCount(){
        return gameWonCount;
    }
    public void setGameLostCount(int glc){
        gameLostCount = glc;
    }public int getGameLostCount(){
        return gameLostCount;
    }
    public void setGameTiedCount(int gtc){
        gameTiedCount = gtc;
    }public int getGameTiedCount(){
        return gameTiedCount;
    }
}
