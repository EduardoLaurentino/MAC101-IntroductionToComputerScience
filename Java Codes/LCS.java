public class LCS
{
    public static void main (String[] args)
    {
        String s = args[0];
        String t = args[1];
        int M = s.length();
        int N = t. length();

        int[][] opt = new int[M+1][N+1];

        for (int i = M - 1; i >= 0; i--)
            for (int j = N - 1; j >= 0; j--)
                if (s.charAt(i) == t.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j+1]);

        StdOut.println("LCS = " + opt[0][0]);

        String lcs = "";
        int i = 0, j = 0;
        while (i < M && j < N){
                if (s.charAt(i) == t.charAt(j)){
                    lcs += s.charAt(i);
                    i++; j++;
                }
                else if (opt[i+1][j] >= opt[i][j+1]) i++;
                else j++;
        }

        StdOut.println(lcs);
    }
}