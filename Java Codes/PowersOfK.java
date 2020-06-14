public class PowersOfK {
    public static void main(String[] args){
        long base = Long.parseLong(args[0]);
        long pot = base;
        long max = Long.MAX_VALUE;
        System.out.println(max);
        int i = 1;
        while (pot < max){
            System.out.println(pot);
            pot = base*pot;
        }
    }
}