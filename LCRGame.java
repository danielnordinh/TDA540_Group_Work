import java.util.ArrayList;

// Detta är vart jag testar mina galna ideer

public class LCRGame {

    //getCurrentPlayer

    private LCR_Die dice;
    private LCR_Player[] players = new LCR_Player[3];

    private LCR_Player player1;
    private LCR_Player player2;
    private LCR_Player player3;

    private ArrayList<Character> valueB = new ArrayList<>();

    private String name1;
    private String name2;
    private String name3;

    private char lastDice;

    private int returnLeft;
    private int returnRight;

    private int playerCount;

    private int[] position = {1,2,3};
    private int[] score = new int[3];

    LCRGame(String name1, String name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;

        LCR_Die dice = new LCR_Die();
        this.dice = dice;

        LCR_Player player1 = new LCR_Player(name1, dice, position[0]);
        players[0] = player1;
        LCR_Player player2 = new LCR_Player(name2, dice, position[1]);
        players[1] = player2;
        LCR_Player player3 = new LCR_Player(name3, dice, position[2]);
        players[2] = player3;

        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
    }

    public void playGame(){
        for (int i = 0; i < 3; i++) {
            if(playerCount>2) {
                playerCount = 0;
            }
            playRound(players[playerCount]);
                playerCount++;
        }
    }

    public String playRound(LCR_Player player){

        for (int i = 0; i < player.getNbRolls() ; i++) {
            lastDice=player.rollDice();
            valueB.add(lastDice);
            switch (lastDice){
                case 'L': players[getPlayerLeft(player.getPlacement())].addChips(1);
                    System.out.println("Left player chip added");
                break;
                case 'R': players[getPlayerRight(player.getPlacement())].addChips(1);
                    System.out.println("Right player chip added");
                break;
                default: System.out.println("No chip added");
                break;
            }
        }
        score[player.getPlacement()-1] = player.getChips();

        return String.valueOf(valueB);
    }

    public int getPlayerRight(int position) {
            switch (position) {
                case 1:
                    returnRight = 2;
                break;
                case 2:
                    returnRight = 3;
                break;
                case 3:
                    returnRight = 1;
                break;
                default: returnRight = 0;
            }
        return returnRight;
    }

    public int getPlayerLeft(int position){
                switch (position){
                    case 1: returnLeft = 3;
                    break;
                    case 2: returnLeft = 1;
                    break;
                    case 3: returnLeft = 2;
                    break;
                    default: returnLeft = 0;
                }
                return returnLeft;
            }

    public String getPlayers(){

     return player1.toString() +" "+ player2.toString() +" "+ player3.toString();
    }

    public String getDice(){

        return dice.toString();
    }

    public String getWinner(){
        if((score[0]==0)&&(score[1]==0)) {
            return player3.toString();

        }else if((score[0])==0&&(score[2]==0)){
             return player2.toString();

        }else if((score[1]==0)&&(score[2]==0)){
            return player1.toString();
        }else
        return "Nobody has won yet";
    }


}
