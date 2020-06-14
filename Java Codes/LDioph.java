public class LDioph
{

    public static long mdcEuclidiano(long m, long n){
        if (n == 0) return m;
        return mdcEuclidiano(n, m%n);
    }

    public static long[] solve3(long a, long b, long c, long d){
        long m = mdcEuclidiano(b, c);
        long[] B = solve2(b, c, m);
        long[] C = solve2(a, m, d);

        long[] A = new long[3];
        A[0] = C[0];
        A[1] = C[1]*B[0];
        A[2] = C[1]*B[1];

        return A;
    }

    public static long[] solve2(long a, long b, long c){
        if (b == 0){
            long[] s = new long[2];
            if (c % a == 0) { s[0] = c / a; s[1] = 0; }
            else{
                StdOut.println("No solution");
                System.exit(0);
            }
            return s;
        }

        long[] ss = solve2(b, a%b, c);
        long[] s = new long[2];
        long q = a/b;
        s[0] = ss[1]; s[1] = ss[0] - q*ss[1];

        return s;
    }

    public static void main(String[] args){
        String l1 = StdIn.readLine();
        String[] s = l1.split("\\s+");

        int tam = s.length;
        long m = Long.parseLong(s[1]);

        for (int i = 2; i < tam; i ++){
            m = mdcEuclidiano(m, Long.parseLong(s[i]));

        }


        if ((Long.parseLong(s[0])%m) != 0) {
            StdOut.println("No solution");
            System.exit(0);
        }

    }
}