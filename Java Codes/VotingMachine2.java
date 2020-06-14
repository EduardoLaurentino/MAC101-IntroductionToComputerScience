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


public class VotingMachine2
{

    public static double prob(int N, double a, double f, int T){
        int numeros_resultados_errados = 0;
        int vencedor;

        int votos_A = (int) (N*a);
        int votos_B = (int) (N - N*a);
        if (votos_A > votos_B) vencedor = 1;
        else vencedor = 0;

        for (int i = 1; i <= T; i++)
        {
            votos_A = (int) (N*a);
            votos_B = (int) (N - N*a);
            int vencedorDepois; ///1 = A, 0 = B

            int votos_ErradosA = 0;
            for (int j = 1; j <= N*a; j++)
            {
                if(Math.random() <= f) {votos_A--; votos_ErradosA++;}
            }

            int votos_ErradosB = 0;
            for (int k = 1; k <= (N - N*a); k++)
            {
                if(Math.random() <= f) {votos_B--; votos_ErradosB++;}
            }

            votos_A += votos_ErradosB;
            votos_B += votos_ErradosA;
            if (votos_A > votos_B) vencedorDepois = 1;
            else vencedorDepois = 0;

            if(vencedorDepois != vencedor) numeros_resultados_errados++;
        }

        double p = 1.0*numeros_resultados_errados/T;
        return p;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        double f = Double.parseDouble(args[2]);
        int T = Integer.parseInt(args[3]);

        double p = prob(N, a, f, T);
    }
}