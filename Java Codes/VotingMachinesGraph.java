/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Variante do Web Exercise 2.1.5 (Voting Machines)
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

public class VotingMachinesGraph
{

    public static int X_A(int N, double a, double f)
    {

        int votosA = (int) (N*a);
        int votosB = (int) (N - N*a);

            int votos_A = votosA;

            int votos_ErradosA = 0;
            for (int j = 1; j <= votosA; j++)
                if(StdRandom.bernoulli(f))
                    votos_A--;

            int votos_ErradosB = 0;
            for (int k = 1; k <= votosB; k++)
                if(StdRandom.bernoulli(f))
                    votos_ErradosB++;

            votos_A += votos_ErradosB;

        return votos_A;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        double f = Double.parseDouble(args[2]);
        int T = Integer.parseInt(args[3]);

        double [] XA = new double[T];
        int[] freq_XA = new int[N+1];

        for(int t = 0; t < T; t++){
            int n = X_A(N, a, f);
            freq_XA[n]++;
            XA[t] = (double) n;
        }

        double[] freq_XA_normalizada = new double[N+1];

        for(int i = 0; i <= N; i++)
            freq_XA_normalizada[i] = (double) freq_XA[i]/T;

        double max = StdStats.max(freq_XA_normalizada);
        StdDraw.setYscale(0, 1.2 * max);
        StdStats.plotBars(freq_XA_normalizada);


        double M = StdStats.mean(XA);
        double D = StdStats.stddev(XA);
        double[] phi  = new double[N+1];

        for (int i = 0; i <= N; i++) {
            phi[i] = Gaussian.pdf(i, M, D);
        }

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(N/2, 0, N/2, 0.2);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdStats.plotLines(phi);

        StdDraw.save("histogram-" + N + "-" + a + "-" + f + "-" + T + ".jpg");

        StdOut.println("M = " + M);
        StdOut.println("D = " + D);
    }
}