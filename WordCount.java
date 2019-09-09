// CS210 Assignment #4 "Word Count"
// Chris Moroney
// For this assignment, my job was to calculate the total number of words in a string
// and return its proper value. The challenge of this assignment was to be able to 
// recognize what a word really is and translate it into java. There were times where
// I thought I had the correct value, but it turns out that I didn't. I was able to 
// distinguish words in the end by creating two scenarios using if statements, being 
// the first character, and every other character. I would then use a for loop to collectively
// tell the program when to add one towards the overall return value, which would be the
// number stating the number of words. 
public class WordCount{
    public static void main(String[] args){
        // this line represents the return value, as the assignment requires us to
        // return the number of words in the string entered.
        int words = wordCounter("");
        // here are all of the lines that were in the examples of the HW file
        System.out.println(wordCounter("hello"));
        System.out.println(wordCounter("how are you?"));
        System.out.println(wordCounter("  how are you?"));
        System.out.println(wordCounter("how are you?  "));
        System.out.println(wordCounter("how are you ?"));
        System.out.println(wordCounter("I am 3 years old"));
        System.out.println(wordCounter("3 x 4 = 12"));
        System.out.println(wordCounter("Characters !@$^&*"));
        System.out.println(wordCounter("  "));
    }
    // this part is the part that does that actual "word counting"
    public static int wordCounter(String inputString) {
        //two variables, a string that would be the input parameter pertaining to how
        // the function will be able to work, and an int named "words", which is what
        // we will be returning
        String phrase = inputString;
        int words = 0;
        // this for loop will start at 0 and continue to increase until the total mumber 
        // of characters in the index of the inputed string. 
        for(int i=0; i<phrase.length(); i++)
            // As stated above in the summary, there are two groups, the first character
            // and everything else. This first if statement represents the first character.
            // If the first character is not a space, add one to the int "words".
            if ((i == 0) && (phrase.charAt(0) != ' ')){
                    words++;
                    }
            // this statements pertains to all other characters in the string
            // If the character at position (i) is not a space, and the character before
            // that space is a space, add one to the int. 
            else if  ((phrase.charAt(i) != ' ') && (phrase.charAt(i-1) == ' ')){
                    words++;
                    }
            // everything else will not add towards the int.
        // return the int to the main function.
        return words;
    }
}
