public class LeapYear{
        public static void main(String[] args) {
                int year = Integer.parseInt(args[0]);
                boolean isLeapYear;

                //divisivel por 4
                isLeapYear = (year % 4 == 0);

                //divisivel por 4 e nao por 100
                isLeapYear = isLeapYear && (year % 100 != 0);

                //divisivel por 4 e nao por 100 a nao ser que seja por 400
                isLeapYear = isLeapYear || (year % 400 == 0);

                System.out.println(isLeapYear);
        }
}