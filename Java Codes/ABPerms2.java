public class ABPerms2
{

    public static void funcao(String prefix, String s, int n, int t)
    {
        if (s.length() == 1){
            StdOut.println(prefix + s);
            StdOut.println("prefix = " + prefix + "            s = " + s);
            StdOut.println("=====");
            return;
        }

        for(int i = 0; i < s.length(); i++){
            StdOut.println("s = " + s);
            StdOut.println("s[i] = s[" + i + "] = " + s.charAt(i));
            for(int j = 0; j < s.length(); j++){
                StdOut.println("  s[j] = s[" + j + "] = " + s.charAt(j));
                if (j != i){
                    StdOut.println("    i != j");
                    if (s.charAt(i) < s.charAt(j)){
                        StdOut.println("      s[i] < s[j]");
                        n++;
                        String s2 = s.substring(1);
                        StdOut.println("      prefix = " + prefix + "            s = " + s);
                        StdOut.println("      prefix = " + prefix  + s.charAt(0) + "            s = " + s2);
                        funcao(prefix + s.charAt(0), s2, n, t);
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