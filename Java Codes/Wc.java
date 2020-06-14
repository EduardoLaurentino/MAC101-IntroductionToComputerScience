/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.5.1 (Word and line count)
 * Data: 29/04/2017
 *
 * Baseado em:
        - Cat.java (disponibilizado junto ao enunciado)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Wc
{
    public static void main(String[] args)
    {
        String s = StdIn.readAll();

        int lines = 0;
        int words = 0;
        int chars = s.length();

        for (int i = 0; i < chars; i++)
        {
            if (s.charAt(i) == '\n') lines++;
            if ((Character.isWhitespace(s.charAt(i)) && i != 0) && !Character.isWhitespace(s.charAt(i-1)))  words++;
        }
        StdOut.println(lines + "\t" + words + "\t" + chars);
    }
}