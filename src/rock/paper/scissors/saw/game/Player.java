package rock.paper.scissors.saw.game;

public class Player{
    private String playerName;
    public Statistics stats;
    
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
    public final void setStats(int roundWon, int roundLost, int roundTied, int gameWon, int gameLost, int gameTied){
        stats = new Statistics(roundWon, roundLost, roundTied, gameWon, gameLost, gameTied);
    }
    
    Player(String playerName){
        this.playerName = playerName;
        stats = new Statistics();
    }
    Player(){
        stats = new Statistics();
    }
    Player(String playerName, int roundWon, int roundLost, int roundTied, int gameWon, int gameLost, int gameTied){
        this.playerName = playerName;
        setStats(roundWon, roundLost, roundTied, gameWon, gameLost, gameTied);
    }
    Player(String playerName, Statistics stats){
        this.playerName = playerName;
        this.stats = stats;
    }
    Player(Player player){
        this.playerName = player.playerName;
        this.stats = player.stats;
    }
    @Override
    public String toString(){
        return (playerName+" has won: "+stats.getGameWonCount()+" games!");
    }
}
