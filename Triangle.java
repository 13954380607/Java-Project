//Dongnan Liu, liu02385@umn.edu
//Triangle class create a triangle which has its position, width, height and color.
import java.awt.Color;

public class Triangle{
    private double x; //it is the x position of bottom left corner
    private double y; //it is the y position of bottom left corner
    private double width; // the width of the triangle
    private double height; // the height of the triangle
    private Color color; // the color of the triangle
    //TODO:
    // Triangle refers to the instance variable.
    public Triangle(double x,double y,double width,double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    //TODO:
    // calculatePerimeter calculate the perimeter of the triangle.
    public double calculatePerimeter(){
        double number = (width/2)*(width/2)+height*height;
        double hypotenuse = Math.sqrt(number);
        return width + 2*hypotenuse;
    }
    //TODO:
    // calculateArea calculate the area of the triangle.

    public double calculateArea(){
        return width*height*0.5;
    }
    //TODO:
    // setColor sets color of the triangle to the specified color.
    public void setColor(Color newcolor){
        color = newcolor;
    }
    //TODO:
    // setPos sets the position of the left corner of the triangle to the specified coordinates.
    public void setPos(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }
    //TODO:
    // setHeight sets the height of the triangle to the specified value.
    public void setHeight(double newHeight){
        this.height = newHeight;
    }
    //TODO:
    // setWidth sets the width of the triangle to the specified value.
    public void setWidth(double newWidth){
        this.width = newWidth;
    }
    //TODO:
    // getColor returns the color of the triangle.
    public Color getColor(){
        return color;
    }
    //TODO:
    // getXPos gets the x-coordinate of the left corner of the triangle.
    public double getXPos(){
        return this.x;
    }
    //TODO:
    // getYPos gets the y-coordinate of the left corner of the triangle.
    public double getYPos(){
        return this.y;
    }
    //TODO:
    // getHeight returns the height of the triangle.
    public double getHeight(){
        return this.height;
    }
    //TODO:
    // getWidth returns the width of the triangle.
    public double getWidth(){
        return this.width;
    }
}
