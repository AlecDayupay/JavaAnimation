/**
    Alec Isaiah Dayupay
    211831
    April 4, 2022
    
    I have not discssed the Java language code in my program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.
    
    I have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in my program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program
*/

/**
    Rectangle.java implements DrawingObject.java interface. Rectangle.java 
    uses an instance of Rectangle2D.Double() to draw a Rectangle.
*/

import java.awt.*;
import java.awt.geom.*;

public class Rectangle implements DrawingObject{
    private double x, y, width, length;
    private Color color;
    private double rotation = 0;

    public Rectangle(double x, double y, double width, double length, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));

        
            Rectangle2D.Double bg = new Rectangle2D.Double(x, y, width, length);
            g2d.setPaint(color);
            g2d.fill(bg);


        g2d.setTransform(old);
    }










 
//DrawingObject Interface
    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override
    public void adjustY(double distance){
        y += distance;
    }

    @Override
    public void adjustColor(Color color){
        this.color = color;
    }

    @Override
    public void adjustSize(double distance){
        length += distance;
        width += distance*width/length;
    }

    @Override
    public double getX(){
        return x;
    }

    @Override
    public double getY(){
        return y;
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public void rotate(double distance){
        rotation += distance;
    }

    @Override
    public double getSize(){
        return length;
    }

    @Override
    public double getRotation(){
        return rotation;
    }
}
