// CS210 Assignment #4 "Birthdays"
// Chris Moroney
// This assignment required me to display different types of return values based on
// what the data in the scanner read. To start, I had to calculate what the start
// date was, which was the today's date. I do this in my countDays function. Next, I had to
// calculate which day each person's birthday falls on, which is also involving the
// countDays function, but also the doBirthdays function below. Finally, I had to 
// distinguish which birthday was sooner, which I simply use an if/ else statement 
// in the main function.

//this is for the scanner ability
import java.util.*;
public class Birthdays {
    public static void main(String[] args) {
        // this part establishes the today date. It involves the countDays function 
        // to determine what the value stored will be within the countDays function. 
        // This value will tell which # out of 365 the day is. 
        Scanner todayScanner= new Scanner(System.in);
        System.out.print("Please enter today’s date (month day) : ");
        
        // these int values are the two numbers inputed into the scanner (month day)
        int todayMonth = todayScanner.nextInt();
        int todayDay = todayScanner.nextInt();
        // this int value is collected using the function countDays, and the two 
        // ints above are the input parameters in the function.
        int todayDOY = countDays(todayMonth, todayDay);
        
        // will print "today's" date
        System.out.println("Today is " + todayMonth + "/" + todayDay + "/2018, day #" + todayDOY + " of the year.");
        System.out.println();

        // these ints came from the doBirthdays function. Originally, the name in the
        // doBirthdays function was reported Birthday, but was changed because the returned
        // value is now stored in this new name. 
        // these ints are simply used for the if statement directly below.
        int reportedFirstBirthday = doBirthdays("Please enter Person #1's birthday (month day) : ", todayDOY);
        int reportedSecondBirthday = doBirthdays("Please enter Person #2's birthday (month day) : ", todayDOY);
        // This is the birthday comparison. The if will compare which value is smaller.
        // In doBirthdays, the returned value was a value that states how many days
        // until their next birthday. Therefore, it makes sense that one's birthday will 
        // be sooner if the returned value is smaller. This is what the comparison
        // is in the if and else statement.
        if ((reportedFirstBirthday) < (reportedSecondBirthday)){
            System.out.println("Person #1's birthday is sooner");
        } else if ((reportedFirstBirthday) > (reportedSecondBirthday)){
            System.out.println("Person #2's birthday is sooner");
        } else {
            System.out.println("Wow, you share the same birthday! ^_^");        }
        System.out.println();
        // just a fun fact about my birthday :)
        System.out.println("Thank you for using this free program.");
        System.out.println("Speaking of free, did you know that 11/9 is World Freedom Day?");
        System.out.println("Take some time to appreciate all of the freedoms around us.");
        System.out.println("This includes what we do to celebrate our birthdays!");
    }

    
    // This method uses the countDays function to determine where in the year the birthday
    // lies, and then will calculate when their next birthday is. It is used twice in the 
    // function for the two birthdays.
    public static int doBirthdays(String prompt, int todayDOY){
        Scanner birthday = new Scanner(System.in);
        // the prompt is the input from above, which is to input the birthday
        System.out.print(prompt);
        // these inputs come from the scanner. The scanner will read the two integers
        // and store the values under BirthdayMonth and BirthdayDay
        int BirthdayMonth = birthday.nextInt();
        int BirthdayDay = birthday.nextInt();
        // this int calls upon the counDays function, using the two ints above.
        int BirthdayDOY = countDays(BirthdayMonth, BirthdayDay);
        //This println prints when the birthday day is in the year in terms of days (ex. #23 of 365)
        System.out.println(BirthdayMonth + "/" + BirthdayDay + "/2018 falls on day #" + BirthdayDOY + " of 365.");
        // this is the value that will be returned. This value will be used to compare
        // which birthday will come sooner.
        int reportedBirthday=0;
        // We need an if statement because if the function just took BirthdayDOY - todayDOY
        // there is a possibility of a negative value, which will skew which birthday
        // comes first (and there is no such thing as a negative birthday).
        if ((BirthdayDOY)<(todayDOY)){
            reportedBirthday = (365-(todayDOY-BirthdayDOY));
        } else {
            reportedBirthday = (BirthdayDOY - todayDOY);               
        }
        // will say in how many days the next birthday is.
        System.out.println("Your next birthday is in " + reportedBirthday + " day(s).");
        // if today is the birthday, will print this statement.
        if ((BirthdayDOY-todayDOY) == todayDOY){
            System.out.println("Happy Birthday! :)");
        } else {
            
        }
        System.out.println();
        // returns this int value back to the main function, it was altered in the if statement. 
        return reportedBirthday;
        
    }
    // This function determines the day either in the today date, or the birthday. 
    // What I did was I made a string representing each month. In the string, month,
    // the L represents a month with 31 days, S with 30 days, and T with 28 days. 
    // Then, using a for loop and an if statement, I would use the int "i" to represent
    // which month would be the month used by counting all of the previous months
    // and the days that were in those days. This way, I would get all of the days
    // from the previous months. I finish by adding the inputed integer "my day" to 
    // get the overall number of the day in the year (ex. day #265 of 365)
    public static int countDays(int myMonth, int myDay){
        String month = "LTLSLSLLSLSL";
        // put this in so that there is a value we can return
        int numberOfDays = 0;
        // the for loop, starting at zero, which would effectively be the first letter.
        // since the first letter represents january, there are no other months to count
        // all the days of, so the int would just be 0 + myDay.
        for (int i=0; i<myMonth-1; i++){
            // if statement, starting with the first letter of the string, counts
            // forward, then will add up all of the days towards the total numberOfDays.
            if(month.charAt(i) == 'L'){
                numberOfDays += 31;
            } else if(month.charAt(i) == 'T'){
                numberOfDays += 28;
            } else {
                numberOfDays += 30;
            }
        }
        //numberOfDays is calculated through the for loop and if statement, myDay is
        // a parameter input
        numberOfDays+=myDay;
        // the return value in the form of an int
        return numberOfDays;
    }
}
