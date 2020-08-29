package rock.paper.scissors.saw.game;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public Player[] players;
    private int player1RoundWinCount;
    private int player2RoundWinCount;
    private int player1RoundTieCount;
    private int player2RoundTieCount;
    private int player1RoundLossCount;
    private int player2RoundLossCount;
    
    Game(int rounds, Player[] players){
        this.players = players;
        player1RoundWinCount = this.players[0].stats.getRoundWonCount();
        player2RoundWinCount = this.players[1].stats.getRoundWonCount();
        player1RoundTieCount = this.players[0].stats.getRoundTiedCount();
        player2RoundTieCount = this.players[1].stats.getRoundTiedCount();
        player1RoundLossCount = this.players[0].stats.getRoundLostCount();
        player2RoundLossCount = this.players[1].stats.getRoundLostCount();
        for(int i=0; i<rounds;i++){
            play(i+1);
        }
        String winner = announceWinner();
        System.out.println(winner);
        System.out.println();
        
    }
    public void play(int round){
        Scanner input = new Scanner(System.in);
        System.out.println("Round "+round+" Player 1");
        System.out.println("Please choose your weapon!");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println("4. Saw");
        int player1Input = input.nextInt()-1;
        System.out.println("Round "+round+" Player 2");
        System.out.println("Please choose your weapon!");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println("4. Saw");
        int player2Input = input.nextInt()-1;
        int computerInput = computerMove();
        String currentWinner = calculateWinners(player1Input, player2Input, computerInput);
        System.out.println();
        System.out.println(players[0].getPlayerName()+" chose: "+getWeaponOption(player1Input));
        System.out.println(players[1].getPlayerName()+" chose: "+getWeaponOption(player2Input));
        System.out.println("Computer chose: "+getWeaponOption(computerInput));
        System.out.println();
        System.out.println(currentWinner);
        System.out.println();
        System.out.println("Press Enter to return to the Main Menu!");
        input.nextLine();
    }
    
    public String announceWinner(){
        
        if(((players[0].stats.getRoundLostCount()-player1RoundLossCount) >=2) && ((players[1].stats.getRoundLostCount()-player2RoundLossCount) >=2)){
            int temp = players[0].stats.getGameLostCount()+1;
            players[0].stats.setGameLostCount(temp);
            temp = players[1].stats.getGameLostCount()+1;
            players[1].stats.setGameLostCount(temp);
            return "The computer has won the match!";
            }
        else if(((players[1].stats.getRoundLostCount()-player2RoundLossCount) >=2) && (((players[0].stats.getRoundTiedCount()-player1RoundTieCount)>=1) & ((players[0].stats.getRoundLostCount()-player1RoundLossCount) <= 1))){
            int temp = players[0].stats.getGameTiedCount()+1;
            players[0].stats.setGameTiedCount(temp);
            temp = players[1].stats.getGameLostCount()+1;
            players[1].stats.setGameLostCount(temp);
            return (players[0].getPlayerName()+" has tied and "+players[1].getPlayerName()+" has lost the match!");
            }
        else if(((players[0].stats.getRoundLostCount()-player1RoundLossCount) >=2) && (((players[1].stats.getRoundTiedCount()-player2RoundTieCount)>=1) && ((players[1].stats.getRoundLostCount()-player2RoundLossCount) <= 1))){
            int temp = players[0].stats.getGameLostCount()+1;
            players[0].stats.setGameLostCount(temp);
            temp = players[1].stats.getGameTiedCount()+1;
            players[1].stats.setGameTiedCount(temp);
            return (players[1].getPlayerName()+" has tied and "+players[0].getPlayerName()+" has lost the match!");
            }
        else if((((players[0].stats.getRoundTiedCount()-player1RoundTieCount)>=1) && ((players[0].stats.getRoundLostCount()-player1RoundLossCount) <= 1)&& ((players[0].stats.getRoundWonCount()-player1RoundWinCount)<=1)) && (((players[1].stats.getRoundTiedCount()-player2RoundTieCount)>=1) && ((players[1].stats.getRoundLostCount()-player2RoundLossCount) <= 1)&& ((players[1].stats.getRoundWonCount()-player2RoundWinCount)<=1))){
            int temp = players[0].stats.getGameTiedCount()+1;
            players[0].stats.setGameTiedCount(temp);
            temp = players[1].stats.getGameTiedCount()+1;
            players[1].stats.setGameTiedCount(temp);
            return ("Both "+players[0].getPlayerName()+" and "+players[1].getPlayerName()+" have tied the match!");
        }
        else if(((players[1].stats.getRoundLostCount()-player2RoundLossCount) >=2) && ((players[0].stats.getRoundWonCount()-player1RoundWinCount)>=2)){
            int temp = players[0].stats.getGameWonCount()+1;
            players[0].stats.setGameWonCount(temp);
            temp = players[1].stats.getGameLostCount()+1;
            players[1].stats.setGameLostCount(temp);
            return (players[0].getPlayerName()+" has won the match and "+players[1].getPlayerName()+" has lost the match!");
        }
        else if(((players[0].stats.getRoundLostCount()-player1RoundLossCount) >=2) && ((players[1].stats.getRoundWonCount()-player2RoundWinCount)>=2)){
            int temp = players[0].stats.getGameLostCount()+1;
            players[0].stats.setGameLostCount(temp);
            temp = players[1].stats.getGameWonCount()+1;
            players[1].stats.setGameWonCount(temp);
            return (players[1].getPlayerName()+" has won the match and "+players[0].getPlayerName()+" has lost the match!");
        }
        else if(((players[0].stats.getRoundWonCount()-player1RoundWinCount)>=2) && (((players[1].stats.getRoundTiedCount()-player2RoundTieCount)>=1) && (players[1].stats.getRoundLostCount()-player2RoundLossCount <= 1))){
            int temp = players[0].stats.getGameWonCount()+1;
            players[0].stats.setGameWonCount(temp);
            temp = players[1].stats.getGameTiedCount()+1;
            players[1].stats.setGameTiedCount(temp);
            return (players[0].getPlayerName()+" has won and "+players[1].getPlayerName()+" has tied the match!");
        }
        else if(((players[1].stats.getRoundWonCount()-player2RoundWinCount)>=2) && (((players[0].stats.getRoundTiedCount()-player1RoundTieCount)>=1) && (players[0].stats.getRoundLostCount()-player1RoundLossCount <= 1))){
            int temp = players[0].stats.getGameTiedCount()+1;
            players[0].stats.setGameTiedCount(temp);
            temp = players[0].stats.getGameWonCount()+1;
            players[1].stats.setGameWonCount(temp);
            return (players[1].getPlayerName()+" has won and "+players[0].getPlayerName()+" has tied the match!");
        }
        else{
            int temp = players[0].stats.getGameWonCount()+1;
            players[0].stats.setGameWonCount(temp);
            temp = players[0].stats.getGameWonCount()+1;
            players[1].stats.setGameWonCount(temp);
            return ("Both "+players[0].getPlayerName()+" and "+players[1].getPlayerName()+" have won the match!");
        }
    }
    
    public String getWeaponOption(int input){
        if (input == 0)
            return "Rock";
        else if (input == 1)
            return "Paper";
        else if (input == 2)
            return "Scissors";
        else
            return "Saw";
    }
    
    public int getRoundWinner(int playerInput, int computerMove){
        if (playerInput == computerMove)
            return 0;
        else if (((playerInput == 0 && computerMove == 2) || (playerInput == 0 && computerMove == 3)) || (playerInput == 1 && computerMove == 0) || (playerInput == 2 && computerMove == 1) || ((playerInput == 3 && computerMove == 1) || (playerInput == 3 && computerMove == 2)))
            return 1;
        else
            return 2;
    }
    
    public String calculateWinners(int player1Input, int player2Input, int computerInput){
        int player1Score = getRoundWinner(player1Input, computerInput);
        int player2Score = getRoundWinner(player2Input, computerInput);
        
        if (player1Score == 0){
            int temp = players[0].stats.getRoundTiedCount()+1;
            players[0].stats.setRoundTiedCount(temp);
        }
        else if (player1Score == 1){
            int temp = players[0].stats.getRoundWonCount()+1;
            players[0].stats.setRoundWonCount(temp);
        }
        else{
            int temp = players[0].stats.getRoundLostCount()+1;
            players[0].stats.setRoundLostCount(temp);
        }

        if (player2Score == 0){
            int temp = players[1].stats.getRoundTiedCount()+1;
            players[1].stats.setRoundTiedCount(temp);
        }
        else if (player2Score == 1){
            int temp = players[1].stats.getRoundWonCount()+1;
            players[1].stats.setRoundWonCount(temp);
        }
        else{
            int temp = players[1].stats.getRoundLostCount()+1;
            players[1].stats.setRoundLostCount(temp);
        }
        if ((player1Score == 1) && (player2Score == 1))
            return "Both players have won the round!";
        else if (player1Score == 1)
            return (players[0].getPlayerName()+" has won the round!");
        else if (player2Score == 1)
            return (players[1].getPlayerName()+" has won the round!");
        else if ((player1Score == 0) && (player2Score ==0))
            return "Both players tied with the computer!";
        else
            return "The computer has won the round!";
    }
    
    public int computerMove(){
        return ThreadLocalRandom.current().nextInt(0, 3+1);
    }
}
