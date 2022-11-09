package Basic;

public class Functions {
    public static double mapRange(double a1, double a2, double b1, double b2, double s){
		return b1 + ((s - a1)*(b2 - b1))/(a2 - a1);
	}
    public static double constrain(double v,double min, double max){
        if (v > max) return max;
        if (v < min) return min;
        return v;
    }
}
