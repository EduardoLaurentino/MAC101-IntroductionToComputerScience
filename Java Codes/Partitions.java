/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 10 (Partições de inteiros)
 * Data: 04/06/2017
 *
 * Baseado em:
        - Partitions.java (de IntroCS)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Partitions
{
    static long[][] memo = new  long[500][500];

    public static long particoesD(int n){
        return particoesD(n, n);
    }

    /* versão dinâmica de particoesR que usa a técnica de memoização */
    public static long particoesD(int n, int m){
        if (n == 0) return 1;
        if (n < 0 || m == 0) return 0;

        if (memo[n][m] != 0) return memo[n][m];

        memo[n][m] = particoesD(n, m-1) + particoesD(n-m, m);
        return memo[n][m];
    }

    public static long particoesR(int n){
        return particoesR(n, n);
    }

    /*Esta função conta as partições de n e se baseia no seguinte fato:
    Para qualquer n inteiro, n = n = (n - 1) + 1 = ((n - 1) - 1) + 1 + 1... enquanto for possível diminuir n em uma
    unidade sem torná-lo negativo.
    Assim esta função recursiva divide o problema da partição em problemas menores, para conquistar a partição desejada*/
    public static long particoesR(int  n, int m){
        if (n == 0) return 1; //caso base onde há uma única maneira de escrever n;
        if (n < 0 || m == 0) return 0; //se n < 0, o último era maior do que o necessário; se m = 0, caso que n]ao há partição.
        return particoesR(n, m-1) + particoesR(n-m, m);
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        StdOut.println(particoesD(n));
    }
}