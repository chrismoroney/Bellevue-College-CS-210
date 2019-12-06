// CS210 Extra-Credit #1 "Animated Car"
// Chris Moroney
// This task is the Extra-Credit #1, containing a Car that is to be annomated. What
// I needed to do was to take the coordinates and graphics of the car and modify them
// to appear that the car moves horizontally. By importing graphics, the car was able
// to take shape in the form of coordinates. Then, to actually move the car, I used a for loop
// and replace the original graphics with the background color for the effect of movement. 
package animatedcar;
import java.awt.*;


public class Car {

    public static void main(String[] args) {
        // Must start the program by inserting the graphics, meaning that the method requires 
        // an input of containing graphics. The variable g represents this in the 
        // methods. 
        DrawingPanel panel = new DrawingPanel(200, 100);
        panel.setBackground(Color.LIGHT_GRAY);
        Graphics g = panel.getGraphics();
        //nested loop is for moving the car. The x is always increasing, meaning the
        //car will move horizontally. The 30 for the y keeps the car from moving unpredictably
        // and losing shape of the car. The g is just to insert the graphics.
        for(int x=10; x<=200; x++){
            drawCar(x, 30, g);
            //This helps to slow the car down enough to see the car move. If this isn't 
            // here, then the car won't be visible because it moves so fast.
            panel.sleep(30);
            clearCar(x, 30, g);
        }

    }
    //have to input an x coordinate, y coordinate, and graphics in order to insert a 
    // place for the car to start
    public static void drawCar(int x, int y, Graphics g){
        // car body
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 100, 50);
        
        // wheels
        g.setColor(Color.RED);
        // the reason why the x and y have remained in terms of x and y is for
        // sakes of the moving process, even though the car is only moving one way. 
        // When the car is moving, the car needs an x and y to work with for the coordinates. 
        // The relationship between the car body and the wheels is below for the x and y. 
        // This helps the car to move.
        g.fillOval(x+10, y+40, 20, 20);
        g.fillOval(x+70, y+40, 20, 20);
        
        // window
        g.setColor(Color.CYAN);
        // same reasoning as for the wheels, put in x and y for the sakes of movement.
        g.fillRect(x+70, y+10, 30, 20);

    }
    
    // The purpose of this is to make sure that the previous coordinates do not remain.
    // If the previous coordinates remian with the program, then the car will turn
    // into one giant smudge! This helps the car appear like it is moving. 
    public static void clearCar(int x, int y, Graphics g){
        // car body, color of the background
        g.setColor(Color.LIGHT_GRAY);
        //resets the previous coordinates, turns to light gray.
        g.fillRect(x, y, x+100, y+60);

    }
}
