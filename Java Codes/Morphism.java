public class Morphism
{
    public static String f(String s, String t, String u)
    {
            String u2 = "";
            for(int i = 0; i < u.length(); i++){
                if (u.charAt(i) == '0') u2 += s;
                if (u.charAt(i) == '1') u2 += t;
            }
            StdOut.println(u2);
            return u2;
    }

    public static void f(String s, String t, String u, int n)
    {
        if (n == 0) return;
        f(s, t, f(s, t, u), n-1);
    }

    public static void main(String[] args)
    {
        String s = args[0];
        String t = args[1];
        int n = Integer.parseInt(args[2]);
        String u = StdIn.readString();
        StdOut.println(u);
        f(s, t, u, n);
    }
}
