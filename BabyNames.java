// CS210 Assignment #6 "baby names"
// Chris Moroney
// The goal of this project is to take the file names.txt, scan the file for a name, and 
// be able to find the data as to the number of that name has been used to name babies
// from 1920 to 2000. This project involves incorporating scanners in order to read files, 
// being able to tell the scanner when to print data and when to stop, and then being
// able to export data into a file through a PrintStream. If the name is not found in 
// the file, then there will be no file exported, nor will any data print in the output. 
// I couldn't figure out the graphic design part, however, so I understand I will not
// recieve full credit for this assignment. 
import java.io.*; // for file
import java.util.*; // for scanner
public class BabyNames {
    public static void main(String[] args) throws FileNotFoundException {
        // This line is a scanner that is able to read the File, which is names.txt
        Scanner names = new Scanner(new File("names.txt"));
       
        //These lines are just printed in the output of the program
        System.out.println("** Popularity of a baby name since year 1920 **");
        System.out.print("name? ");
       
        // This scanner is a System.in, which is where the user inputs data. In this case
        //, the inputed data is to be a String, which ideally would be a name. 
        Scanner nameInput = new Scanner(System.in);
        // String theName is the name that is inputed
        String theName = nameInput.next();
        
        // boolean set to false to activate the while loop
        Boolean detected = false;
        
        // while loop is active because of the boolean. 
        while (detected == false){
            // if in the file, the next token is a string or able to be a string, then String thisName is 
            // that token.
            if(names.hasNext()){
                // a new String, thisName, will be the the next string that is scanned.
                String thisName = names.next();
                
                // if the token that is saved as a string is the same as the name that is 
                // inputed from the System.in prompt, then it will do the follwing.
                // As long as the letters come in the same place as the name (case doesn't matter), 
                // the name will be the same. Will keep scanning each line until it 
                // finds that the names are the same.
                if(thisName.equalsIgnoreCase(theName)){
                    
                    // This will be a string, which will be used to create the exported
                    // data file's name
                    String outFileName = thisName + ".txt";
                    // Create a new PrintStream with file name of the string above. 
                    PrintStream outFile = new PrintStream(new File (outFileName));
                    
                    // Will simply print the desired name, which is the name in the File, names.txt
                    //, found by a scanner
                    outFile.println(thisName + ",");
                        
                    // This for loop keeps track of which year the number corresponds 
                    // with in the data. 
                    for (int year = 1920; year < 2000; year+=10){ 
                        // int qty will be the next integer of that line.
                        int qty = names.nextInt();
                        // Print with a new line, the year, a colon, and the int from above.
                        System.out.println( year +  " : " + qty);
                        // do the same thing as above, just in the exported file, and followed
                        // with a comma. 
                        outFile.println(year + " : " + qty + ",");
                            }
                    
                    // This int is just for the sakes of having a fencepost-like structure
                    // for the exported file, outFile. Since the patterns are different
                    // in the for loop between the output in the program and in the 
                    // exported file, the finalQTY is used.  
                    int finalQTY = names.nextInt();
                    // Simply print the final piece of data essentially in the output of the program.
                    System.out.println("2000 : " + finalQTY);
                    // Simply print the final piece of data essentially in the exported file. 
                    outFile.println("2000 : " + finalQTY);
                    // sets boolean to true, closes the while loop at the top. 
                    detected = true;
                    }
            
            // The program will come to here if the file is scanned ALL the way through
            // and can't find the name, which essentially means theName and thisName are never 
            // able to be equal. 
            } else {
                // Can't find the name, name will not be found.    
                System.out.println("name not found.");
                // close the while loop, program is over. 
                detected = true; 
            }
        }
    }
}

