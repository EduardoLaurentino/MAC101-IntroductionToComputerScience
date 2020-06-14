/******************************************************************************
 *  Compilation:  javac PlayThatTuneDeluxe.java
 *  Execution:    java PlayThatTuneDeluxe < data.txt
 *
 *  % java PlayThatTuneDeluxe 0.5 < elise.txt
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *  http://www.cs.princeton.edu/introcs/21function/portal.txt
 *
 ******************************************************************************/

public class PlayThatTuneDeluxeOriginal {

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

    ///devolve o vetor a[] obtido pelo processo do algoritmo Karplus--Strong
    public static double[] wave(double hz, double d) {
        int N = (int) (44100 * d);
        int p = (int) (44100/hz);
        double[] a = new double[N+1];

        for (int i = 0; i < p; i++) {
            a[i] = Math.random() * 2.0 - 1.0;
        }

        for (int i = p, j = 0; i <= N; i++, j++) {
            a[i] = .997*(a[j] + a[j+1])/2;
        }

        return a;
    }

    public static double[] waveOPICIONAL(double hz, double d) {
        int N = (int) (44100 * d);
        int p = (int) (44100/hz);
        double[] a = new double[N+1];

        for (int i = 0; i < p; i++) {
            a[i] = Math.random() * 2.0 - 1.0;
        }

        for (int i = p, j = 0; i <= N; i++, j++) {
            a[i] = .997*(9*a[j] + a[j+5])/10;
        }

        return a;
    }

    // create a note with harmonics of the given pitch and duration
    // (where 0 = concert A)
    public static double[] note(int pitch, double duration, boolean ativar_opcional) {
        ///PAUSA
        if (pitch < -20){
            int N = (int) (44100 * duration);
            double[] a = new double[N+1];
            return a;
        }
        ///
        else{
            double[] a;
            double[] hi;
            double[] lo;
            double hz = 220.0 * Math.pow(2, pitch / 12.0);
            if (ativar_opcional){
                a  = waveOPICIONAL(hz, duration);
                hi = waveOPICIONAL(2*hz, duration);
                lo = waveOPICIONAL(hz/2, duration);
            }
            else{
                a  = wave(hz, duration);
                hi = wave(2*hz, duration);
                lo = wave(hz/2, duration);
            }
            double[] h  = sum(hi, lo, 0.5, 0.5);
            return sum(a, h, 0.5, 0.5);
        }
    }


    // read in notes from standard input and play them on standard audio
    public static void main(String[] args) {
        boolean ativar_opcional;
        if (args.length >= 1) ativar_opcional = true;
        else ativar_opcional = false;


         // read in pitch-duration pairs from standard input
        while (!StdIn.isEmpty()) {

            String ordem = StdIn.readLine();
            ordem = ordem.trim();
            String[] pitchs = ordem.split("\\s+");

            if (pitchs.length > 1){

                double duration = Double.parseDouble(pitchs[pitchs.length - 1]);
                int N = (int) (44100 * duration);
                double[] a = new double [N + 1];

                double ponderada = 1.0/((double)(pitchs.length - 1));

                for(int i = 0; i < pitchs.length - 1; i++){

                    int pitch = Integer.parseInt(pitchs[i]);
                    double[] b = note(pitch, duration, ativar_opcional);
                    if (i == 0) a = b;
                    else if (i == 1) a = sum(a, b, ponderada, ponderada);
                    else a = sum(a, b, 1.0, ponderada);
                }
                StdAudio.play(a);
            }


        }
    }
}