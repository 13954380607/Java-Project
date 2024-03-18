//Dongnan Liu, liu02385@umn.edu
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.util.Scanner;
import java.awt.Color;
public class FractalDrawer {
    private double totalArea = 0;// member variable for tracking the total area

    public FractalDrawer() {
    }  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas drawing = new Canvas();
        // Draw a triangle fractal with specific parameters
        if (type.equals("Triangle")) {
            drawTriangleFractal(100, 100, 400, 400, Color.blue, drawing, 8);
        }
        // Draw a circle fractal with specific parameters
        else if (type.equals("Circle")){
            drawCircleFractal(100, 400, 400, Color.green, drawing, 8);
        }
        // Draw a rectangle fractal with specific parameters
        else if (type.equals("Rectangle")){
            drawRectangleFractal(100, 100, 400, 400, Color.blue, drawing, 8);
        }
        return totalArea;
    }

    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        // Create a new Triangle object with the specified parameters
        Triangle newTriangle = new Triangle(x, y, width, height);
        // Calculate and add the area of the current triangle to the totalArea
        totalArea += newTriangle.calculateArea();
        // Set the color of the current triangle
        newTriangle.setColor(c);
        // Check if the recursion level reaches 0, if so, stop recursion
        if (level == 0) {
            return;
        } else {
            can.drawShape(newTriangle);
            // Recursively draw three smaller triangles with different colors, positions and sizes
            drawTriangleFractal(width / 2, height / 2, x - .5 * width, y, Color.red, can, level - 1);
            drawTriangleFractal(width / 2, height / 2, x + width, y, Color.blue, can, level - 1);
            drawTriangleFractal(width / 2, height / 2, x + .25 * width, y - height, Color.green, can, level - 1);
        }
    }

    // TODO:
    //  drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        // Create a new Circle object with the specified parameters
        Circle newCircle = new Circle(x, y, radius);
        // Calculate and add the area of the current circle to the totalArea
        totalArea += newCircle.calculateArea();
        // Give a specified color to the newCircle
        newCircle.setColor(c);
        // Check if the recursion level reaches 0, if so, stop recursion
        if (level == 0) {
            return;
        } else {
            // Draw the newCircle on the canvas
            can.drawShape(newCircle);
            // Recursively draw four smaller circles with different colors, positions and sizes
            drawCircleFractal(radius / 2, x-radius, y-radius, Color.red, can, level - 1);
            drawCircleFractal(radius  / 2, x + radius, y-radius, Color.blue, can, level - 1);
            drawCircleFractal(radius / 2, x - radius, y+radius, Color.green, can, level - 1);
            drawCircleFractal(radius / 2, x+ radius, y + radius, Color.pink, can, level - 1);
        }
    }

    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        // Create a new Rectangle object with the specified parameters
        Rectangle newRectangle = new Rectangle(x, y, width, height);
        // give a specified color to the newRectangle
        newRectangle.setColor(c);
        // Calculate and add the area of the current rectangle to the totalArea
        totalArea += newRectangle.calculateArea();
        // Check if the recursion level reaches 0, if so, stop recursion
        if (level == 0) {
            return;
        } else {
            can.drawShape(newRectangle);
            // Recursively draw four smaller rectangles with different colors, positions and sizes
            drawRectangleFractal(width / 2, height / 2, x - 0.5*width, y -  0.5*height, Color.red, can, level - 1);
            drawRectangleFractal(width / 2, height / 2, x - 0.5 * width, y + height, Color.blue, can, level - 1);
            drawRectangleFractal(width / 2, height / 2, x + width, y-0.5*height, Color.green, can, level - 1);
            drawRectangleFractal(width / 2, height / 2, x + width, y + height, Color.pink, can, level - 1);
        }
    }



    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        // uses scanner to read the users input
        Scanner scanner = new Scanner(System.in);
        // print the line that lets the user enter a shape
        System.out.println("Enter a shape:");
        // read the user's input as a string
        String newShape = scanner.nextLine();
        // create an instance of the FractalDrawer
        FractalDrawer drawer = new FractalDrawer();
        // call the drawFractal to return the total area
        System.out.println("The total area is:" + drawer.drawFractal(newShape));
        // close the scanner
        scanner.close();

    }
}