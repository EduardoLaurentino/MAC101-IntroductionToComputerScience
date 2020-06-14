public class Arrangements2
{
    public static void Perm(String[] s, int k)
    {
        int tam = s.length();
        if (k == tam) StdOut.println(s);
        else{
            for (int i = 0; i < tam; i++){
                swap()
            }
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    public static void main(String[] args)
    {
        String s = args[0];
        int tam = s.length();

        int[] h = new int['Z' - 'A' + 1]; // index 0 will be for 'A' etc
        char[] letras = new char[tam];

        for (int i = 0; i < tam; i++)
        {
            char c = s.charAt(i);
            letras[i] = c;
            if ('A' <= c && c <= 'Z')
                h[c - 'A']++; // "convert" 'A' to 0, 'B' to 1, etc
            if ('a' <= c && c <= 'z')
                h[c - 'a']++; // "convert" 'a' to 0, 'b' to 1, etc
        }

        String[] permutacoes = new String[100];
        int cont = 0;
        permutacoes = perm(letras, tam, permutacoes, cont);
        cont = permutacoes.length;
        for(int k = 0; k < cont; k++){
                StdOut.println(permutacoes[k]);
        }
    }
}