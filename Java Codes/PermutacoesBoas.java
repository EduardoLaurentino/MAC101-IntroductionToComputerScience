/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 3 Amigo Secreto novamente
 * Data: 15/04/2017
 *
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/


public class PermutacoesBoas{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int r, i = 0;
        boolean pode_por = true;
        int[] a = new int[N];

        ///GERADOR DE PERMUTAÇÕES ALEATÓRIAS BOAS
        /*(gera um vetor com NMAX elementos inteiros [0, NMAX) dispostos aleatoriamente e em boas condicoes para o amigo secreto.
           Isto é, um vetor {0, 1, 2, ..., NMAX-1} permutado aleatoriamente garantindo que cada índice de posição seja diferente do valor guardado nela*/
        while (i < N){
            r = (int) (Math.random() * (N));
            for (int x = 0; pode_por && ((x < i) || (x == 0)); x++){
                if (a[x] == r || i == r) pode_por = false;
                else pode_por = true;
            }

            if (pode_por){
                 a[i] = r;
                 i++;
            }

            pode_por = true;
        }

        for (int j = 0; j < N; j++) System.out.print(a[j] + " ");
        System.out.println();

    }
}