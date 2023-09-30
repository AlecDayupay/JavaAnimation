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
    Block.java implements DrawingObject.java interface. Block.java is 
    composed of Top.java, Side.java, and Rectangle.java to draw a Block.
*/

import java.awt.*;
import java.awt.geom.*;

public class Block implements DrawingObject{
    private double x, y, width, length, slant;
    private Color color1, color2, color3;
    private Top t;
    private Side s;
    private Rectangle r;
    private double rotation = 0;

    public Block(double x, double y, double width, double length, double slant, Color color1, Color color2, Color color3){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.slant = slant;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            //Create Objects
                t = new Top(x, y, width, slant, slant, color3);
                s = new Side(x, y, slant, length, slant, color2);
                r = new Rectangle(x+slant, y+slant, width, length, color1);

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
        this.color1 = color;
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
        return color1;
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
