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
    ExplosionAnimation.java instantiates a Timer and extends TimerTask 
    to animate DrawingObjects in SceneCanvas. Animate, if the current
    Block is a placed TNT, flashes the TNT white, bounces the TNT in a
    random direction, and then clears the TNT. Afterwards, three waves
    of Blast Particles disperse outwards, randomly changing size and
    color. Steve turns red and then transparent (simulating the death
    from the explosion). reset() makes the current Block switch away
    from TNT, the color of Steve is restored (simulating the respawn),
    and all Blast Particles return to their original size and position
    and turn transparent.
*/

import java.awt.*;
import java.util.*;

public class ExplosionAnimation {
    Toolkit toolkit;
    Timer timer;
    SceneCanvas sc;

    public ExplosionAnimation(SceneCanvas sc) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new Animate(), 0, 60);
        this.sc = sc;
    }

    class Animate extends TimerTask {
        //Fields
            int i = 0;
            Random random = new Random();
            int randN = random.nextInt(6)-3;
            int circle = 24;
            Color color1 = new Color(229,66,26);
            Color color2 = new Color(255, 255, 255);
            Color color3 = new Color(255, 255, 255, 0);
            Color color4 = new Color(174, 0, 0);
            Color color4a = new Color(152, 0, 0);
            Color color5 = new Color(147,94,63);

        //Reset
        public void reset(){
            //Reset Blast Particles
                double objectX, objectY, centerX, centerY, size, centerDist, oldRotation, newRotation, xChange, yChange, sizeChange;
                objectX = 704;
                objectY = 576;
                size = 180;
                centerX = objectX + (size/2);
                centerY = objectY + (size/2);
                centerDist = Math.sqrt((int)(Math.pow(centerX, 2))+(int)(Math.pow(centerY, 2)));
                oldRotation = Math.toDegrees(Math.acos(centerX/centerDist));
                for(int x=0; x<3*circle; x++){
                    newRotation = 15*x;
                    xChange = (objectX+centerDist*Math.cos(Math.toRadians(oldRotation-newRotation))-centerX)-(sc.getXO(x).getX());
                    yChange = (objectY+centerDist*Math.sin(Math.toRadians(oldRotation-newRotation))-centerY)-(sc.getXO(x).getY());
                    sizeChange = (size)-(sc.getXO(x).getSize());
                    sc.getXO(x).adjustX(xChange);
                    sc.getXO(x).adjustY(yChange);
                    sc.getXO(x).adjustSize(sizeChange);
                    sc.getXO(x).adjustColor(new Color(255, 255, 255, 0));
                }
            
            //Respawn Steve
                for(int steve=17;steve<=20;steve++){
                    sc.getDO(steve).adjustColor(color5);
                }

            //Reset and Clear TNT
                sc.block(4);
                sc.getBO(1).adjustColor(color1);
        }


        //Explosion Animation
        public void run() {
            if(sc.getBlock()==sc.getBO(1)&&sc.getBlock().getSize()==185.0){//Test if (Block is TNT) && (Size is at Maximum)
                
                if(i<=70){
                    //Prime TNT                    
                        //Move TNT
                        if(i<=8){
                            sc.getBlock().adjustY(3*(i-4));
                            sc.getBlock().adjustX(randN*(Math.abs(i-4)));
                        }
                        
                        //Color TNT
                        if(i<5||(i<15&&i>10)){
                            //White
                            sc.getBlock().adjustColor(color2);
                        }else if(i>30){ 
                            //Transparent
                            sc.getBlock().adjustColor(color3);
                        }else{
                            //Normal
                            sc.getBlock().adjustColor(color1);
                        }
                    

                    //Explode TNT
                    if(i>30){
                        //Random Blast Particles
                        int randJ = random.nextInt(195)+60; 
                        int randK = random.nextInt(195)+60;
                        int randL = random.nextInt(195)+60;
                        for(int j=0; j<circle; j++){
                            sc.getXO(j).adjustY(-15);
                            sc.getXO(j).adjustX(-5);
                            sc.getXO(j).adjustColor(new Color(randJ, randJ, randJ, (140-i)));
                            sc.getXO(j).adjustSize(random.nextInt(50)-35);
                        }
                        if(i>33){
                            for(int k=circle; k<2*circle; k++){
                                sc.getXO(k).adjustY(-15);
                                sc.getXO(k).adjustX(-5);
                                sc.getXO(k).adjustColor(new Color(randK, randK, randK, (140-i)));
                                sc.getXO(k).adjustSize(random.nextInt(50)-35);                        
                            }
                        }
                        if(i>37){
                            for(int l=2*circle; l<3*circle; l++){
                                sc.getXO(l).adjustY(-15);
                                sc.getXO(l).adjustX(-5);
                                sc.getXO(l).adjustColor(new Color(randL, randL, randL, (140-i)));
                                sc.getXO(l).adjustSize(random.nextInt(50)-35);
                            }
                        }

                        //Kill Steve
                        if(i>40){
                            //Transparent
                            for(int steve=17;steve<20;steve++){
                                sc.getDO(steve).adjustColor(color3);
                            }
                            sc.getDO(20).adjustColor(color3);
                        }else{
                            //Red
                            for(int steve=17;steve<=20;steve++){
                                sc.getDO(steve).adjustColor(color4a);
                            }
                            sc.getDO(20).adjustColor(color4);
                        }
                    }

                    sc.repaint();
                    i++;
                }else{
                    reset();
                    timer.cancel();
                }
            }else{
                timer.cancel();
            }
        }              
    }
}
