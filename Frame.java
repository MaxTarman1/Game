import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame(int width, int hieght){
        setVisible(true);
        setSize(width, hieght);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Game());
    }
    
}
