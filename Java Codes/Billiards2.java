public class Billiards
{
    public static void main(String[] args)
    {
        double rx = 0.0, ry = 0.0;
        double dx = 0.0, dy = 0.0, ds = 0.0;
        double vx = 0.0, vy = 0.0;
        double radius = 0.05;
        double massa = 1.0;
        double dt = 0.5;
        double forçaDeAtração = 0.01;
        double atrito = 0.025;
        double fx = 0;
        double fy = 0;

        //optei por estabelecer uma escala cartesiana com quatro quadrantes;
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        StdDraw.enableDoubleBuffering();

        while (true)
        {

            if (StdDraw.mousePressed()){
                boolean tx, ty; ///auxiliares na determinação do sentido da força de acordo com as posições da bola e do mouse

                if (StdDraw.mouseX() >= rx)
                {
                     if ((StdDraw.mouseX() >= 0 && rx >= 0) || (StdDraw.mouseX() < 0 && rx < 0))
                         dx = Math.abs(StdDraw.mouseX()) - Math.abs(rx);
                    else
                        dx = Math.abs(StdDraw.mouseX()) + Math.abs(rx);

                    tx = false;
                }
                else {
                    if ((StdDraw.mouseX() >= 0 && rx >= 0) || (StdDraw.mouseX() < 0 && rx < 0))
                        dx = Math.abs(rx) - Math.abs(StdDraw.mouseX());
                    else
                        dx = Math.abs(rx) + Math.abs(StdDraw.mouseX());

                    tx = true;
                }

                if (StdDraw.mouseY() >= ry){
                    if ((StdDraw.mouseY() >= 0 && ry >= 0) || (StdDraw.mouseY() < 0 && ry < 0))
                        dy = Math.abs(StdDraw.mouseY()) - Math.abs(ry);
                    else
                        dy = Math.abs(StdDraw.mouseY()) + Math.abs(ry);

                    ty = false;
                }
                else{
                    if ((StdDraw.mouseY() >= 0 && ry >= 0) || (StdDraw.mouseY() < 0 && ry < 0))
                        dy = Math.abs(ry) - Math.abs(StdDraw.mouseY());
                    else
                        dy = Math.abs(ry) + Math.abs(StdDraw.mouseY());

                    ty = true;
                }

                ///pitágoras
                ds = Math.sqrt((dx * dx) + (dy * dy));

                ///determinação das forças com sentidos coerentes
                if (tx) fx = ((1/ds) * (1/ds) * forçaDeAtração);
                else fx = -((1/ds) * (1/ds) * forçaDeAtração);

                if (ty) fy = ((1/ds) * (1/ds) * forçaDeAtração);
                else fy = -((1/ds) * (1/ds) * forçaDeAtração);

            }
            else
            {
                ///perda de velocidade
                fx = -(atrito * vx);
                fy = -(atrito * vy);
            }

            vx += fx * dt / massa;
            vy += fy * dt / massa;

            rx += vx * dt;
            ry += vy * dt;

            if (Math.abs(rx) + radius > 1.0) vx = -vx;
            if (Math.abs(ry) + radius >  1.0) vy = -vy;

            StdDraw.clear();
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(10);
        }

    }
}