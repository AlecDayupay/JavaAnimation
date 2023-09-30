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
    Arm.java implements DrawingObject.java interface. Arm.java is 
    composed of Block.java, Side.java, and Rectangle.java to draw 
    Steve's Arm.
*/

import java.awt.*;
import java.awt.geom.*;

public class Arm implements DrawingObject{
    private double x, y, width, slant;
    private double length = 192;
    private Color color1 = new Color(169,124,101);
    private Color color1a = new Color(147,94,63);
    private Color color2 = new Color(0,204,199);
    private Color color2a = new Color(0,177,179);
    private Color color2b = new Color(0,126,113);
    private Block b;
    private Side s;
    private Rectangle f;
    private double rotation = 0;


    public Arm(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2d){
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation));


            //Color Objects
                //Transparent
                if (color1.getAlpha()==0){
                    color1  = new Color(255,255,255,0);
                    color1a = new Color(255,255,255,0);
                    color2  = new Color(255,255,255,0);
                    color2a = new Color(255,255,255,0);
                    color2b = new Color(255,255,255,0);
                //Red
                }else if(color1.getRed()==152){
                    color1  = new Color(152,0,0);
                    color1a = new Color(174,0,0);
                    color2  = new Color(5,0,0);
                    color2a = new Color(5,0,0);
                    color2b = new Color(5,0,0);
                //Normal
                }else{
                    color1  = new Color(147,94,63);
                    color1a = new Color(169,124,101);
                    color2  = new Color(0,204,199);
                    color2a = new Color(0,177,179);
                    color2b = new Color(0,126,113);
                }

            //Create Objects
                width = length/3; slant = length/6;
                b = new Block(x, y, width, length, slant, color1a, color1, color2);
                s = new Side(x, y, slant, length/3, slant, color2b);
                f = new Rectangle(x+slant, y+slant, width, length/3, color2a);

            //Draw Objects
                b.draw(g2d);
                s.draw(g2d);
                f.draw(g2d);


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
