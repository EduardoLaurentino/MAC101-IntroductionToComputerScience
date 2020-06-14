/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 2 Amigo Secreto
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

public class AmigoSecreto{
    public static void main(String[] args){
        int NMAX = Integer.parseInt(args [0]);
        int T = Integer.parseInt(args[1]);
        int r;
        boolean pode = true;
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
                    if (pode) a[j] = r;
                    else j--;
                    pode = true;
                }
                ///

                ///CRIA VETOR COM A ORDEM DE RECEBIMENTOS DOS PRESENTES
                int[] b = new int[i];
                int r2;
                boolean certo = true, sem = true;

                b[0] = a[0];
                for (int t = 1; t < i; t++) {
                    for (int h = 0; h < t && certo; h++) if (b[h] == a[b[t-1]]) certo = false; ///verifica se a pessoa já recebeu presente (!certo) ou ainda não recebeu (certo);

                    if (certo) b[t] = a[b[t-1]];
                    else{
                        while (!certo){
                            r2 = (int) (Math.random() * (i)); ///aleatoriamente/arbitrariamente (como pede o enunciado) é levantado um novo candidato a recomeçar o processo;
                            sem = true;
                            for (int p = 0; sem && p < t; p++) if (b[p] == r2) sem = false; ///confirma se o candidato é válido (se já não recebeu presente/está no vetor)
                            if (sem) {
                                b[t] = a[r2];
                                certo = true;
                            }
                        }
                    }
                }
                ///

                ///CONDIÇÃO DA SURPRESA (fenômeno S)
                if (b[i-1] == 0 && a[0] != 0) aconteceu++; /// (a && b): 'a' garante que pessoa 0 foi última a receber e 'b' garante que nao se trata de uma permutação iniciada com 0
                ///
            }

            double p_N = (aconteceu / T);
            System.out.println(i + " " + p_N);

            aconteceu = 0;
        }
    }
}