/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 2.1.5 (Voting machines)
 * Data: 13/05/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE,
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class VotingMachinesDeluxe2
{

    public static int p(int N, double a, double f, int T, double erro)
    {

        int numeros_resultados_errados = 0;
        int numeros_resultados_erradosComErro = 0;
        int vencedor;
        int vendorComErro;
        int votos_A = (int) (N*a);
        int votos_B = (int) (N - N*a);
        int votos_AComErro = votos_A;
        int votos_BComErro = votos_B;
        if (votos_A > votos_B) vencedor = 1;
        else vencedor = 0;

        for (int i = 1; i <= T; i++)
        {
            votos_A = (int) (N*a);
            votos_B = (int) (N - N*a);
            votos_AComErro = votos_A;
            votos_BComErro = votos_B;
            int vencedorDepois; ///1 = A, 0 = B
            int vencedorDepoisComErro;

            int votos_ErradosA = 0;
            int votos_ErradosAComErro = 0;
            for (int j = 1; j <= N*a; j++)
            {
                double r = Math.random();
                if(r <= f) {votos_A--; votos_ErradosA++;}
                if (r <= (f+erro)) {votos_AComErro--; votos_ErradosAComErro++;}

            }

            int votos_ErradosB = 0;
            int votos_ErradosBComErro = 0;
            for (int k = 1; k <= (N - N*a); k++)
            {
                double s = Math.random();
                if(s <= f) {votos_B--; votos_ErradosB++;}
                if (s <= (f+erro)) {votos_BComErro--; votos_ErradosBComErro++;}
            }

            votos_A += votos_ErradosB;
            votos_B += votos_ErradosA;
            votos_AComErro += votos_ErradosBComErro;
            votos_BComErro += votos_ErradosAComErro;
            if (votos_A > votos_B) vencedorDepois = 1;
            else vencedorDepois = 0;
            if (votos_AComErro > votos_BComErro) vencedorDepoisComErro = 1;
            else vencedorDepoisComErro = 0;

            if(vencedorDepois != vencedor) numeros_resultados_errados++;
            if(vencedorDepoisComErro != vencedor) numeros_resultados_erradosComErro++;
        }

        double p = (double) numeros_resultados_errados/T;
        double pComErro = (double) numeros_resultados_erradosComErro/T;
        if (p <= 0.03 && pComErro > 0.03) {StdOut.println(p); return 0;}
        else if (p <= 0.03) {StdOut.println(p); return 1;}
        else {StdOut.println(p); return 2;}
    }


    public static double bissecciona(double inicio, double fim, int N, double a, int T)
    {
        double f = (inicio + fim)/2.0;
        double erro = 0.001;
        StdOut.print(f + "  ");
        int p = p(N, a, f, T, erro);
         ///StdOut.println("   " + p);

        if (p == 0) return f;
        else if (p == 1) return bissecciona(f, fim, N, a, T);
        else return bissecciona (inicio, f, N, a, T);
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        int T = Integer.parseInt(args[2]);

        double f = bissecciona(0, 1, N, a, T);

        StdOut.println(f);
    }
}