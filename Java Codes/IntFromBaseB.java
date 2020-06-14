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

public class IntFromBaseB
{
    public static int procura(char c, char[] cs)
    {
        int i;
        boolean continua = true;
        for(i = 0; i < cs.length && continua; i++)
            if (cs[i] == c) continua = false;

        return i - 1;
    }

    public static int integerFromB(String s, int B)
    {
        char[] digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                     'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int tam = s.length();
        char c = '*';
        boolean continua = true;
        int i;
        for (i = 0; i < tam && continua; i++){
            c = s.charAt(i);
            if (c != '*') {continua = false; i--;}
        }

        if (continua) return 0;

        String s2 = "";
        for (int j = 0; j < tam; j++){
            if (j == i) s2 += "*";
            else s2 += s.charAt(j);
        }

        int coeficiente = procura(c, digitos);
        int pos = tam - i - 1;

        return integerFromB(s2, B) + (int) (coeficiente * (Math.pow(B, pos)));

    }

    public static void main(String[] args)
    {
        int B = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty())
        {
            String ns = StdIn.readLine();
            ns = ns.trim();
            StdOut.println(integerFromB(ns, B));
        }
    }
}