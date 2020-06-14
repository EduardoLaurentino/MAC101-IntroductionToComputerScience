public class Binary
{
    public static String convert(int n)
    {
        if (n == 1) return "1";
        if (n == 0) return "0";
        return convert(n/2) + (n%2);
    }

    public static void collatz(int N)
    {
         StdOut.print(N + " ");
         if (N == 1) return;
         else if ((N % 2) == 0) collatz(N / 2);
         else collatz(3*N + 1);
    }

    public static String ruler(int n)
    {
        if (n == 0) return "";
        return ruler(n - 1) + n + ruler(n - 1);
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        StdOut.println(convert(N));
        //collatz(N); StdOut.println();
        //StdOut.println(ruler(N));
    }

}