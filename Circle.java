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
    Circle.java implements DrawingObject.java interface. Circle.java 
    uses an instance of Ellipse2D.Double() to draw a Circle.
*/

import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject{
    private double x, y, size;
    private Color color;
    private double rotation = 0;

    public Circle(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            Ellipse2D.Double c = new Ellipse2D.Double(x, y, size, size);
            g2d.setPaint(color);
            g2d.fill(c);


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
        size += distance;
    }

    @Override
    public void rotate(double distance){
        rotation += distance;
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
    public double getSize(){
        return size;
    }

    @Override
    public double getRotation(){
        return rotation;
    }
}
