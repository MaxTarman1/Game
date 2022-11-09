package Basic.Vector2D;

public class Vector {
    public double x,y;
    public Vector (double x, double y){
        this.x = x;
        this.y = y;
    }
    public void constrain(double min,double max){
        double value = mag();
        if(value > max) setMag(max);
        if(value < min) setMag(min);
    }
    public double mag(){
        return Math.sqrt(x*x+y*y);
    }
    public void setMag(double mag){
        div(mag());
        mult(mag);
    }
    public void norm(){
        setMag(1);
    }
    public static double dist(Vector a, Vector b){
        return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
    }
    public static Vector add(Vector a, Vector b){
        return new Vector(a.x+b.x, a.y+b.y);
    }
    public static Vector add(Vector a, double b){
        return new Vector(a.x+b, a.y+b);
    }
    public static Vector mult(Vector a, Vector b){
        return new Vector(a.x*b.x, a.y*b.y);
    }
    public static Vector mult(Vector a, double b){
        return new Vector(a.x*b, a.y*b);
    }
    public static Vector sub(Vector a, Vector b){
        return new Vector(a.x-b.x, a.y-b.y);
    }
    public static Vector sub(Vector a, double b){
        return new Vector(a.x-b, a.y-b);
    }
    public static Vector div(Vector a, Vector b){
        return new Vector(a.x/b.x, a.y/b.y);
    }
    public static Vector div(Vector a, double b){
        return new Vector(a.x/b, a.y/b);
    }
    //Self
    public Vector add( Vector b){
        return new Vector(x+b.x, y+b.y);
    }
    public Vector add( double b){
        return new Vector(x+b, y+b);
    }
    public Vector mult( Vector b){
        return new Vector(x*b.x, y*b.y);
    }
    public Vector mult( double b){
        return new Vector(x*b, y*b);
    }
    public Vector sub( Vector b){
        return new Vector(x-b.x, y-b.y);
    }
    public Vector sub( double b){
        return new Vector(x-b, y-b);
    }
    public Vector div( Vector b){
        return new Vector(x/b.x, y/b.y);
    }
    public Vector div( double b){
        return new Vector(x/b, y/b);
    }
    
}
