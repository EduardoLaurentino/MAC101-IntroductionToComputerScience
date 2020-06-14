public class BouncingBall
{
    public static void main(String[] args)
    {
        double rx = 0.480, ry = 0.860;
        double vx = 0.015, vy = 0.023;
        double radius = 0.075;

        StdDraw.setXscale(-2.0, +2.0);
        StdDraw.setYscale(-2.0, +2.0);

        while (true)
        {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledSquare(0.0, 0.0, 2.0);
            if (Math.abs(rx + vx) + radius > 2.0) vx = -vx;
            if (Math.abs(ry + vy) + radius > 2.0) vy = -vy;
            rx = rx + vx;
            ry = ry + vy;
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show(20);
        }
    }
}