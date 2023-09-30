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
    SkyAnimation.java instantiates a Timer and extends TimerTask to
    animate DrawingObjects in SceneCanvas. Animate adjusts the Sky's
    color depending on the position of the Sun. The Sun and Move are
    constantly moving downwards and, at a certain y-value, are reseted
    to above the bounds of SceneCanvas. The Sun alsoturns orange as
    it sets. The Clouds are constantly moving right and, at a certain
    x-value, are reseted left of the bounds of SceneCanvas.
*/

import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

public class SkyAnimation {
    Toolkit toolkit;
    Timer timer;
    SceneCanvas sc;

    public SkyAnimation(SceneCanvas sc) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new Animate(), 0, 100);
        this.sc = sc;
    }

    class Animate extends TimerTask {
        double u = 128;
        //Sky Animation
        public void run() {
            Color color0 = sc.getDO(0).getColor();
            Color color2 = sc.getDO(2).getColor();
            if (true) {                
                //Sky
                    if (sc.getDO(2).getY()>u){
                        color0 = new Color(136-(int)(111*(sc.getDO(2).getY()-u)/u), 173-(int)(141*(sc.getDO(2).getY()-u)/u), 254-(int)(208*(sc.getDO(2).getY()-u)/u));
                    }else if(sc.getDO(1).getY()>u) {
                        color0 = new Color(25+(int)(111*(sc.getDO(1).getY()-u)/u), 32+(int)(141*(sc.getDO(1).getY()-u)/u), 46+(int)(208*(sc.getDO(1).getY()-u)/u));
                    }else if (sc.getDO(1).getY()<sc.getDO(2).getY()){
                        color0 = new Color(136,173,254);
                    }else{
                        color0 = new Color(25, 32, 46);
                    }
                    sc.getDO(0).adjustColor(color0);

                //Moon
                    //Move Moon
                        sc.getDO(1).adjustY(1);

                    //Reset Moon
                        if (sc.getDO(1).getY()==2*u){
                            sc.getDO(1).adjustY(-6*u);
                        }

                // Sun
                    //Color Sun
                        if(sc.getDO(2).getY()<0.5*u){
                            color2 = Color.YELLOW;
                        }else{
                            color2 = new Color(255, sc.getDO(2).getColor().getGreen()-1, 0); 
                        }
                        sc.getDO(2).adjustColor(color2);

                    //Move Sun
                        sc.getDO(2).adjustY(1);

                    //Reset Sun
                        if (sc.getDO(2).getY()==2*u){
                            sc.getDO(2).adjustY(-6*u);
                        }


                //Clouds
                    for(int j=5; j<=13; j++){
                        //Move Clouds
                            sc.getDO(j).adjustX(1);

                        //Reset Clouds
                            if (sc.getDO(j).getX()>8*u){
                                sc.getDO(j).adjustX(-13*u);
                            }
                    }

                sc.repaint();
            }
        }
    }
}
