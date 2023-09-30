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
    Grass.java implements DrawingObject.java interface. Grass.java is 
    composed of Block.java, two Side.java, and two Rectangle.java to
    draw a Grass block.
*/

import java.awt.*;
import java.awt.geom.*;

public class Grass implements DrawingObject{
    private double x, y, length, slant;
    private Color color1 = new Color(81,106,50);
    private Color color2 = new Color(120,86,59);
    private Color color3 = new Color(71,49,33);
    private Block b;
    private Side s1, s2;
    private Rectangle r1, r2;
    private double rotation = 0;

    public Grass(double x, double y, double length){
        this.x = x;
        this.y = y;
        this.length = length;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            //Create Objects
                slant = length/3;
                b = new Block(x, y, length, length, slant, color2.darker(), color2, color1);
                s1 = new Side(x, y, slant, 3*length/16, slant, color1.darker());
                s2 = new Side(x, y+(3*(length)/16), slant, length/16, slant, color3);
                r1 = new Rectangle(x+slant, y+slant, length, 3*length/16, color1.darker().darker());
                r2 = new Rectangle(x+slant, y+slant+(3*length/16), length, length/16, color3.darker());

            //Draw Objects
                b.draw(g2d);
                s1.draw(g2d);
                s2.draw(g2d);
                r1.draw(g2d);
                r2.draw(g2d);


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
