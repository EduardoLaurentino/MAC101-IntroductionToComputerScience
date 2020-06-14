public class VotingMachines3 {

    public static int count_votes(int N, double a, double e) {
        int A = (int) (a * N);
        int V = 0;

        for (int i = 0; i < A; i++)
            if (!StdRandom.bernoulli(e)) V++;

        for (int i = 0; i < N - A; i++)
            if (StdRandom.bernoulli(e)) V++;

        return V;
    }

    public static double is_reliable(int N, double a, double e, int T) {

        int f = 0;
        for (int i = 0; i < T; i++) {
            int A = count_votes(N, a, e);
            int B = N - A;
            if (A < B) f++;
        }
        return 1.0*f/T;
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        double f = Double.parseDouble(args[2]);
        int T = Integer.parseInt(args[3]);

        double tolerance = 0.3;

        double wrong = is_reliable(N, a, f, T);

        StdOut.println("Wrong results/trials: " + wrong + "/" + T);
        StdOut.println(wrong);
        if (wrong <= tolerance)
            StdOut.println("These values are acceptable");
        else
            StdOut.println("These values ​​are not acceptable");
    }
}