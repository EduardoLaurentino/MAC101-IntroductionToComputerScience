/******************************************************************************
 *
 * MAC0110 - Introdução à Computação
 * Aluno: Eduardo Rocha Laurentino
 * Numero USP: 8988212
 * Tarefa: Web Ex. 1.3.26 (January 1)
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

public class SSCounter{
    public static void main(String[] args){
        int D = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        int ano = 1;
        int mes = 1, m = 1; ///mes é o mês [1, 12] e m é o dia no mês [1, 28] ou [1, 29] ou [1, 30] ou [1, 31]
        int data = 1; /// data é o dia na semana [1, 7]
        boolean bissexto = false;

        int sabados = 0, domingos = 0;

                            while (ano <= 400){ ///período do calendário gregoriano
                                if ((m == D) && (mes == M) && (data == 6)) sabados++;
                                if ((m == D) && (mes == M) && (data == 7)) domingos++;

                                data++;
                                m++;


                                //////VERIFICAÇÕES DE INTERVALO (1 <= data <= 7  e  1 <= m <= 31/28/29 a depender das circunstâncias)
                                if (data > 7) data = 1;

                                if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
                                                if (m > 31){
                                                    m = 1;
                                                    mes++;
                                                    if (mes > 12) {
                                                        mes = 1;
                                                        ano++;
                                                        ///Verifica se o novo ano é bissexto
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


            System.out.println("Saturday: " + sabados + "; " + "Sunday: " + domingos);

    }
}