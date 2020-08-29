package rock.paper.scissors.saw.game;
import java.util.*;

public class GameDriver {
    private static Player[] players = new Player[2];;
    private static Player player1 = new Player();
    private static Player player2 = new Player();
    //Displays the menu and gets the user choice
    public static int displayMenu(){
        Scanner input = new Scanner(System.in);
        do{
            int choise=0;
            System.out.println("Welcome to Rock, Paper, Scissor, Saw");
            System.out.println("1. Play game");
            System.out.println("2. Show game rules");
            System.out.println("3. Show statistics");
            System.out.println("4. Exit");
            if(input.hasNextInt()){
                choise = input.nextInt();
                if((choise >= 1) && (choise <= 4))
                    return choise;
                else
                    System.out.println("Please enter a valid option from 1-4!");
            }
            else{
                System.out.println("Please enter a valid option from 1-4");
                input.nextLine();
            }
        }while(0<1);
    }
    //Terminates the program
    public static void exit(){
        System.exit(0);
    }
    //Gather player's data
    public static void gatherPlayerData(){
        Scanner input = new Scanner(System.in);
        String input1;
        String input2;
        
        System.out.print("Please enter the name of the first player: ");
        input1 = input.next();
        while(input1.length() <3 || input1.length() >20){
            System.out.println("Please enter a name with more than 3 characters and less than 20!");
            input1 = input.next();
        }
        player1.setPlayerName(input1);
        System.out.print("Please enter the name of the second player: ");
        input2 = input.next();
        while(input2.length() <3 || input2.length() >20){
            System.out.println("Please enter a name with more than 3 characters and less than 20!");
            input2 = input.next();
        }
        while(input2 == input1){
            while(input2.length() <3 || input2.length() >20){
                System.out.println("Please enter a name with more than 3 characters and less than 20!");
                input2 = input.next();
            }
        }
        player2.setPlayerName(input2);
    }
    public static void displayRules(){ 
        Scanner input = new Scanner(System.in);
        System.out.println("Rules");
        System.out.println("Winner of the round will be determined as follow:");
        System.out.println("\ta. Rock breaks scissors and Saw therefore rock wins over scissors and saw. Rock loses against paper");
        System.out.println("\tb. Scissors cut paper therefore scissors win over paper. Scissors lose against rock and Saw.");
        System.out.println("\tc. Paper covers rock therefore paper wins over rock. Paper loses against scissors and saw");
        System.out.println("\td. Saw cuts through scissors and paper therefore saw wins over scissors and paper. Saw loses against rock.");
        System.out.println("\te. If player and computer make the same selection, there is a tie");
        System.out.println("Winner of the game against the computer is one who won more rounds (must account for ties)");
        System.out.println("Overall human winner is based on the greater number of won games against the computer and least games lost (must account for tie between human players)");
        System.out.println("Press Enter to return to the Main Menu!");
        input.nextLine();
    }
    
    public static void displayStats(){
        Scanner input = new Scanner(System.in);
        System.out.println("Statistics");
        System.out.println("Rounds:");
        System.out.println("\t"+players[0].getPlayerName()+": "+players[0].stats.getRoundWonCount()+"W "+players[0].stats.getRoundLostCount()+"L "+players[0].stats.getRoundTiedCount()+"T");
        System.out.println("\t"+players[1].getPlayerName()+": "+players[1].stats.getRoundWonCount()+"W "+players[1].stats.getRoundLostCount()+"L "+players[1].stats.getRoundTiedCount()+"T");
        System.out.println("Games:");
        System.out.println("\t"+players[0].getPlayerName()+": "+players[0].stats.getGameWonCount()+"W "+players[0].stats.getGameLostCount()+"L "+players[0].stats.getGameTiedCount()+"T");
        System.out.println("\t"+players[1].getPlayerName()+": "+players[1].stats.getGameWonCount()+"W "+players[1].stats.getGameLostCount()+"L "+players[1].stats.getGameTiedCount()+"T");
        switch(getBestHumanPlayer()){
            case 0:{
                System.out.println("\nOverall Human Winner: "+players[0].getPlayerName());
                break;
            }
            case 1:{
                System.out.println("\nOverall Human Winner: "+players[1].getPlayerName());
                break;
            }
            case 2:{
                System.out.println("Overall Human Winner: Both players are Tied");
            }
        }
        System.out.println("Press Enter to return to the Main Menu!");
        input.nextLine();
    }
    
    public static int getBestHumanPlayer(){
        if (players[0].stats.getGameWonCount() > players[1].stats.getGameWonCount())
            return 0;
        else if (players[1].stats.getGameWonCount() > players[0].stats.getGameWonCount())
            return 1;
        else
            return 2;
    }
    
    public static void main(String[] args) {
        gatherPlayerData();
        players[0] = player1;
        players[1] = player2;
        while(true){
            switch(displayMenu()){
                case 1:{
                    Game game = new Game(3,players);
                    players = game.players;
                    break;
                }
                case 2:{
                    displayRules();
                    break;
                }
                case 3:{
                    displayStats();
                    break;
                }
                case 4:{
                    exit();
                }
            }
            
        }
        
    }
}
