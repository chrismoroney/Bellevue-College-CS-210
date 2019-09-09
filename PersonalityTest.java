// CS210 Assignment #7 "Personality Test"
// Chris Moroney
// This assignment requires that we print the results of the Keirsey Personality Test
// for all of the characters in the file provided. The file provides the name of each
// character taking the test, and what their answers were. We had to take the answers
// (which was divided in 10 groups of 7 questions with four different tests) of each 
// character, and create data pertaining to the percent of "B" answers each character had
//, and then determine the type of personality they had. The main strategy of making this
// program is by using arrays, which will store multiple types of data.

import java.util.*;
import java.io.*;

public class PersonalityTest {

    public static void main(String[] args) throws FileNotFoundException {
	// loads in a scanner to read the file
        Scanner answerReader = new Scanner(new File("personality.txt"));
        // prints this line out
        System.out.println("**  This program reports the results for Keirsey Personality Test  **");
        // set a boolean for the purpose of a while loop
        boolean theEnd = false;
        // boolean states that it is false, which will activate the while loop
        while (theEnd == false){
            // if the file has another line, do the following
            if (answerReader.hasNextLine()){
                // the String called "name" is labeled as whatever the next line is
                String name = answerReader.nextLine();
                System.out.println();
                // seems strange, but this part will always print out a name
                // because of what is below.
                System.out.println(name + ":");
                // if there is another line after the "name", then do the following.
                if(answerReader.hasNextLine()){
                    // this next line will be the line that follows the name, which
                    // is all of the answers to each of the questions.
                    String dummy = answerReader.nextLine();
                    // create a new array, all consisting of String values
                    String[] theTests = new String[10];
                    // create a new array, consisting of ints
                    int[] results = new int[8];
                    // for loop creates the number of substrings required to make 
                    // 10 groups of 7, like stated in the HW assignment. 
                    for(int i=0; i<=9; i++){
                        // creates a string within the for loop, which is a sub string 
                        // to the bigger string, and is inserted as i.
                        theTests[i] = dummy.substring(i*7, (i*7)+7);
                        // call method sets by inserting the array results and string 
                        // from theTests at location (i).
                        sets(theTests[i], results);
                        
                    }
                    // this array is created in purpose to find percentages.
                    int[] percentages = new int[4];
                    int percentagesIndex=0;
                    // for loop increaes by incraments of two beacuse we want to take
                    // the 0th [i] from results first, but we don't want to perform the 
                    // function on each number. Therefore we can just add one to i
                    // to get our numerator
                    for(int i=0;i<8;i+=2){
                        // B answers are located on odd numbers of i (see method sets)
                        double numerator = results[i+1];
                        // add A and B answers, answers that are - are not added. 
                        double denominator = results[i] + results[i+1];
                        // have to cast this number as an int and round it to the nearest
                        // whole number in order to get percentage. 
                        int bVal =  (int) Math.round((100 * numerator) / denominator);
                        // insert the value into the array for percentages
                        percentages[percentagesIndex] = bVal;
                        // go to the next i value
                        percentagesIndex++;
                        
                    }
                    System.out.print("answers: [");
                    // Increase by incraments of two because of the same reasoning
                    // for the percentages for loop (see for loop in percentages area 
                    // directly above).
                    for(int index=0; index<8; index+=2){
                        System.out.print(results[index] + "A-");
                        System.out.print(results[index+1] + "B");
                        // fencepost, prevents the printing of comma after the last
                        // B
                        if(index!=6){
                            System.out.print(",");
                        }
                    }
                    System.out.println("]");
                    // prints out the array "percentages" and puts it as a string, 
                    // which is how it formats the way it does in the output.
                    System.out.println("Percent: " + Arrays.toString(percentages));
                    // creates new array of char's, this is to find the personality types
                    char[] profile = new char[4];
                    // We are comparing the number of B's to A's and -'s. If there are
                    // mostly B's, then it will cast a certain letter. If B is minority,
                    // then it will cast a different letter, and if it is the same (50-50), 
                    // then it will cast an X.
                    for(int i=0; i<8; i+=2){
                        // first category of questions.
                        if (i == 0){
                            // if more A's and -'s than B's, print this letter
                            if (results[i]>results[i+1]){
                                profile[0] = 'E';
                            // if B's are 50-50 with A's and -'s, print X
                            } else if (results[i]==results[i+1]){
                                profile[0] = 'X';
                            // if more B's than A's and -'s, print this letter
                            } else {
                                profile[0] = 'I';
                            }
                        // second category of questions.
                        } else if (i == 2){
                            // if more A's and -'s than B's, print this letter
                            if (results[i]>results[i+1]){
                                profile[1] = 'S';
                            // if B's are 50-50 with A's and -'s, print X
                            } else if (results[i]==results[i+1]){
                                profile[1] = 'X';
                            // if more B's than A's and -'s, print this letter
                            } else {
                                profile[1] = 'N';
                            } 
                        // third category of questions.
                        } else if (i == 4){
                            // if more A's and -'s than B's, print this letter
                            if (results[i]>results[i+1]){
                                profile[2] = 'T';
                            // if B's are 50-50 with A's and -'s, print X
                            } else if (results[i]==results[i+1]){
                                profile[2] = 'X';
                            // if more B's than A's and -'s, print this letter
                            } else {
                                profile[2] = 'F';
                            }
                        // fourth category of questions.
                        } else {
                            // if more A's and -'s than B's, print this letter
                            if (results[i]>results[i+1]){
                                profile[3] = 'J';
                            // if B's are 50-50 with A's and -'s, print X
                            } else if (results[i]==results[i+1]){
                                profile[3] = 'X';
                            // if more B's than A's and -'s, print this letter
                            } else {
                                profile[3] = 'P';
                            }
                        }     
                    }
                    System.out.print("type: ");
                    // prints out all of the letters from above using the for loop
                    for(int i=0;i<=3;i++){
                        System.out.print(profile[i]);
                    }
                    System.out.println();
                } 
            // comes here if there are no more lines in the program. If there is more
            // lines, returns back to the top and does it all over again. 
            } else {
                // sets boolean to true, ends the while.
                theEnd = true;
            }
        }
    }
    // this method counts the number of "category 1" (which is the first question in each substring)
    //questions are A or B, then goes to Category 2, 3, and 4. An array is then
    // storing the data that comes from the ints that are finalized from
    // all of the if statements.
    public static void sets(String resultsString, int[] answerCount){
        // this int is the index on each of the substrings
        int locater = 0;
        // since locater is less than the string length (which is 7), while is 
        // activated. If the locater reaches 7, then the while closes.
        while (locater<resultsString.length()){
            // char answer is always going to be 'the next character' in the answers.
            char answer = resultsString.charAt(locater);
            // this if statements counts category 1 answers.
            if (locater == 0){
                // add one to index 1 of the array if the answer is B
                if (answer == 'B' || answer == 'b'){
                    answerCount[1]++;
                // add one to index 0 of the array if the answer is A
                } else if (answer == 'A' || answer == 'a'){
                    answerCount[0]++;
                }   
            // this if statements counts category 2 answers
            } else if (locater == 1 || locater == 2){
                // add one to index 3 of the array if the answer is B
                if (answer == 'B' || answer == 'b'){
                    answerCount[3]++;
                // add one to index 2 of the array if the answer is A
                } else if (answer == 'A' || answer == 'a'){
                    answerCount[2]++;
                }
            // this if statements counts category 3 answers
            } else if (locater == 3 || locater == 4){
                // add one to index 5 of the array if the answer is B
                if (answer == 'B' || answer == 'b'){
                    answerCount[5]++;
                // add one to index 4 of the array if the answer is A
                } else if (answer == 'A' || answer == 'a'){
                    answerCount[4]++;
                }
            // this if statements counts category 4 answers
            } else {
                // add one to index 7 of the array if the answer is B
                if (answer == 'B' || answer == 'b'){
                    answerCount[7]++;
                // add one to index 6 of the array if the answer is A
                } else if (answer == 'A' || answer == 'a'){
                    answerCount[6]++;
                }
            
            }
            // add one to locater so that there is a way to stop the while loop.
            locater++;
        }
    }
}

