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
    Head.java implements DrawingObject.java interface. Head.java is 
    composed of Block.java, an array of Side.java, and an array of 
    Rectangle.java to draw Steve's Head.
*/

import java.awt.*;
import java.awt.geom.*;

public class Head implements DrawingObject{
    private double x, y, slant;
    private double length = 128;
    private Color color1 = new Color(169,124,101);
    private Color color1a, color2, color2a, color2b, color3, color4, color5, color5a;
    private Block b;
    private Side s0, s1, s2, s3;
    private Side[] sideHead = {s0, s1, s2, s3};
    private Rectangle f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11;
    private Rectangle[] frontHead = {f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11};
    private double rotation = 0;


    public Head(double x, double y){
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
                    color3  = new Color(255,255,255,0);
                    color4  = new Color(255,255,255,0);
                    color5  = new Color(255,255,255,0);
                    color5a = new Color(255,255,255,0);
                //Red
                }else if(color1.getRed()==174){
                    color1  = new Color(174,0,0);
                    color1a = new Color(152,0,0);
                    color2  = new Color(50,0,0);
                    color2a = new Color(66,0,0);
                    color2b = new Color(45,0,0);
                    color3  = new Color(255,0,0);
                    color4  = new Color(102,0,0);
                    color5  = new Color(117,0,0);
                    color5a = new Color(138,0,0);
                //Normal
                }else{
                    color1  = new Color(169,124,101);
                    color1a = new Color(147,94,63);
                    color2  = new Color(45,32,16);
                    color2a = new Color(61,41,20);
                    color2b = new Color(40,29,11);
                    color3  = new Color(250,254,255);
                    color4  = new Color(97,66,140);
                    color5  = new Color(112,65,49);
                    color5a = new Color(133,73,57);
                }
            
            //Create Objects
                slant=0.3*length;
                b = new Block(x, y, length, length, slant, color1, color1a, color2);
                sideHead[0] = new Side(x+(0*slant/8),   y+(0*slant/8), 3*slant/8,   7*length/8, 3*slant/8, color2b);
                sideHead[1] = new Side(x+(2.9*slant/8), y+(3*slant/8), 2.2*slant/8, 6*length/8, 2*slant/8, color2b);
                sideHead[2] = new Side(x+(5*slant/8),   y+(5*slant/8), 2*slant/8,   4*length/8, 2*slant/8, color2b);
                sideHead[3] = new Side(x+(7*slant/8),   y+(7*slant/8), 1*slant/8,   5*length/8, 1*slant/8, color2b);
                frontHead[0] = new Rectangle(x+slant+(0*length/8),   y+slant+(0*length/8), 1*length/8,   3*length/8, color2a);
                frontHead[1] = new Rectangle(x+slant+(0.9*length/8), y+slant+(0*length/8), 6.2*length/8, 2*length/8, color2a);
                frontHead[2] = new Rectangle(x+slant+(7*length/8),   y+slant+(0*length/8), 1*length/8,   3*length/8, color2a);
                frontHead[3] = new Rectangle(x+slant+(1*length/8),   y+slant+(4*length/8), 1*length/8,   1*length/8, color3);
                frontHead[4] = new Rectangle(x+slant+(2*length/8),   y+slant+(4*length/8), 1*length/8,   1*length/8, color4);
                frontHead[5] = new Rectangle(x+slant+(5*length/8),   y+slant+(4*length/8), 1*length/8,   1*length/8, color3);
                frontHead[6] = new Rectangle(x+slant+(6*length/8),   y+slant+(4*length/8), 1*length/8,   1*length/8, color4);
                frontHead[7] = new Rectangle(x+slant+(3*length/8),   y+slant+(5*length/8), 2*length/8,   1*length/8, color5);
                frontHead[8] = new Rectangle(x+slant+(3*length/8),   y+slant+(6*length/8), 2*length/8,   1*length/8, color5a);
                frontHead[9] = new Rectangle(x+slant+(2*length/8),   y+slant+(6*length/8), 1*length/8,   1*length/8, color2a);
                frontHead[10] = new Rectangle(x+slant+(5*length/8),  y+slant+(6*length/8), 1*length/8,   1*length/8, color2a);
                frontHead[11] = new Rectangle(x+slant+(2*length/8),  y+slant+(7*length/8), 4*length/8,   1*length/8, color2a);

            //Draw Objects
                b.draw(g2d);
                for(Side side: sideHead){
                    side.draw(g2d);}
                for(Rectangle front: frontHead){
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
