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
    Cloud.java implements DrawingObject.java interface. Cloud.java is 
    composed of Top.java, Side.java, and Rectangle.java to draw a Cloud.
*/

import java.awt.*;
import java.awt.geom.*;

public class Cloud implements DrawingObject{
    private double x, y, width, length, slant;
    private Color color = Color.WHITE;
    private Top t;
    private Side s;
    private Rectangle r;
    private double rotation = 0;

    public Cloud(double x, double y, double width, double length, double slant){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.slant = slant;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            //Create Objects
                t = new Top(x+slant, y+length, width, slant, -slant, color.darker());
                s = new Side(x, y+slant, slant, length, -slant, color);
                r = new Rectangle(x+slant, y, width, length, color);

            //Draw Objects
                t.draw(g2d);
                s.draw(g2d);
                r.draw(g2d);


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
