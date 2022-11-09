import Basic.Vector2D.Vector;
import java.awt.geom.AffineTransform;
import java.awt.*;

public class Agent {
    private NeuralNetwork nn;
    private Vector pos, acc, vel;
    private double fitness;
    public Agent(double x, double y){
        pos = new Vector(x, y);
        acc = new Vector(0, 0);
        vel = new Vector(0, 0);
        nn = new NeuralNetwork(0, 0, 0, null);
    }
    public void draw(Graphics2D g){
        g.setStroke(null);

        g.drawOval((int)pos.x, (int)pos.y, 5, 5);
    }
}
