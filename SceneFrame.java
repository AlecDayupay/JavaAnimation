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
    SceneFrame.java sets up GUI and JButtons, and instantiates 
    SceneCanvas.java, SkyAnimation.java, BlockAnimation.java, 
    and ExplosionAnimation.java.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame{
    private JFrame f;
    private JPanel p;
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private int width, height;
    public SceneCanvas sc;


    public SceneFrame() {
        f = new JFrame();
        p = new JPanel(new GridLayout(7,1));
        b1 = new JButton("Diamond");
        b2 = new JButton("TNT");
        b3 = new JButton("Grass");
        b4 = new JButton("Beacon");
        b5 = new JButton("Random");
        b6 = new JButton("Clear");
        b7 = new JButton("Explosion");
        width = 1024;
        height = 768;
        sc = new SceneCanvas();
        SkyAnimation sa = new SkyAnimation(sc);
    }

    //Set Up GUI
        public void setUpGUI(){
            f.setTitle("Midterm Project - Dayupay, Alec Isaiah - 211831");
            f.getContentPane().add(sc, BorderLayout.CENTER);
            sc.setPreferredSize(new Dimension(width,height));
            f.getContentPane().add(p, BorderLayout.EAST);            
            p.add(b1);
            p.add(b2);
            p.add(b3);
            p.add(b4);
            p.add(b5);
            p.add(b6);
            p.add(b7);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }

    //Set Up Buttons
        public void setUpButtonListener() {
            ButtonListener bl = new ButtonListener();
            ExplosionListener xl = new ExplosionListener();
            b1.addActionListener(bl);//Diamond
            b2.addActionListener(bl);//TNT
            b3.addActionListener(bl);//Grass
            b4.addActionListener(bl);//Beacon
            b5.addActionListener(bl);//Random
            b6.addActionListener(bl);//Clear
            b7.addActionListener(xl);//Explosion
        }

    //Block Buttons
        private class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ae){
                Object b = ae.getSource();
                BlockAnimation ba;
                if (b == b1){
                    ba = new BlockAnimation(sc, 1);//Diamond
                } else if(b == b2){ 
                    ba = new BlockAnimation(sc, 2);//TNT
                } else if(b == b3){
                    ba = new BlockAnimation(sc, 3);//Grass
                } else if(b == b4){
                    ba = new BlockAnimation(sc, 4);//Beacon
                } else if(b == b5){
                    ba = new BlockAnimation(sc, 5);//Random
                } else if(b == b6){
                    ba = new BlockAnimation(sc, 6);//Clear
                }
            }
        }

    //Explosion Button
        private class ExplosionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ae){
                ExplosionAnimation xa = new ExplosionAnimation(sc);
            }
        }

    //Get SceneCanvas instance
        public SceneCanvas getSC(){
            return sc;
        }

}