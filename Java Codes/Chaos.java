public class Chaos
{
     public static void main(String[] args)
     {
         int trials = Integer.parseInt(args[0]);
         double c = Math.sqrt(3.000) / 2.000;
         double[] cx = { 0.000000, 1.000000, 0.500000 };
         double[] cy = { 0.000000, 0.000000, c };
         StdDraw.setPenRadius(0.01);
         double x = 0.0, y = 0.0;
         for (int t = 0; t < trials; t++)
         {
             int r = (int) (Math.random() * 3);
             x = ((x) + cx[r]) / 2.0;
             y = ((y) + cy[r]) / 2.0;
             StdDraw.point(x, y);
         }
     }
}