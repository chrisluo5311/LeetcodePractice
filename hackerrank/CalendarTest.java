import java.util.*;
public class CalendarTest {
    public static void main(String[] args) {
        int year = 2015;
        int month = 8; // month start with 0, so 8(August) should be 7
        int day = 5;
        Calendar cal = Calendar.getInstance();
        String weekDay = "";
        cal.set(year, month-1, day);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        System.out.println(Calendar.MONDAY);
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                System.out.println("MONDAY");
                break;
            case Calendar.TUESDAY:
                System.out.println("TUESDAY");
                break;
            case Calendar.WEDNESDAY:
                System.out.println("WEDNESDAY");
                break;
            case Calendar.THURSDAY:
                System.out.println("THURSDAY");
                break;
            case Calendar.FRIDAY:
                System.out.println("FRIDAY");
                break;
            case Calendar.SATURDAY:
                System.out.println("SATURDAY");
                break;
            case Calendar.SUNDAY:
                System.out.println("SUNDAY");
                break;
        }
    }
}
