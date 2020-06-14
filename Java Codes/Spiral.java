/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.5.16 (Spiral)
 * Data: 29/04/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Spiral
{
    public static void main(String[] args)
    {

        double x = 1.0, y = 1.0; //dentro da espiral
        StdDraw.setPenRadius(0.005);

        for (double i = 0; i < 5; i += 0.1)
        {
            ///reta vertical - cima
            StdDraw.line((x/2)-(0.1*i), (y/2)-(0.1*i), (x/2)-(0.1*i), (y/2)+(0.1*(i+0.1)));
            ///reta horizontal - direita
            StdDraw.line((x/2)-(0.1*i), (y/2)+(0.1*(i+0.1)), (x/2)+(0.1*(i+0.1)), (y/2)+(0.1*(i+0.1)));
            ///reta vertica - baixo
            StdDraw.line((x/2)+(0.1*(i+0.1)), (y/2)+(0.1*(i+0.1)), (x/2)+(0.1*(i+0.1)), (y/2)-(0.1*(i+0.1)));
            ///reta horizontal - esquerda
            StdDraw.line((x/2)+(0.1*(i+0.1)), (y/2)-(0.1*(i+0.1)), (x/2)-(0.1*(i+0.1)), (y/2)-(0.1*(i+0.1)));
        }

    }
}
