/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.3.25 (Friday the 13th)
 * Data: 14/04/2017
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



public class WeekdayMonthday{
    public static void main(String[] args) {
        int D = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        if (D > 7 || D < 1 || M > 31 || M < 1) System.out.println("?"); ///verifica se não houve entrada estranha
        else{

        int d = D + 1, m = M + 1;
        int mes = 1;
        int ano = 1;
        boolean bissexto = false;
        int resposta_nova = 0, resposta = 0;

        if (d > 7) d = 1;
        if (m > 31) {
            m = 1;
            mes++;
        }

        while (ano <= 400) { ///período do calendário gregoriano

                while ((d != D || m != M)){ /// busca pelo encontro da data fornecida
                        d++;
                        m++;

                    ///VERIFICAÇÕES DE INTERVALO (1 <= d <= 7  e  1 <= m <= 31/28/29 a depender das circunstâncias)
                    if (d > 7) d = 1;
                    if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
                            if (m > 31){
                                m = 1;
                                mes++;
                                if (mes > 12) {
                                    mes = 1;
                                    ano++;
                                    ///verifica se o novo ano é bissexto
                                    if (ano % 400 == 0) bissexto = true;
                                    else if (ano % 100 == 0) bissexto = false;
                                    else bissexto = ano % 4 == 0;
                                }
                            }
                    } else if (mes != 2) {
                                if (m > 30){
                                    m = 1;
                                    mes++;
                                }
                        } if (mes == 2) {
                                if (bissexto){
                                    if (m > 29){
                                        m = 1;
                                        mes++;
                                    }
                                } else{
                                    if (m > 28){
                                        m = 1;
                                        mes++;
                                    }
                                }
                            }
                    ///FIM DAS VERIFICAÇÕES DE INTERVALO

                        resposta_nova++;
                    }

                ///garante que se obtém o maior período possível
                if (resposta_nova > resposta) resposta = resposta_nova;
                resposta_nova = 0;


                ///novo incremento (com respectiva verificação de intervalo) para entra no while novamente e
                ///verificar existência de possível novo período:
                d++;
                m++;

                if (d > 7) d = 1;
                    if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
                            if (m > 31){
                                m = 1;
                                mes++;
                                if (mes > 12) {
                                    mes = 1;
                                    ano++;
                                    if (ano % 400 == 0) bissexto = true;
                                    else if (ano % 100 == 0) bissexto = false;
                                    else bissexto = ano % 4 == 0;
                                }
                            }
                    } else if (mes != 2) {
                                if (m > 30){
                                    m = 1;
                                    mes++;
                                }
                        } if (mes == 2) {
                                if (bissexto){
                                    if (m > 29){
                                        m = 1;
                                        mes++;
                                    }
                                } else{
                                    if (m > 28){
                                        m = 1;
                                        mes++;
                                    }
                                }
                            }
            }

            System.out.println("Resposta: " + resposta);

            }
        }
}