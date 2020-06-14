/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.4.6 (Linear feedback shift register; variante)
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

public class LFSRGen{
    public static void main(String[] args){
        int QuantBits = Integer.parseInt(args[2]);
        int tap = Integer.parseInt(args[1]);
        String seed = args[0];
        char[]  fita = new char[seed.length() + QuantBits];

        for (int i = 0; i < (seed.length()); i++) fita[i] = seed.charAt(i);

        int limite = seed.length();
        int a = 0, b = (seed.length() - tap) - 1;
        while (limite != (seed.length() + QuantBits)){
            if (fita[a++] == fita[b++]) {
                fita[limite] = '0';
                System.out.print(fita[limite++]);
            }
            else {
                fita[limite] = '1';
                System.out.print(fita[limite++]);
            }
        }
        System.out.println();
    }
}