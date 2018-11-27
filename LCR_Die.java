import java.util.Random;
public class LCR_Die {

    private char face;
    private int lastScore;

    LCR_Die(){

    }

    public char roll() {

        Random rn = new Random();
        lastScore = rn.nextInt(6)+1;
        switch (lastScore){
            case 1: face = 'L';
            break;
            case 2: face = 'C';
            break;
            case 3: face = 'R';
            break;
            case 4: face = '.';
            break;
            case 5: face = '.';
            break;
            case 6: face = '.';
            break;
            //default: face = 'E';

        }
        return face;
    }

    @Override
    public String toString(){
        return String.valueOf(roll());
    }

}
