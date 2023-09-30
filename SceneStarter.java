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
    SceneStarter.java instantiates and sets up SceneFrame which contains
    SceneCanvas.java and JButtons.
*/

public class SceneStarter {
    public static void main(String[] args){
        //Instatiate Scene Frame
            SceneFrame sf = new SceneFrame();
        
        //Set Up Scene Frame
            sf.setUpGUI();        
            sf.setUpButtonListener();
    }
}
