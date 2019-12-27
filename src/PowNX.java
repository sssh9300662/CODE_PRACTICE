import java.lang.Math;

public class PowNX {

    public PowNX() {
        // TODO Auto-generated constructor stub
    }
    
    
    public double myPow(double x, int n) {
        double a = Double.valueOf(String.valueOf(n));
        return Math.pow(x, a);
        
    }

    public static void main(String[] args) {
        PowNX obj = new PowNX();
        System.out.println(obj.myPow(2.00000, -2));
    }

}
