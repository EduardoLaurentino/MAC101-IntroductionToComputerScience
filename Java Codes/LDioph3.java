/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Ex. 11 (Equações Diofantinas Lineares)
 * Data: 16/06/2017
 *
 * Baseado em:
        - LDioph2.java
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class LDioph3
{

    public static long mdcEuclidiano(long m, long n){
        if (n == 0) return m;
        return mdcEuclidiano(n, m%n);
    }

    public static long[] solve3(long a, long b, long c, long d){
        long m = mdcEuclidiano(b, c);
        long[] B = solve2(b, c, m);
        long[] C = solve2(a, m, d);

        long[] A = new long[3];
        A[0] = C[0];
        A[1] = C[1]*B[0];
        A[2] = C[1]*B[1];

        return A;
    }

    public static long[] solve2(long a, long b, long c){
        if (b == 0){
            long[] s = new long[2];
            if (c % a == 0) { s[0] = c / a; s[1] = 0; }
            else{
                StdOut.println("No solution");
                System.exit(0);
            }
            return s;
        }

        long[] ss = solve2(b, a%b, c);
        long[] s = new long[2];
        long q = a/b;
        s[0] = ss[1]; s[1] = ss[0] - q*ss[1];

        return s;
    }

    public static void main(String[] args){
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);
        long d = Long.parseLong(args[3]);

        long[] s = solve3(a, b, c, d);

        StdOut.println(a + " * (" + s[0] + ") + " + b + " * (" + s[1] + ") + " + c + " * (" + s[2] + ") = " + d);
        StdOut.println("[Checking: LHS is " + (a*s[0] + b*s[1] + c*s[2]) + "]");
    }
}