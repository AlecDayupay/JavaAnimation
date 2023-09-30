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
    Diamond.java implements DrawingObject.java interface. Diamond.java is 
    composed of Block.java, Top.java, Side.java, and Square.java to draw
    a Diamond block.
*/

import java.awt.*;
import java.awt.geom.*;

public class Diamond implements DrawingObject{
    private double x, y, length, slant;
    private Color color1 = new Color(73,232,225);
    private Color color2 = new Color(139,246,228);
    private Block b;
    private Top t;
    private Side s;
    private Square r;
    private double rotation = 0;


    public Diamond(double x, double y, double length){
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
                b = new Block(x, y, length, length, slant, color1.darker().darker(), color1.darker(), color1);
                t = new Top(x+((length+slant)/16), y+(slant/16), 7*length/8, 7*slant/8, 7*slant/8, color2);
                s = new Side(x+(slant/16), y+(length/16), 7*slant/8, 7*length/8, 7*slant/8, color2.darker());
                r = new Square(x+slant+(length/16), y+slant+(length/16), 7*length/8, color2.darker().darker());

            //Draw Objects
                b.draw(g2d);
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
