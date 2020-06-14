/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Variante do Web Exercise 2.3.51 (Unix diff)
 * Data: 16/06/2017
 *
 * Baseado em:
        - Diff.java
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class DiffLines
{

    public static void main(String[] args)
    {
        String l1 = StdIn.readLine();
        String[] s = l1.split("\\s+");
        String l2 = StdIn.readLine();
        String[] t = l2.split("\\s+");

        int m = s.length;
        int n = t.length;

        // opt[i][j] = length of LCS of x[i..m] and y[j..n]
        int[][] opt = new int[m+1][n+1];

        /// compute length of LCS and all subproblems via dynamic programming
        for(int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (s[i].equals(t[j]))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                     opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
                }
        }

        // marca as diferenças
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s[i].equals(t[j])) {
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) s[i] = "*" + s[i++] + "*";
            else                                             t[j] = "*" + t[j++] + "*";
        }

        while (j < n) t[j] = "*" + t[j++] + "*";
        while (i < m) s[i] = "*" + s[i++] + "*";

        //imprime as linhas indicando as diferenças
        StdOut.println("First line:");
        i = 0;
        while (i < m)
            StdOut.print(s[i++] + " ");
        StdOut.println();

        StdOut.println("Second line:");
        j = 0;
        while (j < n)
            StdOut.print(t[j++] + " ");
        StdOut.println();

    }
}
