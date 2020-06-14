public class LIS
{

        public static int LongestIncreasingSubsequenceP(char[] vetor){
            String[] lisS = new String[vetor.length];
            int[] lis = new int[vetor.length];

            int max = 0;

            for (int s = 0; s < vetor.length; s++ ) lisS[s] = "";
            for (int s = 0; s < vetor.length; s++ ) lis[s] = 1;

            lisS[0] += vetor[0];

            for (int i = 1; i < vetor.length; i++){
                for (int j = 0; j < i; j++)
                    if ((vetor[j] < vetor[i]) && (lis[i] < (lis[j] + 1))){
                        lisS[i] = lisS[j];
                        lis[i] = lis[j] + 1;
                    }

                lisS[i] += vetor[i];
            }

            for(int k = 0; k < lisS.length; k++) StdOut.println(lisS[k]);

            StdOut.println();

            for (int p = 0; p < vetor.length; p++) StdOut.println("[" + p + "] = " + lis[p]);
            for (int k = 0; k < vetor.length; k++)
                if (max < lis[k]) max = lis[k];

            return max;

        }


        public static int LongestIncreasingSubsequence(char[] vetor){
        int[] lis = new int[vetor.length];
        int max = 0;

        for (int s = 0; s < vetor.length; s++ ) lis[s] = 1;

        for (int i = 1; i < vetor.length; i++){
            for (int j = 0; j < i; j++)
                if ((vetor[j] < vetor[i]) && (lis[i] < (lis[j] + 1)))
                    lis[i] = lis[j] + 1;
        }


        ///for (int p = 0; p < vetor.length; p++) StdOut.println("[" + p + "] = " + lis[p]);
        for (int k = 0; k < vetor.length; k++)
            if (max < lis[k]) max = lis[k];

        return max;

    }

    public static int LongestIncreasingSubsequence(int[] vetor){
        int[] lis = new int[vetor.length];
        int max = 0;

        for (int s = 0; s < vetor.length; s++ ) lis[s] = 1;

        for (int i = 1; i < vetor.length; i++)
            for (int j = 0; j < i; j++)
                if ((vetor[i] > vetor[j]) && (lis[i] < (lis[j] + 1)))
                    lis[i] = lis[j] + 1;


        for (int p = 0; p < 6; p++) StdOut.println("[" + p + "] = " + lis[p]);
        for (int k = 0; k < vetor.length; k++)
            if (max < lis[k]) max = lis[k];

        return max;

    }

    public static char[] letras(int n)
    {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] s = new char[n];
        for (int i = 0; i < n; i ++) s[i] = alfabeto[i];

        return s;
    }

    public static char[] letras (String s)
    {
        char[] v = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            v[i] = s.charAt(i);

        return v;
    }





    public static void main(String[] args){
        /*int[] sequencia = new int[6];
        for (int i = 0; i < args[0].length(); i++) sequencia[i] = Integer.parseInt(args[0].substring(i, i+1));

        ///for (int j = 0; j < 6; j++) StdOut.println("[" + j + "] = " + sequencia[j]);

        StdOut.println("LIS = " + LongestIncreasingSubsequence(sequencia));*/

        ///int n = Integer.parseInt(args[0]);


        StdOut.println(LongestIncreasingSubsequenceP(letras(args[0])));
    }
}