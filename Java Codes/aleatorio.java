public class aleatorio{
    public static void main(String[] args){
        int r = 0;

        while (r < 4) r = (int) (Math.random() * 11);

        System.out.println(r);
    }
}