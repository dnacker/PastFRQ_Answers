package Q2;

/**
 * Solutions to question 2.
 */
public class APLine {
    private int a, b, c;

    public APLine(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getSlope() {
        return -1.0 * a / b;
    }

    public boolean isOnLine(int x, int y) {
        return a * x + b * y + c == 0;
    }

    public static void main(String[] args) {
        APLine line1 = new APLine(5, 4, -17);
        double slope1 = line1.getSlope();
        boolean onLine1 = line1.isOnLine(5, -2);

        APLine line2 = new APLine(-25, 40, 30);
        double slope2 = line2.getSlope();
        boolean onLine2 = line2.isOnLine(5, -2);

        System.out.println(slope1);
        System.out.println(onLine1);
        System.out.println(slope2);
        System.out.println(onLine2);

    }
}
