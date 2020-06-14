/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 6 (Base B)
 * Data: 20/05/2017
 *
 * Baseado em: Binary.java
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/


public class IntToBaseB
{
    public static String baseB(int n, int B)
    {
        String[] digitos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g",
                                    "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        if (n == 1) return "1";
        if (n == 0) return "";
        return baseB(n/B, B) + digitos[(n%B)];
    }

    public static void main(String[] args)
    {
        int B = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty())
        {
            String ns = StdIn.readLine();
            ns = ns.trim();
            int n = Integer.parseInt(ns);
            StdOut.println(baseB(n, B));
        }
    }
}