import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
public class Game extends JPanel implements ActionListener{
    Timer timer;
    Agent[] agents;
    public Game(){
        setVisible(true);
        setBounds(0, 0, 600, 600);
        timer = new Timer(10, this);
        timer.start();
        agents = new Agent[3];
        for (int i = 0; i < agents.length; i++) {
            agents[i] = new Agent(i*30+100, 200);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        for (Agent agent : agents) {
            agent.draw(g2d);
        }
    }
}
