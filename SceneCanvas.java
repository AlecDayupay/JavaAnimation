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
    SceneCanvas.java instantiates arrays of DrawingObjects (Background,
    Clouds, Tree, Steve, Blocks, and TNT Particles) and draws each
    instance. getDO(), getBO(), getBlock(), and getXO() accesses 
    DrawingObjects and block() mutates block.
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class SceneCanvas extends JComponent {
    private double u = 128;
    private Color skyColor = new Color(136,173,254);
    private Color oceanColor = new Color(32,46,169);
    private Color grassColor = new Color(75,98,45);
    private Color leavesColor = new Color(75,98,45);
    private Color woodColor = new Color(93,72,43);
    public ArrayList<DrawingObject> dO, bO, xO;
    public Random random = new Random();
    public DrawingObject block;
    Graphics2D g2d;

    public SceneCanvas(){

        //Drawing Objects
            dO = new ArrayList<DrawingObject>();

            //Background
                //Sky
                    dO.add(new Square(0, 0, 8*u, skyColor));
                //Moon
                    dO.add(new Square(0.5*u, -4*u, u, Color.WHITE.darker()));
                //Sun
                    dO.add(new Square(0.5*u, -u , u, Color.YELLOW));
                //Ocean
                    dO.add(new Square(0, 1.9*u, 8*u, oceanColor));
                //Land
                    dO.add(new Square(0, 3*u, 8*u, grassColor));

            //Clouds
                dO.add(new Cloud(1.4*u, 0.5*u, 1*u, 0.1*u, 0.1*u));
                dO.add(new Cloud(1*u, 0.2*u, 2*u, 0.1*u, 0.3*u));
                dO.add(new Cloud(1.6*u, 0.1*u, 1.3*u, 0.1*u, 0.1*u));
                
                dO.add(new Cloud(5.6*u, 0.7*u, 1*u, 0.1*u, 0.1*u));
                dO.add(new Cloud(5.4*u, 0.5*u, 1.5*u, 0.1*u, 0.2*u));
                dO.add(new Cloud(5.9*u, 0.4*u, 0.7*u, 0.1*u, 0.1*u));

                dO.add(new Cloud(-2.8*u, 0.6*u, 1*u, 0.1*u, 0.1*u));
                dO.add(new Cloud(-3.2*u, 0.3*u, 1.8*u, 0.1*u, 0.3*u));
                dO.add(new Cloud(-2.6*u, 0.2*u, 0.8*u, 0.1*u, 0.1*u));

            //Tree
                dO.add(new Block(6*u, 2*u, 0.5*u, 2*u, 0.25*u, woodColor, woodColor.darker(), woodColor.darker().darker()));
                dO.add(new Block(5*u, u, 2.5*u, u, 0.5*u, leavesColor.darker().darker(), leavesColor.darker(), leavesColor));
                dO.add(new Block(5.5*u, 0.5*u+1, 1.5*u, 0.5*u, 0.5*u, leavesColor.darker().darker(), leavesColor.darker(), leavesColor));
            
            //Steve
                dO.add(new Arm(3.5*u, 2.5*u));
                dO.add(new Body(2.5*u, 2.5*u));
                dO.add(new Arm(2*u, 2.5*u));
                dO.add(new Head(2.45*u, 1.5*u));
            
        //Blocks
                bO = new ArrayList<DrawingObject>();
                    bO.add(new Diamond(4.1*u, 3.9*u, 45));
                    bO.add(new TNT(4.1*u, 3.9*u, 45));
                    bO.add(new Grass(4.1*u, 3.9*u, 45));
                    bO.add(new Beacon(4.1*u, 3.9*u, 45));
                    bO.add(new Circle(-100, -100, 1, new Color(0, 0, 0 ,0)));
                    block = bO.get(4);

        //TNT Particles
            xO = new ArrayList<DrawingObject>();
                double objectX, objectY, centerX, centerY, size, centerDist, oldRotation, newRotation;
                objectX = 5.5*u;
                objectY = 4.5*u;
                size = 180;
                centerX = objectX + (size/2);
                centerY = objectY + (size/2);
                centerDist = Math.sqrt((int)(Math.pow(centerX, 2))+(int)(Math.pow(centerY, 2)));
                oldRotation = Math.toDegrees(Math.acos(centerX/centerDist));
                for(int x=0; x<3*24; x++){
                    newRotation = 15*x;
                    xO.add(new Circle(objectX+centerDist*Math.cos(Math.toRadians(oldRotation-newRotation))-centerX, objectY+centerDist*Math.sin(Math.toRadians(oldRotation-newRotation))-centerY, size, new Color(240, 240, 240, 0)));
                    xO.get(x).rotate(newRotation);
                }
    }



    @Override
    protected void paintComponent(Graphics g){
        g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        //Draw Objects
            for(DrawingObject d : dO){
                d.draw(g2d);
            }
        
        //Draw Particles
            for(DrawingObject x : xO){
                x.draw(g2d);
            }

        //Draw Block
            block.draw(g2d);
    } 










    
    //Get Drawing Object with Index
        public DrawingObject getDO(int num){
            return dO.get(num);
        }
    
    //Block Functions
        //Get Block with Index
            public DrawingObject getBO(int num){
                return bO.get(num);
            }

        //Get Current Block
            public DrawingObject getBlock(){
                return block;
            }
        
        //Get Random Block
            public void block(){
                Random random = new Random();
                DrawingObject test = block;
                while (test.equals(block)){
                    block = bO.get(random.nextInt(bO.size()-1));
                }
            }

        //Set Block
            public void block(int b){
                block = bO.get(b);
            }
    
    //Get TNT Particles with Index
        public DrawingObject getXO(int num){
            return xO.get(num);
        }
}
