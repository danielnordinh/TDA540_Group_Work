public class Player1 {

    private String identity;
    private Die dice;


    Player1(String name, Die diceIn){
    identity = name;
    dice = diceIn;

    }
    public int rollTheDie(){
        System.out.println("Spelaren är " + identity);
    return(dice.roll());
    }

    public String getName() {
        return identity;
    }
}
