// CS210 Assignment #2 "Space Needle"
// Chris Moroney

public class SpaceNeedle {
    //this is the class constant
    public static final int SIZE = 4;
    public static void main(String[] args) {
        drawSpire();
        drawUpperDeck();
        drawWidth();
        drawLowerBowl();
        drawSpire();
        drawBody();
        drawUpperDeck();
        drawWidth();
    }
    // draws out the width at the base and in the upper area of the SpaceNeedle
    public static void drawWidth(){
        //begin with the | figure
        System.out.print("|");
        //prints out the quotes number of times to match the diameter
        for(int n=1; n<=(SIZE*6); n++){
            System.out.print("\"");
        }
        //end with the | figure
        System.out.println("|");
    }
    
    //draws the simple || parts (if solely isolated)
    public static void drawSpire(){
        //prints the || this many times, which is proportional to the size
        //same number of || as the constant SIZE, and 3 times the spaces from
        //the SIZE
        for(int n=1; n<=SIZE; n++){
            for(int y=1; y<=(SIZE*3); y++){
                System.out.print(" ");
            }
            //ends this loop by printing new line after ||
            System.out.println("||");
        }
    }
    //draws out the upper deck and base of the SpaceNeedle
    public static void drawUpperDeck(){
        //I set up two variables at the beginning to be used for later, opposed
        //to using the actual equations in the for loops
        int numberOfColons;
        int numberOfSpaces;
        //number of rows this program will execute is dependant on the constant
        //SIZE
        for(int row=0; row<SIZE; row++){
            numberOfSpaces = ((SIZE-row-1)*3);
            //number of spaces is mathematically found above, proportional to
            //the SIZE
            for(int thisSpace=1; thisSpace<=numberOfSpaces; thisSpace++){
                System.out.print(" ");
            }
            //number of colons is found mathematically with respect to the rows
            //and SIZE
            numberOfColons=3*row;
            //prints out the figure before the series of colons
            System.out.print("__/");
            //with above statement, will print number of colons
            for(int thisColon=0; thisColon<numberOfColons; thisColon++){
                System.out.print(":");
            }
            //this is the continued spine of through this segment, will appear
            //everytime there is a row with colons
            System.out.print("||");
            //this prints colons on the other side of the spine
            for(int reverseColon=0; reverseColon<numberOfColons; reverseColon++){
                System.out.print(":");
            }
            //end this nested loop by printing out the \__ and a new line
            System.out.println("\\__");
        }
    }
    public static void drawLowerBowl(){
        //I set up two variables at the beginning to be used for later, opposed
        //to using the actual equations in the for loops
        int numberOfSpaces;
        int numberOfArrows;
        //determines number of rows should be present in this section, which is
        //proportional to the constant SIZE of the SpaceNeedle
        for(int row=0; row<SIZE; row++){
            //mathematical proportion to the number of spaces in each row
            numberOfSpaces = (row*2);
            //printed amount of spaces that are present in each row
            for(int spaces=0; spaces<numberOfSpaces; spaces++){
                System.out.print(" ");
            }  
            //mathematical proportion for number of /\ that will be printed with
            //respect to the class constant SIZE
            numberOfArrows = (3*SIZE)-(2*row+1);
            //before printing out the number of /\'s, need to print out the start
            //of each row after spaces witht this figure
            System.out.print("\\_");
            //This prints out the number of arrows per row, which is repetitve
            //according to the row number and constant SIZE
            for(int Arrows = 0; Arrows<numberOfArrows; Arrows++){
                System.out.print("/\\");
            }
            //end this nested loop with the final character part and a new line
            System.out.println("_/");
        }
    }

    public static void drawBody(){
        //Variable set up prior for the sakes of not putting the whole equation 
        //into the for loop
        int numberOfSpaces=2*SIZE+1;
        //number of spaces per row, respect to SIZE (it is a square function)
        for(int row=0; row<SIZE*SIZE; row++){
            for(int Spaces=0; Spaces<numberOfSpaces; Spaces++){
                System.out.print(" ");
            }
            //prints out the | before the percentages
            System.out.print("|");
            //prints the number of %'s on the left of the spine, it is two less
            //than the constant SIZE
            for(int percents=0; percents<SIZE-2; percents++){
                System.out.print("%");
            }
            //prints the spine for each row
            System.out.print("||");
            //prints out the %'s on the right side of the spine, which is two
            //less than the Constant SIZE number
            for(int percents=0; percents<SIZE-2; percents++){
                System.out.print("%");
            }
            //ends the nested loops and prints a new line with the figure included
            System.out.println("|");
        }
    }
}