
// CS210 Assignment #1
// Chris Moroney
// I did not copy completely from the slides on how to do this problem.
// I threw in my own variation of this, and although it is not the most 
// efficient method of completing this problem, all work is my own and original
// work.
// This assignment is the two rockets assignment

public class Chapter1Ex11 {
    public static void main(String[] args) {
    	uparrows();
    	structure();
    	united();
    	states();
    	structure();
    	uparrows();
    }
    // helps reduce redundencies in the body of the rockets
    public static void structure(){
        segments();
        columns();
        segments();
    }
    //is the nose caps and the rocket boosts in each of the rockets
    public static void uparrows() {
        System.out.println("   /\\\t    /\\");
        System.out.println("  /  \\\t   /  \\");
        System.out.println(" /    \\\t  /    \\");
    }
    //the divided sections of the rocket
    public static void segments() {
        System.out.println("+------+ +------+");
    }
    //the vertical bodies of the rockets
    public static void columns() {
        System.out.println("|      | |      |");
        System.out.println("|      | |      |");
    }
    //The part of the rocket labeled "United"
    public static void united() {
        System.out.println("|United| |United|");
    }
    //part of the rocket labeled "States"
    public static void states() {
        System.out.println("|States| |States|");
    }
}