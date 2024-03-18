//Dongnan Liu, liu02385@umn.edu
import java.awt.Color;
//TODO:
// Rectangle refers to the instance variable.
public class Circle{
    private double x; // x position of center of the circle
    private double y; // y position of center of the circle
    private double radius; // the radius of the circle
    private Color color; // the color of the circle
    //TODO:
    // Circle refers to the instance variable
    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    //TODO:
    // calculatePerimeter calculate the perimeter of the circle.
    public double calculatePerimeter(){
        return 2*3.14*radius;
    }
    //TODO:
    // calculateArea calculate the area of the circle.
    public double calculateArea(){
        return 3.14*radius*radius;
    }
    //TODO:
    // setColor sets color of the rectangle to the specified color.
    public void setColor(Color newcolor){
        color = newcolor;
    }
    //TODO:
    // setPos sets the position of the center of circle.
    public void setPos(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }
    //TODO:
    // setRadius sets radius of the circle to a specific value.
    public void setRadius(double newRadius){
        this.radius = newRadius;
    }
    //TODO:
    // getColor returns the color of the circle.
    public Color getColor(){
        return color;
    }
    //TODO:
    // getXPos gets the x-coordinate of the center of the circle.
    public double getXPos(){
        return this.x;
    }
    //TODO:
    // getYPos gets the y-coordinate of the center of the circle.
    public double getYPos(){
        return this.y;
    }
    //TODO:
    // getRadius gets the radius of the circle.
    public double getRadius(){
        return this.radius;
    }
}