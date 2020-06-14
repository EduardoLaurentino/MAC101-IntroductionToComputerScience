/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Variante do Creative Ex. 2.3.33 (Recursive tree)
 * Data: 20/05/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class TreeDeLuxe {

    public static void tree(int n, double x, double y, double a, double branchRadius, double branchRatio, double bendAngle, double branchAngle) {

        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;
        StdDraw.setPenRadius(0.001 * Math.pow(n, 1.2));
        StdDraw.line(x, y, cx, cy);
        if (n == 0) return;

        tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio, branchRatio, bendAngle, branchAngle);
        tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio, branchRatio, bendAngle, branchAngle);
        tree(n-1, cx, cy, a + bendAngle,               branchRadius * (1 - branchRatio), branchRatio, bendAngle, branchAngle);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        double branchRadius = Double.parseDouble(args[2]);
        int angleBend = Integer.parseInt(args[3]);
        int angleBranch = Integer.parseInt(args[4]);
        double branchRatio = Double.parseDouble(args[5]);

        StdDraw.enableDoubleBuffering();
        tree(n, 0.5, 0, Math.toRadians(a), branchRadius, branchRatio, Math.toRadians(angleBend), Math.toRadians(angleBranch));
        StdDraw.show();
        StdDraw.save("tree-" + n + "-" + a + "-" + branchRadius + "-" + angleBend + "-" + angleBranch + "-" + branchRatio + ".jpg");
    }
}
