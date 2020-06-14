public class ArrangementsProf
{
    public static void multi(String s)
    {
        multi("", s);
    }

    private static void multi(String prefix, String s)
    {
        int N = s.length();
        if (N == 0) StdOut.println(prefix);
        else {
            boolean[] used = new boolean['z' - 'A' + 1];
            for (int i = 0; i < N; i++)
                if (!used[s.charAt(i) - 'A']){
                    multi(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
                    used[s.charAt(i) - 'A'] = true;
                }

        }
    }

    public static void main(String[] args)
    {
        String start = args[0];
        multi(start);
    }
}