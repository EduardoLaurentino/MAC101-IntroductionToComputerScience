/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Variante final do Web Ex. 2.1.5 (Voting machines)
 * Data: 20/06/2017

        Baseado em: PercolationPlot.java
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/


public class VotingPlot {

    // recursive curve plotting
    public static void curve(int n, double x0, double y0, double x1, double y1, double a, int trials) {
        double gap = 0.01;
        double err = 0.0025;
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = VotingMachine2.prob(n, a, xm, trials);
        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(n, x0, y0, xm, fxm, a, trials);
        StdDraw.filledCircle(xm, fxm, 0.005);
        curve(n, xm, fxm, x1, y1, a, trials);
    }

    public static void main(String[] args) {
        StdDraw.setScale(-0.05, 1.05);
        int n = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        int T = Integer.parseInt(args[2]);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0.5, -1.0, 0.5, 2.0);
        StdDraw.line(-1.0, 0.03, 2.0, 0.03);

        StdDraw.setPenColor(StdDraw.BLACK);
        curve(n, 0.0, 0.0, 1.0, 1.0, a, T);
    }
}