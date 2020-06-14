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

public class Permutations3{

    static int[] lis = new int[30];
    static int[] lds = new int[30];
    static int num = 0;
    static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int maxLIS = 0, maxLDS = 0;

    /*Declarações globais necessarias nos métodos que nao entraram na versao final */
    /*
    static int[][] opt = new int[100][100];
    static String alphabetD = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
    */

    ///preenche o vetor lis[] como segue:  para todo i = 0, ..., p -1,
    ///lis[i] é o comprimento das subsequências mais compridas de vetor[0], ..., vetor[p - 1] que têm vetor[i] como último elemento.
    public static void LIS(String prefix, int i){
            maxLIS = 0;
            maxLDS = 0;
            int p = prefix.length();
            lis[p] = 0;
            lds[p] = 0;

            ///for (int s = 0; s < p; s++ ) {lis[s] = 1; lds[s] = 1;}

            ///for (int i = 1; i < p; i++){
                char k = prefix.charAt(i);
                for (int j = 0; j < p; j++){
                    if ((prefix.charAt(j) < k) && (lis[p] < lis[j])){
                        lis[p] = lis[j];
                        if (lis[j] > maxLIS) maxLIS = lis[j];
                    }
                    if ((prefix.charAt(j) > k) && (lds[p] < lds[j])){
                        lds[p] = lds[j];
                        if (lds[j] > maxLDS) maxLDS = lds[j];
                    }
               }

            if (maxLIS < (lis[p] + 1)) maxLIS = lis[p] + 1;
            if (maxLDS < (lds[p] + 1)) maxLDS = lds[p] + 1;
    }

    ///imprime as permutações de s cujas substrings crescentes tenham tamanho máximo 'a' e as
    ///substrings decrescentes tenham tamanho máximo 'b'
    public  static void permAB_Oficial(String s, int a, int b, int m) { permAB_Oficial("", s, a, b, m); }
    private static void permAB_Oficial(String prefix, String s, int a, int b, int m) {
        int n = s.length();
        if (n == 0) {num++; if(m == 2) StdOut.println(prefix);}
        else{
            for (int i = 0; i < n; i++){
                char l = s.charAt(i);
                LIS(prefix + l, i);
                if (maxLIS <= a && maxLDS <= b)
                    permAB_Oficial(prefix + l, s.substring(0, i) + s.substring(i+1), a, b, m);
            }
        }
    }

    /*===== métodos não utilizados na versão final mas que foram feitos e/ou utilizados até chegar na versão final ========*/

    /*
    //preenche o vetor lis[] como segue:  para todo i = 0, ..., p -1,
    ///lis[i] é o comprimento das subsequências mais compridas de vetor[0], ..., vetor[p - 1] que têm vetor[i] como último elemento.
    public static void LIS(String prefix){
            maxLIS = 0;
            maxLDS = 0;
            int p = prefix.length();

            for (int s = 0; s < p; s++ ) {lis[s] = 1; lds[s] = 1;}

            for (int i = 1; i < p; i++){
                char k = prefix.charAt(i);
                for (int j = 0; j <= i; j++){
                    if ((prefix.charAt(j) < k) && (lis[i] < (lis[j] + 1))){
                        lis[i] = lis[j] + 1;
                        if (lis[i] > maxLIS) maxLIS = lis[i];
                    }
                    if ((prefix.charAt(j) > k) && (lds[i] < (lds[j] + 1))){
                        lds[i] = lds[j] + 1;
                        if (lds[i] > maxLDS) maxLDS = lds[i];
                    }
                }
            }
    }




    ///versão trivial (e lenta) do método acima
    public  static void permAB(String s, int a, int b) { permAB("", s, a, b); }
    private static void permAB(String prefix, String s, int a, int b) {
        int n = s.length();
        if ((n == 0) && (lcs(prefix, alphabet).length() <= a) && (lcs(prefix, alphabetD).length() <= b) ) StdOut.println(prefix);

        else {
            for (int i = 0; i < n; i++)
               permAB(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), a, b);
        }

    }

    // Compute length of LCS for all subproblems. (retirado das transparências de aula)
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

    /// imprime todas as permutações da string v, mantendo os elementos v[0], ..., v[p - 1] fixos;
    /// os elementos que devem ser permutados são os elementos em v[p], ..., v[n - 1], onde n = v.length().
    private static void perms(String v, int p){
        String prefix = "";
        for(int j = 0; j < p; j++) prefix += v.charAt(j);

        perm1(prefix, v.substring(p));
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

    */

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);

        String elements = alphabet.substring(0, n);

        permAB_Oficial(elements, a, b, m);
        if (m == 1 || m == 2) StdOut.println(num);
    }
}