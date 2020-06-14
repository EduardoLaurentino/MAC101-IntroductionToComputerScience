public class WeekdayMonthday2 {

    public static void main(String[] args) {
        int d = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        boolean leapYear;
            if (y % 400 == 0) leapYear = true;
            else if (y % 100 == 0) leapYear = false;
            else leapYear = y % 4 == 0;

        int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (d + 1 <= DAYS[m] || d == 28 && leapYear) d++;
        else if (m < 12) { d = 1; m++; }
        else { d = 1; m = 1; y++; }

        System.out.println(d + "/" + m + "/" + y);
    }

}