/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.5.1 (Word and line count) - bônus
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

public class Wc2
{
    public static void main(String[] args)
    {


        String s = StdIn.readAll();

        ///quantidade de caracteres
        int chars = s.length();

        ///quantidade de palavras
        String[] split_swords = s.split("\\s+");
        int words = split_swords.length;

        ///quantidade de linhas
        String[] split_slines = s.split("\n");
        int lines = split_slines.length;

        StdOut.println(lines + "\t" + words + "\t" + chars);
    }
}