public class ABPerms
{

    public static void funcao(String prefix, String s, int n, int t)
    {
        if (s.length() == 1 || prefix.length() == t){
            StdOut.println(prefix + s);
            return;
        }


        for (int i = 0; i < (s.length() - 1); i++){
            char a = s.charAt(i);
            for (int j = 0; j < (s.length() - 1); j++) {
                if (j != i){
                    char b = s.charAt(j);
                    if (a < b){
                        n++;
                        String temp = prefix + s.charAt(0);
                        funcao(temp, s.substring(1), n, t);
                    }
                    else {
                        String temp = "" + s.charAt(0);
                        funcao(temp, s.substring(1), n, t);
                    }
                }
            }
        }
    }

    public static String letras(int n)
    {
        char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        String s = "";
        for (int i = 0; i < n; i ++) s += alfabeto[i];

        return s;
    }


    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        ///int b = Integer.parseInt(args[2]);

        funcao("", letras(n), 0, a);

    }
}