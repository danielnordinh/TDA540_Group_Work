import java.util.Scanner;

/**
 * This class is a skeleton. Don't change the overall
 * structure but just uncomment and add code where needed.
 */
public class CommandLineLCR {

  public static void main(String[] args) {

            testLCRGame();
    // TODO: Uncomment this when you are done
    // runCommandLineLCR();
  }

  // TODO: For each class you implement, add a method here to test it.
  private static void testLCR_Die() {
      LCR_Die dice = new LCR_Die();
      for (int i = 0; i < 100; i++) {
          System.out.print(dice.roll() + " ");
      }
  }

  private static void testLCR_Player(){
      LCR_Die dice = new LCR_Die();
      LCR_Player otto = new LCR_Player("Otto",dice, 1);

      System.out.println("Number of chips = " + otto.getChips());
      System.out.println("Number of rolls = " + otto.getNbRolls());
      System.out.println("Last dice result = " + otto.rollDice());
      System.out.println("---");
      System.out.println(otto.toString());
      System.out.println("---");
      System.out.println("Number of chips = " + otto.getChips());
      System.out.println("Number of rolls = " + otto.getNbRolls());
      otto.addChips(2);
      System.out.println("Number of chips = " + otto.getChips());
      System.out.println("Number of rolls = " + otto.getNbRolls());
      System.out.println("---");

  }

  private static void testLCRGame(){
      LCRGame lcrGame = new LCRGame("Astrid", "Mary","Emily");
      System.out.println(lcrGame.getDice());
      System.out.println(lcrGame.getPlayerLeft(1));
      System.out.println(lcrGame.getPlayerRight(1));
      System.out.println(lcrGame.getPlayers());

      LCR_Die dice = new LCR_Die();
      LCR_Player Agatha = new LCR_Player("Agatha",dice,3);
      System.out.println(lcrGame.playRound(Agatha));

      lcrGame.playGame();
      System.out.println(lcrGame.getWinner());


  }

  // TODO: Uncomment below when possible
  public static void runCommandLineLCR() {

      LCRGame lcr = buildLCRGame("Fjodor","Chekhov", "Leo");
    System.out.println("LCR started");
     //render(lcr);

    Scanner s = new Scanner(System.in);

    boolean done = false;
    while (!done) {
      //System.out.println("Current player is " + ...);
      System.out.print("> ");
      String cmd = s.nextLine();
      switch (cmd) {
        case "r":
            //  lcr.playRound
          // TODO: Play one player's turn and render the game's state
          break;
        case "q":
          done = true;
          break;
        default:
          System.out.println("Enter 'r' to continue or 'q' to quit");
      }
    }

    /*
    if ( ... ) {
      // Game is finished
      System.out.println("Game over! Winner is " + lcr.getWinner());
    } else {
      // Game was aborted
      System.out.println("Game aborted");
      render(lcr);
    }*/
  }


  private static LCRGame buildLCRGame(String name1, String name2, String name3) {

    LCRGame lcrGame = new LCRGame(name1, name2, name3);
    return lcrGame;
  }
  /*
  private static void render(LCRGame lcr) {

    // This needs overridden toString method to work!
    for (LCR_Die d : lcr.getDice()) {  //??
      System.out.print(d + "  ");
    }
    System.out.println();
    System.out.print("Players: ");
    for (LCR_Player p : lcr.getPlayers()) {   //??
      System.out.print(p + " ");
    }
    System.out.println();

  }*/



}


