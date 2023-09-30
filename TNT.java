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
    TNT.java implements DrawingObject.java interface. TNT.java is 
    composed of Block.java, Top.java, an array of Side.java, an array
    of Rectangle.java, and an array of Line.java to draw a TNT block.
*/

import java.awt.*;
import java.awt.geom.*;

public class TNT implements DrawingObject{
    private double x, y, length, slant;
    private int i, j, k, l, m;
    private Color color1 = new Color(229,66,26);;
    private Color color1a, color1b, color2, color2a, color2b, color3, color3a, color4, color4a;
    private Block b;
    private Top t;
    private Side s, s0, s1, s2, s3, s4, s5, s6, s7;
    private Side[] sideTNT = {s0, s1, s2, s3, s4, s5, s6, s7};
    private Rectangle r, f0, f1, f2, f3, f4, f5, f6, f7;
    private Rectangle[] frontTNT = {f0, f1, f2, f3, f4, f5, f6, f7};
    private Line l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    private Line[] lines = {l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11};
    private double rotation = 0;


    public TNT(double x, double y, double length){
        this.x = x;
        this.y = y;
        this.length = length;
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
                    color1b = new Color(255,255,255,0);
                    color2  = new Color(255,255,255,0);
                    color2a = new Color(255,255,255,0);
                    color2b = new Color(255,255,255,0);
                    color3  = new Color(255,255,255,0);
                    color3a = new Color(255,255,255,0);
                    color4  = new Color(255,255,255,0);
                    color4a = new Color(255,255,255,0);
                //White
                }else if(color1.getRed()==255){
                    color1  = new Color(255,255,255);
                    color1a = new Color(255,255,255);
                    color1b = new Color(255,255,255);
                    color2  = new Color(255,255,255);
                    color2a = new Color(255,255,255);
                    color2b = new Color(255,255,255);
                    color3  = new Color(255,255,255);
                    color3a = new Color(255,255,255);
                    color4  = new Color(255,255,255);
                    color4a = new Color(255,255,255);
                //Normal
                }else{
                    color1  = new Color(229,66,26);
                    color1a = color1.darker();
                    color1b = color1.darker().darker();
                    color2  = new Color(144,42,14);
                    color2a = color2.darker();
                    color2b = color2.darker().darker();
                    color3  = new Color(181,177,178);
                    color3a = color3.darker();
                    color4  = new Color(46,44,72);
                    color4a = color4.darker();
                }

            //Create Objects            
                slant = length/3; i=0; j=1; k=1; l=1; m=1;
                b = new Block(x, y, length, length, slant, color1b, color1a, color1);
                t = new Top(x+((length+slant)/16), y+(slant/16), 7*length/8, 7*slant/8, 7*slant/8, color3a);
                s = new Side(x, y+(5*(length)/16), slant, 3*length/8, slant, color3);
                r = new Rectangle(x+slant, y+slant+(5*length/16), length, 3*length/8, color3a);
                sideTNT[0] = new Side(x+(2*slant/16), y+(6*length/16)+(2*slant/16),   3*slant/16, 1*length/16, 3*slant/16, color4);
                sideTNT[1] = new Side(x+(3*slant/16), y+(7*length/16)+(3*slant/16),   1*slant/16, 3*length/16, 1*slant/16, color4);
                sideTNT[2] = new Side(x+(6*slant/16), y+(6*length/16)+(6*slant/16),   1*slant/16, 4*length/16, 1*slant/16, color4);
                sideTNT[3] = new Side(x+(7*slant/16), y+(7*length/16)+(7*slant/16),   1*slant/16, 1*length/16, 1*slant/16, color4);
                sideTNT[4] = new Side(x+(8*slant/16), y+(8*length/16)+(8*slant/16),   1*slant/16, 1*length/16, 1*slant/16, color4);
                sideTNT[5] = new Side(x+(9*slant/16), y+(6*length/16)+(9*slant/16),   1*slant/16, 4*length/16, 1*slant/16, color4);
                sideTNT[6] = new Side(x+(11*slant/16), y+(6*length/16)+(11*slant/16), 3*slant/16, 1*length/16, 3*slant/16, color4);
                sideTNT[7] = new Side(x+(12*slant/16), y+(7*length/16)+(12*slant/16), 1*slant/16, 3*length/16, 1*slant/16, color4);
                frontTNT[0] = new Rectangle(x+slant+(2*length/16),  y+slant+(6*length/16), 3*length/16, 1*length/16, color4a);
                frontTNT[1] = new Rectangle(x+slant+(3*length/16),  y+slant+(7*length/16), 1*length/16, 3*length/16, color4a);
                frontTNT[2] = new Rectangle(x+slant+(6*length/16),  y+slant+(6*length/16), 1*length/16, 4*length/16, color4a);
                frontTNT[3] = new Rectangle(x+slant+(7*length/16),  y+slant+(7*length/16), 1*length/16, 1*length/16, color4a);
                frontTNT[4] = new Rectangle(x+slant+(8*length/16),  y+slant+(8*length/16), 1*length/16, 1*length/16, color4a);
                frontTNT[5] = new Rectangle(x+slant+(9*length/16),  y+slant+(6*length/16), 1*length/16, 4*length/16, color4a);
                frontTNT[6] = new Rectangle(x+slant+(11*length/16), y+slant+(6*length/16), 3*length/16, 1*length/16, color4a);
                frontTNT[7] = new Rectangle(x+slant+(12*length/16), y+slant+(7*length/16), 1*length/16, 3*length/16, color4a);
                while(i<12){
                    if(i<3){
                        lines[i] = new Line(x+(j*slant/4), y+(j*slant/4), x+(j*slant/4), y+(j*slant/4)+length, 5, color2a);
                        j++;
                    }else if(i<6){
                        lines[i] = new Line(x+slant+(k*length/4), y+slant, x+slant+(k*length/4), y+slant+length, 5, color2b);
                        k++;
                    }else if(i<9){
                        lines[i] = new Line(x+(l*slant/4), y+(l*slant/4), x+(l*slant/4)+length, y+(l*slant/4), 5, color2);
                        l++;
                    }else{
                        lines[i] = new Line(x+(m*length/4), y, x+slant+(m*length/4), y+slant, 5, color2);
                        m++;
                    }
                    i++;
                }

            //Draw Objects
                b.draw(g2d);
                t.draw(g2d);
                for(Line line: lines){
                    line.draw(g2d);}
                s.draw(g2d);
                for(Side side: sideTNT){
                    side.draw(g2d);}
                r.draw(g2d);
                for(Rectangle front: frontTNT){
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
