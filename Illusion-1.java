// CS210 Assignment #3 "Circles"
// Chris Moroney
// This is the illuion project. This project is mainly composed of functions that
// contain a lot of inputs. These inputs are especially important because they 
// are the parameters of how each method will be executed in drawing their shapes. 
// Within each method are loops, calculations to find points, and coded lines from the 
// drawing panel to assist in the artistic perspecting (such as color, shape types, etc.).
// The hardest part for me was to algorithimically figure out each function so 
// that the shapes could be well drawn and proportonal. However, once I figured it
// out, the easiest part was simply just inputing numbers that fit the variables, 
// which consisted of coordinates and lengths. 
import java.awt.*;

public class Illusion {

    //calls the drawFigures method
    public static void main(String[] args) {
        drawFigures();
    }
    // This is the order that all of the methods are executed. Additionally, what
    // is most important are the values that are inputed into each method. Each statement
    // below contains coordinates and lengths for the dimensions that each shape
    // needs to hold in order to be drawn out to proper length, inscribed, or simply
    // put to scale. 
    public static void drawFigures() {
        DrawingPanel dp = new DrawingPanel(500,400);
        dp.setBackground(Color.cyan);
        Graphics g = dp.getGraphics();
        drawDiamondInCircles(0, 0, 90, 3, g);
        drawDiamondInCircles(120, 10, 90, 3, g);
        drawDiamondInCircles(250, 50, 80, 5, g);
        drawCirclesInBox(350, 20, 40, 5, 3, g);
        drawCirclesInBox(10, 120, 100, 10, 2, g);
        drawCirclesInBox(240, 160, 50, 5, 4, g);
    }
    // This method will draw the number of circles in each "area". It starts with
    // the base circle, which is just given an (x,y), and a width r. However, if 
    // there are more circles that are wanted inside of the largest circle, then
    // by using a nested loop, there will be another circle printed inside, which
    // is proportional to the largest most circle. The circles are spaced with the 
    // intervals that are calculated in relation to the radius, which then effects the amount
    // of circles. Finally, a diamond is drawn to be inscribed inside of the largest circle. 
    public static void drawDiamondInCircles(int x, int y, int r, int numCircles, Graphics g){
        // This part is where all of the variables are defined. I named the diamter (r)
        // of all the circles to be the diamter divided by the total number of circles. 
        // The center was given by moving the location of the original (x,y), which
        // was in the top left-most corner of a square, in relation to the next x and
        // y coordinates. The coordinates always move inwards by the same incrament
        // beacuse the shape is a circle, as shown in the for loop. 
        // x, y, and r are the x coordinate, y coordinate, and the diameter of the circles. 
        int radiusStepSize = r / numCircles;
        int centerStepSize = radiusStepSize / 2;
        int thisX = x;
        int thisY = y;
        int thisR = r;
        // this is the foreloop that creates the circles within circles. I set it up
        // with the variables so that the center will always remain the same. It will
        // first draw the circles, then outline all of them black.
        for(int thisStep=0; thisStep<numCircles; thisStep++){
            g.setColor(Color.yellow);
            g.fillOval(thisX, thisY, thisR, thisR);
            g.setColor(Color.black);
            g.drawOval(thisX, thisY, thisR, thisR);
            thisX = thisX + centerStepSize;
            thisY = thisY + centerStepSize;
            thisR = thisR - radiusStepSize;
        }
        // This is the inscribed diamond, which is given by the drawDiamond method.
        // The inputs are the x-coordinate, y-coordinate, and the diameter that the 
        // Diamond needs to have in order to be inscribed.
        g.setColor(Color.black);
        drawDiamond(x, y, r, g);
    }
    // This method draws all of the subfigure circles, which are the circles that
    // are inside of a Gray Square. The method is able to figure out how many 
    // subfigures should be inside of the box with the numbers above, then where
    // to place them (evenly along the x and y axis). 
    public static void drawCirclesInBox(int x, int y, int sizeOfCircle, int subCircles, int rowsCols, Graphics g){
        // This will draw the gray box, which is given with an x and y coordinate, and then
        // the sizes, which are given in the main method. 
        int sideSize = sizeOfCircle * rowsCols;
        drawGrayBox(x, y, sideSize, sideSize, g);
        // this nested loop will produce the number of squares according to the 
        // parameters listed in the main method. It will start at the coordinates,
        //(x,y), then move to the next subfigure by the incraments that fits another
        // whole Circle without overlapping or gapping. The circles will stop being 
        //produced when it fills the square, otherwise being equal to or greater than
        //the size of the circles times the rows and columns. 
        for(int ix = x; ix<x+(sizeOfCircle*rowsCols); ix+=sizeOfCircle){
            for(int iy = y; iy<y+(sizeOfCircle * rowsCols); iy+=sizeOfCircle){
                drawDiamondInCircles(ix,iy,sizeOfCircle,subCircles,g);
            }
        }  
    }
    // this method draws all of the large gray squares. In this method, the input
    // to get the, "rectangle" or square,  is a starting x and y, then inputing a width and height.
    public static void drawGrayBox(int x, int y, int w, int h,  Graphics g){
        //sets the color to light_gray, and then fills the square rectangle.
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, w, h);
        //sets the color to red, and then outlines the square or rectangle.
        g.setColor(Color.red);
        g.drawRect(x, y, w, h);
    }
    // this method draws out the diamond, or the tilted square. Each endpoint of this
    // diamond is at the midpoint of a regular square. This is how a square can be 
    // tilted and remain the same shape. I use the variable r to define the distance of an 
    // original square. The original square starts at (x,y), meaning that 
    // r is the distance from one point to another.
    public static void drawDiamond(int x, int y, int r, Graphics g){
        g.setColor(Color.BLACK);
        // these are the the coordinates of drawing the lines. The textbook states that in
        //order to draw a line, you must state where the line is being drawn from
        // x1,y1 to x2,y2. With the above statements in relation to r, if there is a point
        // that is the midpoint of an original square, then the int r/2 will split
        // the distance.
        g.drawLine(x+(r/2), y, x+r, y+(r/2));
        g.drawLine(x+r, y+(r/2), x+(r/2), y+r);
        g.drawLine(x+(r/2), y+r, x, y+(r/2));
        g.drawLine(x, y+(r/2), x+(r/2), y);
    }
}