public class ConnFourTeste{
    public static void main(String args[]){
        String elementos_matriz = args[0];
        int N = (int) Math.sqrt(args[0].length());
        int p = 0;
        char[][] matriz = new char[N][N];

        char caractere = elementos_matriz.charAt(p), novo_caractere = caractere, caractere_final = caractere;
        int tamanho = 1, resultado = 0;

        /*cria matriz com os elementos da entrada e imprime tabularmente*/
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = elementos_matriz.charAt(p++);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }


        //busca horizontal
        int resultadoH = 0;
        int linhaH = 0, colunaH = 0, colunaH_final = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    caractere = matriz[i][j];
                    tamanho = 1;
                    colunaH = j;
                }
                else {
                    novo_caractere = matriz[i][j];
                    if (novo_caractere == caractere) {
                        tamanho++;
                        if (tamanho >= resultadoH){
                            caractere_final = novo_caractere;
                            resultadoH = tamanho;
                            colunaH_final = colunaH;
                            linhaH = i;
                        }
                    }
                    else{
                        colunaH = j;
                        caractere = novo_caractere;
                        tamanho = 1;
                    }
                }
            }
        }

        System.out.println("caractere = " + caractere_final + "\ntamanho = " + resultadoH + " (i, j) = (" + linhaH + ", " + colunaH_final + ")");



        ///busca vertical

       int resultadoV = 0;
       int linhaV = 0, colunaV = 0, linhaV_final = 0;

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (i == 0){
                    caractere = matriz[i][j];
                    tamanho = 1;
                    linhaV = i;
                }
                else{
                    novo_caractere = matriz[i][j];
                    if (novo_caractere == caractere) {
                        tamanho++;
                        if (tamanho > resultadoV){
                            caractere_final = caractere;
                            resultadoV = tamanho;
                            linhaV_final = linhaV;
                            colunaV = j;
                        }
                    }
                    else{
                        linhaV = i;
                        caractere = novo_caractere;
                        tamanho = 1;
                    }
                }
            }
        }



        System.out.println("caractere = " + caractere_final + "\ntamanho = " + resultadoV + " (i, j) = (" + linhaV_final + ", " + colunaV + ")");

    }
}