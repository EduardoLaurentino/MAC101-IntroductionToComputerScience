/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 2.3.33 (Interleaving two strings)
 * Data: 30/05/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/


public class Shuffle
{
    public static int fatorial(int n)
    {
        if (n == 1) return 1;
        return n * fatorial(n - 1);
    }

    public static String intercala(String antes, String variacao, String depois)
    {
        if (variacao.length() == 0) return "";


        for(int i = 0; i <= depois.length(); i++){

        System.out.println(antes + depois.substring(0, i) + variacao + depois.substring(i));
        if (variacao.length() > 1) intercala(antes + variacao.substring(0, variacao.length() - (i + 1)) + depois.substring(0, i+1), variacao.substring(variacao.length() - (i + 1)), depois.substring(1));


        }

        return "";
    }

    public static void main(String[] args)
    {
        String s1 = args[0];
        String s2 = args[1];


        String a = intercala("", s1, s2);
    }
}