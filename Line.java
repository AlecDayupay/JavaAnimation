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
    Line.java implements DrawingObject.java interface. Line.java 
    uses an instance of Line2D.Double() to draw a Line.
*/

import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject{
    private double x1, y1, x2, y2, size;
    private Color color;
    private double rotation = 0;

    public Line(double x1, double y1, double x2, double y2, double size, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));
        

            Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
            g2d.setPaint(color);
            g2d.setStroke(new BasicStroke((float)size));
            g2d.draw(l);
        

        g2d.setTransform(old);
    }










 
//DrawingObject Interface
    @Override
    public void adjustX(double distance){
        x1 += distance;
        x2 += distance;
    }

    @Override
    public void adjustY(double distance){
        y1 += distance;
        y2 += distance;
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
        return x1;
    }

    @Override
    public double getY(){
        return y1;
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
