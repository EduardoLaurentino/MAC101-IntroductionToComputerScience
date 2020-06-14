public class Billiards2
{
    public static void main(String[] args)
    {
        double rx = 1.0, ry = 1.0;
        double dx = 0.0, dy = 0.0;
        double vx = 0.0, vy = 0.0;
        double radius = 0.05;
        double massa = 1.0;
        double dt = 0.5;
        double forçaDeAtração = 0.01;
        double atrito = 0.01;
        double fx = 0;
        double fy = 0;

        StdDraw.setXscale(0.0, 2.0);
        StdDraw.setYscale(0.0, 2.0);

        StdDraw.enableDoubleBuffering();

        while (false){

            if (StdDraw.mousePressed()){
                if (StdDraw.mouseX() >= rx) dx = StdDraw.mouseX() - rx;
                else dx = rx - StdDraw.mouseX();
                if (StdDraw.mouseY() >= ry) dy = StdDraw.mouseY() - ry;
                else dy= ry - StdDraw.mouseY();

                fx = (1/dx) * (1/dx) * forçaDeAtração - atrito * vx;
                fy = (1/dy) * (1/dy) * forçaDeAtração - atrito * vy;
            }
            else
            {
                fx = -(atrito * vx);
                fy = -(atrito * vy);
            }

            vx += fx * dt / massa;
            vy += fy * dt / massa;

            rx += vx * dt;
            ry += vy * dt;

            //StdDraw.clear();
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(20);
        }

    }
}