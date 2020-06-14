public class PermutaMesmo{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int r;
        boolean pode = true;

        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            r = (int) (Math.random() * (N));
            for (int x = 0; pode && x < i; x++){
                if (a[x] == r) pode = false;
            }
            if (pode) a[i] = r;
            else i--;
            pode = true;
        }

        System.out.print("a = {");

        for (int j = 0; j < N; j++) {
            if (j != (N-1)) System.out.print(a[j] + ", ");
            else System.out.println(a[j] + "}");
        }
    }
}