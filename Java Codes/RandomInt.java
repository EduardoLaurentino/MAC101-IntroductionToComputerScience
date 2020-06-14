//o método Math.random retorna um número double pseudo-aleatório no intervalo [0, 1)
// essa função recebe N e retorna um numero inteiro entre 0 e N-1

public class RandomInt{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        double r = Math.random();
        int t = (int) (r * N);

        System.out.println(t);
    }
}