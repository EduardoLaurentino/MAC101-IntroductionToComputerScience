/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Variante do Creative Ex. 2.3.17 (Permutations)
 * Data: 14/05/2017
 *
 * Baseado em:
        - Permutations.java
        (Este programa é uma variação de Permutations.java, como pede o enunciado, e, sendo assim,
        reutiliza diversas partes do código)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Arrangements{

    public static int fatorial(int n)
    {
        if (n == 1) return 1;
        else return n * fatorial(n - 1);
    }

   public static void perm(char[] a, int n, String[] permutacoes) {

        if (n == 1) {
            String permutacao = "";
            for(int i = 0; i < a.length; i++) permutacao += a[i];
            ///StdOut.println(permutacao);

            int cont = 0;
            while (permutacoes[cont] != null) cont++;

            boolean pode = true;
            for (int i = 0; i < cont && pode; i++) {
                if(permutacoes[i].equals(permutacao)) pode = false;
            }

            if (pode) {
                permutacoes[cont] = permutacao;
                StdOut.println(permutacao);
            }

            return;
            }

        for (int i = 0; i < n; i++) {
            troca(a, i, n-1);
            perm(a, n-1, permutacoes);
            troca(a, i, n-1);
        }
    }

    public static void troca(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }


    public static void main(String[] args){
        String s = args[0];
        int tam = s.length();

        char[] h2 = new char[tam];

        for (int i = 0; i < tam; i++) h2[i] = s.charAt(i);


        String[] permutacoes = new String[fatorial(tam)];

        perm(h2, tam, permutacoes);
    }
}
