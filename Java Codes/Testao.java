/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.4.10 (Connect four) (ii)
 * Data: 22/04/2017
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

public class Testao{
    public static void main(String args[]){

        ///String elementos_matriz = args[0];
        int N = Integer.parseInt(args[0]);
        ///int p = 0;
        char[][] matriz = new char[N][N];
        char caractere = '*', novo_caractere = caractere;
        int tamanho = 1, r;

        /*cria matriz com os elementos da entrada, imprime tabularmente e faz busca pela sequência contígua horizontal mais longa*/
        int resultadoH = 0;
        int linhaH = 0, colunaH = 0, colunaH_final = 0;
        char caractere_finalH = caractere;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ///atribuição de elementos e impressão:
                r = (int) (Math.random() * 3);
                while (r != 0 && r != 1 && r != 2)
                    r = (int) (Math.random() * 3);
                if (r == 0) matriz[i][j] = '*';
                else if (r == 1) matriz[i][j] = 'X';
                else if (r == 2) matriz[i][j] = 'O';
                ///matriz[i][j] = elementos_matriz.charAt(p++);
                System.out.print(matriz[i][j] + " ");
                ///busca horizontal:
                if (j == 0) {
                    caractere = matriz[i][j];
                    tamanho = 1;
                    colunaH = j;
                }
                else {
                    novo_caractere = matriz[i][j];
                    if (novo_caractere == caractere) {
                        tamanho++;
                        if (tamanho >= resultadoH){
                            caractere_finalH = novo_caractere;
                            resultadoH = tamanho;
                            colunaH_final = colunaH;
                            linhaH = i;
                        }
                    }
                    else{
                        colunaH = j;
                        caractere = novo_caractere;
                        tamanho = 1;
                    }
                }
            }
            System.out.println();
        }


        ///busca vertical
       int resultadoV = 0;
       int linhaV = 0, colunaV = 0, linhaV_final = 0;
       char caractere_finalV = caractere;

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (i == 0){
                    caractere = matriz[i][j];
                    tamanho = 1;
                    linhaV = i;
                }
                else{
                    novo_caractere = matriz[i][j];
                    if (novo_caractere == caractere) {
                        tamanho++;
                        if (tamanho > resultadoV){
                            caractere_finalV = caractere;
                            resultadoV = tamanho;
                            linhaV_final = linhaV;
                            colunaV = j;
                        }
                    }
                    else{
                        linhaV = i;
                        caractere = novo_caractere;
                        tamanho = 1;
                    }
                }
            }
        }

        ///resultados
        if (resultadoH >= resultadoV) System.out.println(resultadoH + " / (" + linhaH + ", " + colunaH_final + ") [" + caractere_finalH + " / h]");
        else System.out.println(resultadoV + " / (" + linhaV_final + ", " + colunaV + ") [" + caractere_finalV + " / v]");

    }
}