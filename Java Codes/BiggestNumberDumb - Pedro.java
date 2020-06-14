/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Pedro Henrique Barbosa de Almeida
 *  Numero USP: 10258793
 *  Tarefa: Web Exercise - 1.2.9 (Guess the biggest number)
 *  Data: 08/04/2017
 * 
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/
public class BiggestNumberDumb {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);

		int bigger;
		if (a < b)
			bigger = 1;
		else
			bigger = 0;

		int right = 0;
		for (int i = 0; i < T; i++) {
			int choice;
			int k = (int) Math.abs(Math.random() * 1000); // Gera um número
															// aleatório entre 0
															// e 1000

			// Escolher qual cartão revelar
			if (Math.random() < .5) { // Revela cartão A
				if (a > k) { // A é maior que o número aleatório, o palpite é
								// que A é o maior número.
					choice = 0;
				} else { // B é maior que o número aleatório, o palpite é que B
							// é o maior número.
					choice = 1;
				}
			} else { // Revela cartão B
				if (b > k) { // B é maior que o número aleatório, o palpite é
								// que B é o maior número.
					choice = 1;
				} else { // A é maior que o número aleatório, o palpite é que A
							// é o maior número.
					choice = 0;
				}
			}
			// Escolha correta?
			if (choice == bigger)
				right++;
		}
		// Estatística
		double f = (double) right / T;
		System.out.println("(A) [(B) / (C)]");
		System.out.println(right + " [" + f + "/" + (f - .5) + "]");
		System.out.println("\nLegenda:  \n(A)Acertos em todas as tentativas \n(B)Razão de acertos/tentativas \n(C)Aumento da razão de acertos/tentativas");

	}
}
