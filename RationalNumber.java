// CS210 Assignment #8 "Rational Number"
// Chris Moroney
// The goal of this project is to use classes to establish a rational number function
// that will call various other classes in how the rational number is to be used. 
// The part that comes into play that applies to Chpater 8: classes, is that nothing is actually printed.
// Everything is written here so that it can be used in a different program in the 
// same file. The whole purpose of this is to make the entire code neater. While
// I probably could create this same function in just one written page of code, the
// use of additional classes makes the code much cleaner. 
public class RationalNumber {
        // these private ints are set to private so that if they are to be used,
        // they have to be referenced using accessors in the code, or else 
        // the reading code that uses these ints will get confused.
        private int myNumerator;
        private int myDenominator;
        
	// If this class is called, then there must be an input of a numerator and 
        // denominator, this will essentially be the PARTS of the rational number
        public RationalNumber(int numerator, int denominator) {
            //inputed numerator and denominator
            myNumerator = numerator;
            myDenominator = denominator;
	}
	
	// If not rational number is inputed, then the default number will be 0/1 or
        // just 0.
        public RationalNumber() {
            //default numerator and denominator
            myNumerator = 0;
            myDenominator = 1; 
	}
	
	// This class will return just the denominator value of the rational number
        public int getDenominator() {
            // inputed denominator
            return myDenominator;
	}
	// This class will return just the numerator value of the rational number
	public int getNumerator() {	
            //inputed numerator
            return myNumerator;
	}
        // this class will create a string that shows the actual rational number.
        // If the denominator is 1, then the string will only provide the numerator
        // value as a string. If the numerator is 0, then the string will only show a value of 0.
        // If the denominator is 0, then whenever that inputed "number" is reference,
        // it will display as an invalid number. Everything else will show the 
        // rational number as the numerator value followed by a / sign followed by the 
        // denominator value.
	public String toString() {
            // string value that will be returned
            String theRationalNumber = "";
            // if denominator is one, just show the numerator
            if (myDenominator == 1){
                theRationalNumber = "" + myNumerator;
            //if denominator is 0, invalid input
            } else if (myDenominator == 0){
                theRationalNumber = "Invalid Number : Zero denominator";
            // if numerator is 0, show 0
            } else if (myNumerator == 0){
                theRationalNumber = "0";
            // any other case, show (numerator)/(denominator)
            } else {
                theRationalNumber = myNumerator + "/" + myDenominator;
            }
        // whatever is returned, 
            return theRationalNumber;
        }
	// will take the original rational number, and another rational number (that 
        // can be inputed or not), and will add them together.
	public RationalNumber add(RationalNumber other) {
            int newDenominator = 0;
            int newNumerator = 0;
            // if the denominators are not the same, then it will cross multiply, then
            // add numerators over the new denominators.
            if (myDenominator != other.getDenominator()){
                newDenominator = myDenominator * other.getDenominator();
                newNumerator = (myDenominator * other.getNumerator())+(other.getDenominator()*myNumerator);
            // if the denominators are the same, just add the numerators and keep the denominators.
            } else {
                newDenominator = myDenominator;
                newNumerator = other.getNumerator()+myNumerator;
            }
            // this will create a new rational number with the inputed results, so 
            // that it can be returned as a string when viewed.
            RationalNumber theResult = new RationalNumber(newNumerator, newDenominator);
            return theResult;
	}
        // will take the original rational number, and another rational number (that 
        // can be inputed or not), and will subtract them.
	public RationalNumber subtract(RationalNumber other) {
            int newDenominator = 0;
            int newNumerator = 0;
            // if the denominators are not the same, then it will cross multiply, then
            // subtract numerators over the new denominators, starting with the original numerator.
            if (myDenominator != other.getDenominator()){
                newDenominator = myDenominator * other.getDenominator();
                newNumerator = ((other.getDenominator()*myNumerator)-myDenominator * other.getNumerator());
            // if the denominators are the same, just add the numerators and keep the denominators.
            } else {
                newDenominator = myDenominator;
                newNumerator = myNumerator-other.getNumerator();
            }
            // this will create a new rational number with the inputed results, so 
            // that it can be returned as a string when viewed.
            RationalNumber theResult = new RationalNumber(newNumerator, newDenominator);
            return theResult;
        }
        
        // will take the original rational number, and another rational number (that 
        // can be inputed or not), and will multiply them together.
	public RationalNumber multiply(RationalNumber other) {
            //denominators multiply by eachother
            int newDenominator = myDenominator * other.getDenominator();
            // numerators multiply by eachother
            int newNumerator = myNumerator * other.getNumerator();
            // this will create a new rational number with the inputed results, so 
            // that it can be returned as a string when viewed.
            RationalNumber theResult = new RationalNumber(newNumerator, newDenominator);
            return theResult;
        }
        // will take the original rational number, and another rational number (that 
        // can be inputed or not), and will divide them.
	public RationalNumber divide(RationalNumber other) {
            // Rules of dividing fractions: flip and multiply the second fraction!
            
            //numerator of original rational number multiplies by the other rational numbers' denominator
            int newNumerator = myNumerator * other.getDenominator();
            //denominator of original rational number multiplies by the other rational numbers' numerator
            int newDenominator = myDenominator * other.getNumerator();
            // this will create a new rational number with the inputed results, so 
            // that it can be returned as a string when viewed.
            RationalNumber theResult = new RationalNumber(newNumerator, newDenominator);
            return theResult;
        }	
}
