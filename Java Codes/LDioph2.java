public class LDioph2
{

    public static long[] solve(long a, long b, long c){
        if (b == 0){
            long[] s = new long[2];
            if (c % a == 0) { s[0] = c / a; s[1] = 0; }
            else{
                StdOut.println("No solution");
                System.exit(0);
            }
            return s;
        }

        long[] ss = solve(b, a%b, c);
        long[] s = new long[2];
        long q = a/b;
        s[0] = ss[1]; s[1] = ss[0] - q*ss[1];

        return s;
    }

    public static void main(String[] args){
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);

        long[] s = solve(a, b, c);

        StdOut.println(a + " * (" + s[0] + ") + " + b + " * (" + s[1] + ") = " + c);
        StdOut.println("[Checking: LHS is " + (a*s[0] + b*s[1]) + "]");
    }

}