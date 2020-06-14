/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.4.10 (Connect four) (i)
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

public class ConnFourGenerator{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int forma = Integer.parseInt(args[1]);
        char[][] matriz = new char[N][N];
        int r;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                r = (int) (Math.random() * 3);
                while (r != 0 && r != 1 && r != 2)
                    r = (int) (Math.random() * 3);
                if (r == 0) matriz[i][j] = '*';
                else if (r == 1) matriz[i][j] = 'X';
                else if (r == 2) matriz[i][j] = 'O';

                System.out.print(matriz[i][j]);
                if (forma == 0) System.out.print(" ");
            }
            if (forma == 0) System.out.println();
        }
        if (forma == 1) System.out.println();
    }
}