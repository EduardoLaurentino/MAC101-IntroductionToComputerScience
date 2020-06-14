public class MDCEuclides
{
    public static long mdc(long m, long n){
        if (n == 0) return m;
        return mdc(n, m%n);
    }

    public static void main(String[] args){
        long m = Long.parseLong(args[0]);
        long n = Long.parseLong(args[1]);

        StdOut.println("mdc(" + m + ", " + n + ") = " + mdc(m, n));
    }
}