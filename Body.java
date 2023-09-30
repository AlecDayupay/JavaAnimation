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
    Body.java implements DrawingObject.java interface. Body.java is 
    composed of Block.java, Side.java, and an array of Rectangle.java
    to draw Steve's Body and Legs.
*/

import java.awt.*;
import java.awt.geom.*;

public class Body implements DrawingObject{
    private double x, y, width, slant;
    private double length = 384;
    private Color color1 = new Color(147,94,63);
    private Color color2, color3, color3a, color4, color4a;
    private Block b;
    private Side s;
    private Rectangle f0, f1, f2, f3;
    private Rectangle[] frontBody = {f0, f1, f2, f3};
    private double rotation = 0;


    public Body(double x, double y){
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
                    color2  = new Color(255,255,255,0);
                    color3  = new Color(255,255,255,0);
                    color3a = new Color(255,255,255,0);
                    color4  = new Color(255,255,255,0);
                    color4a = new Color(255,255,255,0);
                //Red
                }else if(color1.getRed()==152){
                    color1  = new Color(152,0,0);
                    color2  = new Color(5,0,0);
                    color3  = new Color(77,0,0);
                    color3a = new Color(53,0,0);
                    color4  = new Color(110,0,0);
                    color4a = new Color(67,0,0);
                //Normal
                }else{
                    color1  = new Color(147,94,63);
                    color2  = new Color(0,177,179);
                    color3  = new Color(72,59,159);
                    color3a = new Color(48,41,109);
                    color4  = new Color(105,106,110);
                    color4a = new Color(62,63,58);
                }

            //Create Objects
                width = length/3; slant = length/12;
                b = new Block(x, y, width, length, slant, color3, color3a, color1);
                s = new Side(x, y+(22*length/24), slant, 2*length/24, slant, color4a);
                frontBody[0] = new Rectangle(x+slant+(0*width/8), y+slant+(0*length/24),  8*width/8, 10*length/24, color2);
                frontBody[1] = new Rectangle(x+slant+(2*width/8), y+slant+(0*length/24),  4*width/8, 1*length/24,  color1);
                frontBody[2] = new Rectangle(x+slant+(3*width/8), y+slant+(1*length/24),  2*width/8, 1*length/24,  color1);
                frontBody[3] = new Rectangle(x+slant+(0*width/8), y+slant+(22*length/24), 8*width/8, 2*length/24,  color4);

            //Draw Objects
                b.draw(g2d);
                s.draw(g2d);
                for(Rectangle front: frontBody){
                    front.draw(g2d);}


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
