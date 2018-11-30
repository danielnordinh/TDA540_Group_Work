import java.util.Random;

public class Die {

    private int lastScore;
    private int sides;

    Die (int NumberOfSides) {

        sides = NumberOfSides;
    }

    public int roll() {

        Random rn = new Random();
        lastScore =rn.nextInt(sides)+1;
        return lastScore;
    }

    public String toString(){

        return "Die{result="+lastScore+"}";
    }

}
