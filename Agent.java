import Basic.Vector2D.Vector;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import java.awt.*;

public class Agent {
    private NeuralNetwork nn;
    private Vector pos, acc, vel;
    private double fitness;
    public Agent(double x, double y){
        pos = new Vector(x, y);
        acc = new Vector(0, 0);
        vel = new Vector(0, .5);
        nn = new NeuralNetwork(0, 0, 0, null);
    }
    public void draw(Graphics2D g){
        Image img = new ImageIcon("rocket.png").getImage();
        AffineTransform transform = new AffineTransform();
        transform.translate(pos.x, pos.y);
        transform.rotate(vel.x, vel.y);
        
        g.drawImage(img, transform, null);
    }
}
