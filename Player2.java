import java.util.ArrayList;

public class Player2 {

    private String identity;
    private DiceCup diceCup;


    ArrayList<Integer> totalArr= new ArrayList<Integer>();
    private int sum=0;

    Player2(String name, DiceCup diceCupIn){
        totalArr.clear();
        identity=name;
        diceCup=diceCupIn;
    }


    public int rollDice(){
        totalArr.add(diceCup.rollAllDice());
        System.out.println(diceCup.toString());
        return diceCup.rollAllDice();
    }
    public int totalresult(){
        totalArr.clear();
        for (int i : totalArr)
            sum += i;

        return sum;
    }

    public String getName() {
        return identity;
    }
}
