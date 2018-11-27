public class LCR_Player {


    private int chips;
    private LCR_Die dice;
    private String name;
    private String returnString;

    private int placement;

    private int rolls;

    private char comp;

    private int lCount=0;
    private int cCount=0;
    private int rCount=0;
    private int dotCount=0;
    private int weirdCount=0;


    LCR_Player(String name, LCR_Die dice, int placement){
        this.name = name;
        this.dice = dice;
        this.placement = placement;
        chips = 3;
    }

    public char rollDice(){
        comp = dice.roll();
        if ((comp=='L')||(comp=='C')||(comp=='R')) {
            chips--;
        }
        return comp;
    }

    public int getChips(){
        return chips;
    }

    @Override
    public String toString(){

        returnString = name + " (" + chips + " chips)";
        return returnString;
    }

    public int getNbRolls(){
        if(chips < 3) {
            rolls = chips;
        }
        else rolls=3;

        return rolls;
    }

    public void addChips ( int amount){
        if (amount > 0) {
            chips += amount;
        }else System.out.println("Error! Invalid Input");
    }

    public int getPlacement (){
        return placement;
    }



}
