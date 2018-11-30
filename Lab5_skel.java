import java.util.Arrays;
import java.util.Scanner;

public class Lab5_skel {

  public static void main(String[] args) {

    // -- Part 1 --
    assert toRobber("java").equals("jojavova");
    assert toRobber("stubborn").equals("sostotubobboborornon");
    assert toRobber("Hej på dig").equals("Hohejoj popå dodigog");

    assert toPigLatin("pig").equals("igpay");
    assert toPigLatin("string").equals("ingstray");
    assert toPigLatin("omelet").equals("omeletay");
    assert toPigLatin("i").equals("iway");
    assert toPigLatin("Hej på dig").equals("Ejhay åpay igday");

    // uncomment this to test doCommandLine()
    //doCommandLine();

    // -- Part 2 --

    rollADie();
    letPlayerRoll();
    letTwoPlayersRollSameDice();
    letPlayerUseDiceCup();
    findPlayerWithMax();
  }

  // ---------- Del 1 ---------------

  // 1
  // Check if a given character is a vowel
  public static boolean isVowel(char ch) {
    return false; // TODO
  }

  // Convert a string to Robber Speak
  public static String toRobber(String text) {
    return null; // TODO
  }

  // 2
  // Convert a single word without spaces to Pig Latin
  // Precondition: text != null, text contains no spaces
  private static String wordToPigLatin(String text) {
    return null; // TODO
  }

  // Convert a whole sentence to Pig Latin
  // Precondition: text != null
  public static String toPigLatin(String text) {
    return null; // TODO
  }


  // 3
  // A command-line interface for the toRobber and toPigLatin methods
  public static void doCommandLine() {
    // TODO
  }


  // ---------- Del 2 ---------------

  // 4
  public static void rollADie() {
    // TODO
  }

  // 5
  public static void letPlayerRoll() {
    // TODO
  }

  // 6
  public static void letTwoPlayersRollSameDice() {
    // TODO
  }

  // 7 and 8    
  public static void letPlayerUseDiceCup() {
    // TODO
  }

  // 9
  public static void findPlayerWithMax() {
    // TODO
  }
}
