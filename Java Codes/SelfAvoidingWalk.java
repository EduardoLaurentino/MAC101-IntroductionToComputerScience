/******************************************************************************
 *  Compilation:  javac SelfAvoidingWalk.java
 *  Execution:    java SelfAvoidingWalk n
 *  Dependencies: StdDraw.java
 *
 *  Simulate and animate a self-avoiding walk in two dimensions. Follow
 *  trajectory of 2D random walk until it walks back in on itself or
 *  reaches the boundary. Always choose a direction that won't hit itself
 *  if possible.
 *
 *  This random process produces a biased SAW. To produce an unbiased
 *  SAW, need to generate a 2D random walk (choosing each of the 4
 *  directions with equal likelihood) and start over from scratch
 *  if it self-intersects.
 *
 *  % java SelfAvoidingWalk 16
 *
 *  % java SelfAvoidingWalk 32
 *
 ******************************************************************************/

public class SelfAvoidingWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        StdDraw.enableDoubleBuffering();

        // draw many self-avoiding random walks
        while (true) {
            StdDraw.clear();
            boolean[][] visited = new boolean[n][n];

            // starting position
            int x = n / 2;
            int y = n / 2;
            visited[x][y] = true;
        StdDraw.filledSquare(x + 0.5, y + 0.5, 0.45);
        StdDraw.show();
        StdDraw.pause(25);
        StdDraw.pause(0);

            // make a random move as long as particle is not boxed in
            while (!visited[x-1][y] || !visited[x+1][y]
           || !visited[x][y-1] || !visited[x][y+1]) {

                // try until you find an available move
                while (true) {
                    double r = StdRandom.uniform();
                    if (r < 0.25 && !visited[x-1][y]) { x--; break; }
                    else if (r < 0.50 && !visited[x+1][y]) { x++; break; }
                    else if (r < 0.75 && !visited[x][y-1]) { y--; break; }
                    else if (r < 1.00 && !visited[x][y+1]) { y++; break; }
                }
                visited[x][y] = true;

                // draw
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.45);
                StdDraw.show();
                StdDraw.pause(25);
                StdDraw.pause(0);

        // hit outside boundary?
                if (x <= 0 || x >= n-1 || y <= 0 || y >= n-1) break;
            }
        //            StdDraw.pause(1000);
        StdDraw.pause(1000);
            StdDraw.pause(0);
        }
    }
}