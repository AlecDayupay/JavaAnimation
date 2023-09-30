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
    Beacon.java implements DrawingObject.java interface. Beacon.java is 
    composed of two Block.java and two arrays of Line.java to draw a
    Beacon block.
*/

import java.awt.*;
import java.awt.geom.*;

public class Beacon implements DrawingObject{
    private double x, y, length, slant;
    private Color color1 = new Color(56,39,82);
    private Color color2 = new Color(72,209,199);
    private Color color3 = new Color(203,230,225);
    private Block c1, c2;
    private Line b0, b1, b2, f0, f1, f2, f3, f4, f5, f6, f7, f8;
    private Line[] backLines = {b0, b1, b2};
    private Line[] frontLines = {f0, f1, f2, f3, f4, f5, f6, f7, f8};
    private double rotation = 0;


    public Beacon(double x, double y, double length){
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
                c1 = new Block(x+(2*(length+slant)/16), y+(2*slant/16)+(13*length/16), 12*length/16, 3*length/16, 12*slant/16, color1.darker().darker(), color1.darker(), color1);
                c2 = new Block(x+(3*(length+slant)/16), y+(3*slant/16)+(3*length/16), 10*length/16, 10*length/16, 10*slant/16, color2.darker().darker(), color2.darker(), color2);
                backLines[0] = new Line(x+length, y+length, x+length, y, 5, color3);
                backLines[1] = new Line(x+length, y+length, x, y+length, 5, color3);
                backLines[2] = new Line(x+length, y+length, x+slant+length, y+slant+length, 5, color3);
                frontLines[0] = new Line(x, y, x+length, y, 5, color3);
                frontLines[1] = new Line(x, y, x, y+length, 5, color3);        
                frontLines[4] = new Line(x, y, x+slant, y+slant, 5, color3);
                frontLines[2] = new Line(x+slant, y+slant, x+slant+length, y+slant, 5, color3);
                frontLines[3] = new Line(x+slant, y+slant, x+slant, y+slant+length, 5, color3);
                frontLines[5] = new Line(x+length, y, x+length+slant, y+slant, 5, color3);
                frontLines[6] = new Line(x, y+length, x+slant, y+length+slant, 5, color3);
                frontLines[7] = new Line(x+slant, y+slant+length, x+slant+length, y+slant+length, 5, color3);
                frontLines[8] = new Line(x+slant+length, y+slant, x+slant+length, y+slant+length, 5, color3);

            //Draw Objects
                for(Line line : backLines){
                    line.draw(g2d);}
                c1.draw(g2d);
                c2.draw(g2d);
                for(Line line : frontLines){
                    line.draw(g2d);}
            
        
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
