public class LDioph5
{

    public static long mdcEuclidiano(long m, long n){
        if (n == 0) return m;
        return mdcEuclidiano(n, m%n);
    }

    public static long[] solve4(long a, long b, long c, long d, long e){
        long m = mdcEuclidiano(mdcEuclidiano(b, c), d);
        long[] B = solve3(b, c, d, m);
        long[] C = solve2(a, m, e);

        long[] A = new long[4];
        A[0] = C[0];
        A[1] = C[1]*B[0];
        A[2] = C[1]*B[1];
        A[3] = C[1]*B[2];

        return A;
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
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);
        long d = Long.parseLong(args[3]);
        long e = Long.parseLong(args[4]);

        long[] s = solve4(a, b, c, d, e);

        StdOut.println(a + " * (" + s[0] + ") + " + b + " * (" + s[1] + ") + " + c + " * (" + s[2] + ") + " + d + " * (" + s[3] + ") = " + e);
        StdOut.println("[Checking: LHS is " + (a*s[0] + b*s[1] + c*s[2] + d*s[3]) + "]");
    }
}