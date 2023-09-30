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
    BlockAnimation.java instantiates a Timer and extends TimerTask to
    animate DrawingObjects in SceneCanvas. Animate moves Steve's Arm
    and the current Block, switches the Block depending on which 
    JButton was clicked, and resets the rotation, position, and size
    of Steve's Arm and the Block.
*/

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

public class BlockAnimation {
    Toolkit toolkit;
    Timer timer;
    SceneCanvas sc;
    int b;

    public BlockAnimation(SceneCanvas sc, int button) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new Animate(), 0, 60);
        this.sc = sc;
        this.b = button;
    }

    class Animate extends TimerTask {
        int i = -20;
        //Reset
        public void reset(){
            //Reset Block Position and Size
                sc.getBlock().adjustX(-(sc.getBlock().getX()-524.8));
                sc.getBlock().adjustY(-(sc.getBlock().getY()-499.2));
                sc.getBlock().adjustSize(-(sc.getBlock().getSize()-45));

            //Reset Arm Position and Rotation
                sc.getDO(17).adjustX(-(sc.getDO(17).getX()-356.8234294117647));
                sc.getDO(17).adjustY(-(sc.getDO(17).getY()-417.875));
                sc.getDO(17).rotate(-(sc.getDO(17).getRotation()+11));
        }

        //Block Animation
        public void run() {
            if(i<=20){
                //Switch Blocks
                if(i == 0){
                    if (b == 6){//Clear
                        sc.block(4);
                    }else if(b == 5){ //Random
                        sc.block(); 
                        reset();                       
                    }else if(b == 4){//Beacon
                        sc.block(3); 
                        reset();                       
                    }else if(b == 3){//Grass
                        sc.block(2);
                        reset();                        
                    }else if(b == 2){//TNT
                        sc.block(1); 
                        reset();                       
                    }else if(b == 1){//Diamond
                        sc.block(0);
                        reset();
                    }
                }

                //Move Block
                    sc.getBlock().adjustY(i/10);
                    sc.getBlock().adjustX(i/2);
                    sc.getBlock().adjustSize(i/1.5);

                //Move Arm
                if(i<-10 || i>10){
                    sc.getDO(17).rotate(i/10);
                    sc.getDO(17).adjustY(-i/1.6);
                    sc.getDO(17).adjustX(i/1.7);
                }
                
                sc.repaint();
                i++;
            }else{
                timer.cancel();
            }
        }              
    }
}
