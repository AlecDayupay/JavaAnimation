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
    Top.java implements DrawingObject.java interface. Top.java uses an
    instance of Path2D.Double() to draw a 4-sided shape that off-sets
    the bottom side by slant.
*/

import java.awt.*;
import java.awt.geom.*;

public class Top implements DrawingObject{
    private double x, y, width, length, slant;
    private Color color;
    private double rotation = 0;

    public Top(double x, double y, double width, double length, double slant, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.slant = slant;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            Path2D.Double p = new Path2D.Double();
            p.moveTo(x,y);
            p.lineTo(x+width, y);
            p.lineTo(x+width+slant, y+length);
            p.lineTo(x+slant, y+length);
            g2d.setPaint(color);
            g2d.fill(p);

        
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
        slant += distance*slant/length;
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
        return length;
    }

    @Override
    public double getRotation(){
        return rotation;
    }
}
