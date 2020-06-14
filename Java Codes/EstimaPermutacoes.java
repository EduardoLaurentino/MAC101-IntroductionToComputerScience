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


public class EstimaPermutacoes{
    public static void main(String[] args){
        int NMAX = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int r;
        boolean pode = true;
        boolean ainda_nao_deu_ruim = true;
        double aconteceu = 0;


        for (int i = 2; i <= NMAX; i++){
            int[] a = new int[i];

            for (int k = 1; k <= T; k++) {

                ///GERADOR DE PERMUTAÇÕES ALEATÓRIAS
                /*(gera um vetor com NMAX elementos inteiros [0, NMAX) dispostos em posições aleatórias. Isto é,
                um vetor {0, 1, 2, ..., NMAX-1} permutado aleatoriamente.*/
                for (int j = 0; j < i; j++){
                    r = (int) (Math.random() * (i));
                    for (int x = 0; pode && x < j; x++){
                        if (a[x] == r) pode = false;
                    }
                    if (pode) {
                        a[j] = r;
                        ///DIFERENCA EM RELAÇÃO EX. 2: verifica se a permutação é ruim sem contar um caso mais de uma vez
                        if (a[j] == j && ainda_nao_deu_ruim) {
                            aconteceu++;
                            ainda_nao_deu_ruim = false;
                        }
                        ///
                    }
                    else j--;
                    pode = true;
                }
                ainda_nao_deu_ruim = true;
            }

            double q_N = ((T- aconteceu) / T);
            System.out.println(i + " " + q_N);

            aconteceu = 0;
        }
    }
}