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
    DrawingObject.java is an interface that implements functions that
    draw objects, mutate fields, and access fields.
*/

import java.awt.*;

public interface DrawingObject {
    //Draw Object
        public void draw(Graphics2D g2d);

    //Mutate Fields
        public void adjustX(double distance);
        public void adjustY(double distance);
        public void adjustColor(Color color);
        public void adjustSize(double distance);
        public void rotate(double distance);

    //Access Fields
        public double getX();
        public double getY();
        public Color getColor();
        public double getSize();
        public double getRotation();
}
