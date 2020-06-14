public class Primo
{
    public static int primo(int n)
    {
        if (n == 1) return 1;
        else {
            int i;
            int cont = 1;
            for (i = 3; cont != n; i++){
                boolean primo = true;
                for (int j = 2; j < i && primo; j++){
                    if (i%j == 0) primo = false;
                }
                if (primo) cont++;
            }
            return i - 1;
        }
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdOut.println("O n-ésimo (n = " + n + ") número primo é:     " + primo(n));
    }
}