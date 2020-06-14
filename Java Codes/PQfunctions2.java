public class PQfunctions2
{
 public static void main(String[] args)
 {
 int N = (int) (44100 * 11);
 double[] a = new double[N+1];
 for (int i = 0; i <= N; i++)
 a[i] = Math.random();
 StdAudio.play(a);
 }
}