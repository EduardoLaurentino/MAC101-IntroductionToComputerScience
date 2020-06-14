public class Permutacao{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int r;

        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            r = (int) (Math.random() * (N));
            a[i] = r;
        }

        System.out.print("a = {");

        for (int j = 0; j < N; j++) {
            if (j != (N-1)) System.out.print(a[j] + ", ");
            else System.out.println(a[j] + "}");
        }
    }
}