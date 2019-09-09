// CS210 Assignment #5 "GuessingGame"
// Chris Moroney
// The GuessingGame project is all about the classic game of guessing a number
// from 1 to 100. In the computer program, however, the project is all about repeating
// a loop if certain parameters remain true. Building a single game is simple; just
// create an if else statement stating that if the guess is higher than the random
// int, then say the random int is lower, and the other way around if the guess is lower. 
// The challenge comes in when we are asked if we want to start a new game. 
// In what way are we able to play a new game while keping the same amount of data?
import java.util.*;

public class GuessingGame {
    // all of these public integers are starting points for the program to come.
    // these are necessary because we need keep the variables that are used to issue
    // a new game to come. These variables are placed here in this form so that 
    // we can keep the data that comes any more games to come
    public static int z=0;
    public static int attempts = 0;
    public static int games=0;
    // this particular public int is set to 101 because when the user does not want to play
    // anymore, one of the stats that comes up is the best number of guesses. Assuming
    // that the user does not repeat any numbers from 1 to 100, the least number of guesses
    // that comes from any game will replace the 101 in the else statement (the one with
    // double ratio, double zDouble, etc.)
    public static int bestGameGuesses=101;
    
    public static void main(String[] args) {
        // This is how we start the game. The user will always begin a game automatically. 
        boolean stillPlaying = true;
        // the boolean above passes through the while function, which will start 
        // the method newGame()
        while(stillPlaying==true){
            // the stillPlaying may no longer still be equal to the newGame, as the 
            // newGame may return a boolean stating false. That will close the loop, 
            // stop the game, and print the results.
            stillPlaying = newGame(attempts);
        }
    }
    public static boolean newGame(int attempts){
        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.print("Your guess? ");
       // this boolean is simply a place holder, in case the while loop collapses
       // then the boolean can return to the top and start again.
        boolean returnVal = true;
        // program is prompted to choose a number between one and 100, random. 
        Random random = new Random();
        int randomNumber = random.nextInt(99)+1;
        // this is where the user inputs their "guess" as to what the mystery number is/
        Scanner guess = new Scanner(System.in);
        // set victory to false to activate the while loop.
        boolean victory = false;
        
        // now that we have entered the while loop with the boolean above, this 
        // is where the actual game play is. 
        while (victory == false){
            // input must always be an int
            int number;
            number = guess.nextInt();
            // for every int that is entered, variable attempts increases by one
            attempts++;
            
            // if number is correct to randomNumber, the program moves here. 
            if (number == randomNumber){
                // stores values that correspond to how well someone does.
                if(attempts<=bestGameGuesses){
                    // the best game that someone has will store the number of attempts here
                    bestGameGuesses = attempts;
                } else{   
                }
                // stop the while loop 
                victory = true;
                // increases the number of games that have been fully played
                games++;
                // this int will add up ALL of the attempts across all games, will
                // be displayed in results. 
                z += attempts;
                System.out.println("You guessed it in " + attempts + " tries!");
                System.out.print("Play again? ");
                
                // this scanner will be able to read a string and will send that response
                // to the if statement
                Scanner newGame = new Scanner(System.in);
                String response = newGame.next();
               
                // after reading the string, looks at the first letter to determine
                // what happens next.
                
                // here, the program will start another game.
                if (response.charAt(0) == 'y' || response.charAt(0) == 'Y'){
                        System.out.println();
                        // resets int attempts here for the new game
                        attempts = 0;
                        // sets the boolean returnVal as true to return to main function
                        // which will start a new game.
                        returnVal = true;
                // in the else statement, the user does not want to play again.      
                } else {
                        // creates new doubles to be used in the ratio of Guesses/game
                        double ratio;
                        double zDouble = z;
                        double gamesDouble = games;
                        ratio =  zDouble / gamesDouble;
                        // these are all of the printed results
                        System.out.println(); 
                        System.out.println("Your overall results:");
                        System.out.println("Total games = "+ games);
                        System.out.println("Total guesses = " + z);
                        System.out.println("Guesses/game = " + ratio);
                        System.out.println("Best game = " +bestGameGuesses);
                        // sets returnVal to false, which will send the boolean
                        // back to main, which will cause main to stop the while loop
                        // of starting the method newGame, which ultimately ends the
                        // program.
                        returnVal = false;
                        
                    }
            // here, the guessed number is too low, and the user needs to input a 
            // greater number than the previous guess. Sent back up to the while 
            // loop because the boolean victory is still false. 
            } else if(number < randomNumber){
                
                System.out.println("Its higher.");
                System.out.print("Your guess? ");
            
            // this input number is too high, and user needs to put a smaller number 
            // than the previous guess. Program goes back to the while loop because
            // boolean victory is still false.
            } else {
                
                System.out.println("It's lower.");
                System.out.print("Your guess? ");
            }

            
        }
        // this returnVal is stored as a boolean and will be sent back to the main function.
        // If this value is true, then the program still runs and a new game is created. 
        // If this value is false, then the program will stop and pring results. 
        return returnVal;
    } 
}
  
    
