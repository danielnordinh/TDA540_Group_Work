public class DiceCup {


    private Die dice1 = new Die(6);
    private Die dice2 = new Die(6);
    private Die dice3 = new Die(6);
    private Die dice4 = new Die(6);
    private Die dice5 = new Die(6);

    //private Die[] dices = new Die[5];
    private Die[] dices2 = {dice1,dice2,dice3,dice4,dice5};
    private int sum = 0;


    DiceCup(){
    }

    public int rollAllDice(){

            sum=0;
        for (int i = 0; i < 5; i++) {

            sum = sum + dices2[i].roll();
            //System.out.println(sum);
        }



        return sum; //dice1.roll()+dice2.roll()+dice3.roll()+dice4.roll()+dice5.roll();
    }

    public String toString(){
        return "DiceCup{" + dices2[0].toString() + ", " + dices2[1].toString() + ", " + dices2[2].toString() + ", " + dices2[3].toString() + ", " + dices2[4].toString()+"]}" ;

    }
}
