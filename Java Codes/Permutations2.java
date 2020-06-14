/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 09 ((a, b)-Permutações)
 * Data: 04/06/2017
 *
 * Baseado em:
        - LongestCommonSubsequence.java (de IntroCS, uso do método "public static String lcs(String x, String y)" integralmente
        - Permutation.java (de IntroCS)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class ABPerm{

    static int[] lis = new int[100];
    static int[][] opt = new int[100][100];
    static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String alphabetD = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";

    /*preenche o vetor lis[] como segue:  para todo i = 0, ..., p -1,
    lis[i] é o comprimento das subsequências mais compridas de vetor[0], ..., vetor[p - 1] que têm vetor[i] como último elemento.*/
    public static void LIS(char[] vetor, int p){
            int max = 0;

            for (int s = 0; s < p; s++ ) lis[s] = 1;

            for (int i = 1; i < p; i++){
                for (int j = 0; j < i; j++)
                    if ((vetor[j] < vetor[i]) && (lis[i] < (lis[j] + 1)))
                        lis[i] = lis[j] + 1;
            }
    }

    /* imprime todas as permutações do vetor v, mantendo os elementos v[0], ..., v[p - 1] fixos;
     os elementos que devem ser permutados são os elementos em v[p], ..., v[n - 1], onde n = v.length.*/
    private static void perms(char[] v, int p){
        String prefix = "";
        for(int j = 0; j < p; j++) prefix += v[j];

        for (int i = p; i < v.length; i++){
            prefix += v[i];
            String s = "";
            for(int k = p; k < v.length; k++)
                if (k != i) s += v[k];
            perm1(prefix, s);
            prefix = prefix.substring(0, prefix.length() - 1);
        }
    }


    /*imprime as permutações de s cujas substrings crescentes tenham tamanho máximo 'a' e as
    substrings decrescentes tenham tamanho máximo 'b'*/
    public  static void permAB(String s, int a, int b) { permAB("", s, a, b); }
    private static void permAB(String prefix, String s, int a, int b) {
        int n = s.length();
        if ((n == 0) && (lcs(prefix, alphabet).length() <= a) && (lcs(prefix, alphabetD).length() <= b) ) StdOut.println(prefix);

        else {
            for (int i = 0; i < n; i++)
               permAB(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), a, b);
        }

    }

    // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) StdOut.println(prefix);

        else {
            for (int i = 0; i < n; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }

    /*coloca os caracteres de uma string em um vetor de caracteres*/
    public static char[] letras (String s)
    {
        char[] v = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            v[i] = s.charAt(i);

        return v;
    }

    // Compute length of LCS for all subproblems.
    public static String lcs(String x, String y) {
        int m = x.length(), n = y.length();
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    opt[i][j] = opt[i+1][j+1] + 1;
                }
                else {
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
                }
            }
        }

        // Recover LCS itself.
        String lcs = "";
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j)) {
                lcs += x.charAt(i);
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        return lcs;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        String elements = alphabet.substring(0, n);
        permAB(elements, a, b);
    }
}