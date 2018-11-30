import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

import java.lang.Character;
public class Lab5 {

    public static void main(String[] args) {

        // -- Part 1 --
        assert isVowel('ä');
        assert !isVowel('z');
        assert !isVowel(' ');
        assert isConsonant('B');
        assert isConsonant('x');
        assert isVowel('Å');
        assert isVowel('Ö');


        assert toRobber("java").equals("jojavova");
        assert toRobber("stubborn").equals("sostotubobboborornon");
        assert toRobber("Hej på dig").equals("Hohejoj popå dodigog");
        assert toRobber("DoD PåfÅgel ").equals("DodoDod PopåfofÅgogelol ");


        assert toPigLatin("pig pig").equals("igpay igpay");
        assert wordToPigLatin("igloo").equals("iglooway");
        assert wordToPigLatin("arthur").equals("arthuray");
        assert wordToPigLatin("Oboe").equals("Oboeway");
        assert wordToPigLatin("pig").equals("igpay");
        assert wordToPigLatin("string").equals("ingstray");
        assert wordToPigLatin("omelet").equals("omeletay");
        assert wordToPigLatin("i").equals("iway");
        assert toPigLatin("Hej på dig").equals("Ejhay åpay igday");

        // uncomment this to test doCommandLine()
        //doCommandLine();

        // -- Part 2 --

        //rollADie();
        //letPlayerRoll();
        //letTwoPlayersRollSameDice();
        //letPlayerUseDiceCup();
        findPlayerWithMax();
    }

    // ---------- Del 1 ---------------

    // 1
    // Check if a given character is a vowel
    private static boolean isVowel(char toCheck) {
        String VowelString = "aeiouyåäöAEIOUYÅÄÖ";
        char[] Vowel = VowelString.toCharArray();

        //Compares each letter in the input text to the char[] Vowel, which contains all vowels.

        for (char c:Vowel) {
            if (c == toCheck) {
                return true;
            }
        }
        return false;
    }//isVowel

    private static boolean isConsonant(char toCheck) {
        String VowelString = "bcdfghjklmnpqrstvwzxBCDFGHJKLMNPQRSTVWZX";
        char[] Vowel = VowelString.toCharArray();

        //Compares each letter in the input text to the char[] Vowel, which contains all vowels.

        for (char c:Vowel) {
            if (c == toCheck) {
                return true;
            }
        }
        return false;
    }//isVowel

    // Help method for toRobber
    private static int robberLetterCounter(char[] toCount){
        int conCount = 0; int vowAndSpcCount  = 0;

        for (char ch:toCount){
            if(isVowel(ch)||ch==(' ')){
                vowAndSpcCount++;
            } else conCount++;
        }
        return ((conCount*3)+(vowAndSpcCount));
    }//robberWordCounter

    // Convert a string to Robber Speak
    private static String toRobber(String text) {
        char[] Original = text.toCharArray();
        int robberLength;
        robberLength = robberLetterCounter(Original);

        char[] Robber = new char[robberLength];

        int ii = 0;
        int jj = 0;

        while (jj < Robber.length) {
            if (isConsonant(Original[ii])) {
                Robber[jj] = Original[ii];
                Robber[jj + 1] = 'o';
                Robber[jj + 2] = Character.toLowerCase(Original[ii]);
                jj += 3;

            } else {
                Robber[jj] = Original[ii];
                jj++;
            }
            ii++;
        }
        return String.valueOf(Robber);
    }//toRobber



    // 2

    // Help method for wordToPigLatin
    private static boolean isUpperCase(char toCheck){
        return (Character.isUpperCase(toCheck));
    }//isUpperCase

    // Help method for wordToPigLatin
    private static int firstVowelFinder (char[] toCheck){
        int FirstVowel = 0;
        int ii = 0;
        int VowelCount = 0;

        while ((ii < toCheck.length) && (VowelCount < 1)) {
            if (isVowel(toCheck[ii])) {
                FirstVowel = ii;
                ii++;
                VowelCount++;
            } else ii++;
        }
        return FirstVowel;
    }//firstVowelFinder

    // Convert a single word without spaces to Pig Latin
    // Precondition: text != null, text contains no spaces
    private static String wordToPigLatin (String text) {

        char[] Original = text.toCharArray();


        if (isVowel(Original[0]) && isVowel(Original[Original.length - 1])) {
            return (String.valueOf(Original) + "way");
        }

        if (isVowel(Original[0]) && !isVowel(Original[Original.length - 1])) {
            return (String.valueOf(Original) + "ay");
        }

        if (!isVowel(Original[0])) {
            int FirstVowel = firstVowelFinder(Original);

            char[] FirstCons = new char[FirstVowel];
            System.arraycopy(Original, 0, FirstCons, 0, FirstVowel); //kopierar de första konsonanterna ur input

            char[] Rest = new char[Original.length - FirstVowel];
            System.arraycopy(Original, FirstVowel, Rest, 0, Original.length - FirstVowel); //kopierar den första vokalen och resten ur input

            if (isUpperCase(Original[0])) {

                char[] FirstCons2 = new char[FirstCons.length];
                FirstCons2[0] = Character.toLowerCase(FirstCons[0]);
                System.arraycopy(FirstCons, 1, FirstCons2, 1, FirstCons2.length - 1);

                char[] Rest2 = new char[Rest.length];
                Rest2[0] = Character.toUpperCase(Rest[0]);
                System.arraycopy(Rest, 1, Rest2, 1, Rest2.length - 1);

                return (String.valueOf(Rest2) + String.valueOf(FirstCons2) + "ay");

            }

            return (String.valueOf(Rest) + String.valueOf(FirstCons) + "ay");  //lägger ihop


        } else return text;

    }//wordToPigLatin

    // Convert a whole sentence to Pig Latin
    // Precondition: text != null
    private static String toPigLatin(String text) {

        //int maximumWords = 50;

        String[] words = text.split(" "); //text.split(" ",maximumWords);
        String[] TranslatedWords= new String[words.length];

        for (int i = 0; i < words.length; i++) {
            TranslatedWords[i]=wordToPigLatin(words[i]);
        }

        String TranslatedSent;

        TranslatedSent = String.join(" ", TranslatedWords); //nice!


    return TranslatedSent;


    }//toPigLatin


    // 3
    // A command-line interface for the toRobber and toPigLatin methods
    private static void doCommandLine () { //behövs exception?
        boolean programOff = false;
        while(!programOff) {
            System.out.println("Choose a translation method (r = robber, p = pig latin, or q = to quit).");
            Scanner sc = new Scanner(System.in);
            String alpha = sc.nextLine();

            if (alpha.charAt(0) == 'r') {
                System.out.println("Type a sentence to convert into Robber speak:");
                String robber = sc.nextLine();
                System.out.println("Translation: " + toRobber(robber));

            } else if (alpha.charAt(0) == 'p') {
                System.out.println("Type a sentence to convert into Pig latin:");
                String pigLatin = sc.nextLine();
                System.out.println("Translation: " + toPigLatin(pigLatin));

            } else if (alpha.charAt(0) == 'q') {
                programOff=true;

            } else {
            System.out.println("Error! Illegal Input!");
            }


        }
        // TODO
    }


    // ---------- Del 2 ---------------

    // 4
    private static void rollADie () {
        Die tarning = new Die(6);

        for (int i = 0; i < 100 ; i++) {
           System.out.print(tarning.roll()+",");
        }
    }

    // 5
    private static void letPlayerRoll () {
        Die dice1 = new Die(6);
        Player1 player = new Player1("Röhl",dice1);

        System.out.println("Spelaren är " + player.getName());
        for (int i = 0; i < 5; i++) {
            System.out.print(player.rollTheDie()+" ");

        }
    }

    // 6
    private static void letTwoPlayersRollSameDice () {
        Die dice1 = new Die(6);
        Player1 spelare = new Player1("Fangio",dice1);

        System.out.println("Spelaren är " + spelare.getName());
        for (int i = 0; i < 5; i++) {
            System.out.print(spelare.rollTheDie()+" ");

        }
        System.out.println("");

        Player1 spelare2 = new Player1("McRae",dice1);

        System.out.println("Spelaren är " + spelare2.getName());
        for (int i = 0; i < 5; i++) {
            System.out.print(spelare2.rollTheDie()+" ");

        }
    }

    // 7 and 8
    private static void letPlayerUseDiceCup () {
        DiceCup diceCup = new DiceCup();
        Player2 player2 = new Player2("Senna",diceCup);

        System.out.println(player2.getName()+ " " + player2.totalresult());
        player2.rollDice();

        System.out.println(player2.getName() + " " + player2.totalresult());
        player2.rollDice();
    }


    // 9
    private static void findPlayerWithMax () {

        DiceCup diceCup = new DiceCup();
        Player2 player1 = new Player2("Burns", diceCup);
        Player2 player2 = new Player2("Moss", diceCup);
        Player2 player3 = new Player2("Blomqvist", diceCup);
        Player2 player4 = new Player2("Vatanen", diceCup);
        Player2 player5 = new Player2("Bellof", diceCup);

        Player2[] players = {player1,player2,player3,player4,player5};


        for (int i = 0; i < 5; i++) {
            players[i].rollDice();
            System.out.println(players[i].getName() + " " + players[i].totalresult());
        }

        int biggest=0;

        for (int i = 0; i < 5 ; i++) {
                biggest = players[i].totalresult();
            System.out.println(biggest);
            /*    if(biggest < players[i+1].totalresult()){
                    biggest = players[i+1].totalresult();
                } else biggest = biggest;
            System.out.println(biggest);
        */
        }
        System.out.println("winnerName" + " won with " + biggest + " points");

/*
        int winnerResult=0;

        int bigger1=0;
        int bigger2=0;
        int bigger3=0;

        String winnerName = "";
        String biggerNameA = "";
        String biggerNameB = "";
        String biggerNameC = "";

        if(player1.totalresult() >= player2.totalresult()){
            bigger1 = player1.totalresult();
            biggerNameA = player1.getName();

        } else if(player1.totalresult() < player2.totalresult()){
            bigger1 = player2.totalresult();
            biggerNameA = player2.getName();

        } else if(player3.totalresult() >= player4.totalresult()){
            bigger2 = player3.totalresult();
            biggerNameB = player3.getName();

        } else if(player3.totalresult() < player4.totalresult()) {
            bigger2 = player4.totalresult();
            biggerNameB = player4.getName();
        }

        if(bigger1 >= bigger2){
            bigger3 = bigger1;
            biggerNameC = biggerNameA;

        } else if(bigger1 < bigger2) {
            bigger3 = bigger2;
            biggerNameC = biggerNameB;
        }

        if(player5.totalresult() >= bigger3){
           winnerResult = player5.totalresult();
           winnerName = player5.getName();

        } else winnerResult = bigger3;
             winnerName = biggerNameC;


        System.out.println(winnerName + " won with " + winnerResult + " points");
*/
    }


}//Lab5


