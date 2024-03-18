//Dongnan Liu, liu02385@umn.edu
//Triangle class create a rectangle which has its position, width, height and color.
import java.awt.Color;
//TODO:
// Rectangle refers to the instance variable.
public class Rectangle {
    private double x; //it is the x position of top left corner
    private double y; //it is the y position of top left corner
    private double width; //the width of the rectangle
    private double height; // the width of the rectangle
    private Color color;//the color of the rectangle
    //TODO:
    // Rectangle refers to the instance variable.
    public Rectangle(double x,double y,double width,double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    //TODO:
    // calculatePerimeter calculate the perimeter of the rectangle.
    public double calculatePerimeter(){
        return 2*width+2*height;
    }
    //TODO:
    // calculateArea calculate the area of the rectangle.
    public double calculateArea(){
        return width*height;
    }
    //TODO:
    // setColor sets color of the rectangle to the specified color.
    public void setColor(Color newcolor){
        color = newcolor;
    }
    //TODO:
    // setPos sets the position of the top-left corner of the rectangle to the specified coordinates.
    public void setPos(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }
    //TODO:
    // setHeight sets the height of the rectangle to the specified value.
    public void setHeight(double newHeight){
        this.height = newHeight;
    }
    //TODO:
    // setWidth sets the width of the rectangle to the specified value.
    public void setWidth(double newWidth){
        this.width = newWidth;
    }
    //TODO:
    // getColor returns the color of the rectangle.
    public Color getColor(){
        return color;
    }
    //TODO:
    // getXPos gets the x-coordinate of the top-left corner of the rectangle.
    public double getXPos(){
        return this.x;
    }
    //TODO:
    // getYPos gets the y-coordinate of the top-left corner of the rectangle.
    public double getYPos(){
        return this.y;
    }
    //TODO:
    // getHeight returns the height of the rectangle.
    public double getHeight(){
        return this.height;
    }
    //TODO:
    // getWidth returns the width of the rectangle.
    public double getWidth(){
        return this.width;
    }
}

