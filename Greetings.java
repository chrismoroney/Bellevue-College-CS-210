// CS210 Assignment #3 "Greetings"
// Chris Moroney
// This program is the Greetings.java program from the website. Here in this
// program, the biggest lesson is about parameters and methods. In the main
// function, I created a scanner that would be put eventually into the getGreetings
// method. In that method, ther parameters require a Scanner to be imputed, and will
// produce a string of data, which is essentially the message given at the end
// of the program. For the getCalenderYear method, there were no parameters, so 
// nothing had to be inputed in order to recieve an integer that would be used to 
// help find the age of the greetee. 
import java.util.*;

public class Greetings {

    public static void main(String[] args) {        
        //input a new scanner, which will be put into the getGreetings method, 
        //basically is what starts the actual program.
        Scanner s = new Scanner(System.in);
        System.out.println(getGreetings(s));
    }

    // this is the getGreetings method, it needs a scanner (which is given above)
    // in order to produce a String of data.
    private static String getGreetings(Scanner console) {        
        // this is the program to transform the first name into a capital initial
        System.out.print("Please enter your first name: ");
        String firstName = console.nextLine();
        String oneLetter = firstName.substring(0,1);
        String firstLetter = oneLetter.toUpperCase();

        // this is the part that prints the last name with a Capital first letter
        System.out.print("Please enter your last name: ");
        String secondName = console.nextLine();
        String letterHead = secondName.toUpperCase().substring(0,1);
        String letterTail = secondName.substring(1);
       
        // this is just simply where one enters the year of birth, which comes 
        // into play for theGreetings and getCalenderYear
        System.out.print("Please enter your birth year: ");
        int year = console.nextInt();
        
        // this is everything that will be produced in the string, it includes
        // some text and all of the variables from above.
        // for the year, I used the integer from below in getCurrentYear() and 
        // subtracted it with the value that is imputed from the Scanner for 
        // getting the birth year
        String theGreetings = ("Greetings, " + firstLetter + "." + " " + letterHead+letterTail + "! You are about "+ (getCurrentYear()-year) + " years old.");
        
        // when the program inputed a scanner at the beginning, we got out a string,
        // which will be produced at the top in the main.
        return theGreetings;
    }
    
    // Gets the current year
    // This is the code given by Ms. Li. Here, we don't need to input anything
    // in order to get the Calender Year, which basically means it is already given
    // to us in the form of an int.
    private static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
