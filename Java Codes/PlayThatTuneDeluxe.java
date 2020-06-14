public class PlayThatTuneDeluxe {

    // return weighted sum of two arrays
    public static double[] sum(double[] a, double[] b, double awt, double bwt) {

        // precondition: arrays have the same length
        assert a.length == b.length;

        // compute the weighted sum
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]*awt + b[i]*bwt;
        }
        return c;
    }

    public static double[] avg(double[] a, double[] b)
     {
         double[] c = new double[a.length];
         for (int i = 0; i < a.length; i++)
         c[i] = a[i]/2.0 + b[i]/2.0;

         return c;
    }

    public static double[] wave(double hz, double d){
        int N = (int) (44100 * d);
        int p = (int) (44100/hz);
        double[] a = new double[N+1];

        for (int i = 0; i < p; i++)
            a[i] = (Math.random() * 2) - 1.0;

       for (int i = p, j = 0; i <= N ; i++, j++)
            a[i] = .997*(a[j] + a[j+1])/2;

        return a;

    }

    // create a pure tone of the given frequency for the given duration
    public static double[] tone(double hz, double duration) {
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a;
    }

    // create a note with harmonics of the given pitch and duration
    // (where 0 = concert A)
    public static double[] note(int pitch, double duration) {
        double hz = 220.0 * Math.pow(2, pitch / 12.0);
        double[] a  = wave(hz, duration);
        double[] hi = wave(2*hz, duration);
        double[] lo = wave(hz/2, duration);
        double[] h  = sum(hi, lo, 0.5, 0.5);
        return sum(a, h, 0.5, 0.5);
    }


    // read in notes from standard input and play them on standard audio
    public static void main(String[] args) {

        // read in pitch-duration pairs from standard input
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            s = s.trim();
            String[] t = s.split("\\s+");
            for (int i = 0; i < t.length; i++) {
                StdOut.println(t[i]);
            }
            if (t.length > 1)
            {
                double duration = Double.parseDouble(t[t.length - 1]);
                for (int i = 0; i < t.length - 1; i++) {
                    int pitch = Integer.parseInt(t[i]);
                    if (pitch < -45) pitch = 0;
                    double[] a = note(pitch, duration);
                    StdAudio.play(a);
                }
            }

        }
    }
}