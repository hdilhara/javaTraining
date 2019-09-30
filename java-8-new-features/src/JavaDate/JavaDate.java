package JavaDate;

import java.time.*;

public class JavaDate {

    public static void main(String[] args) {

        Instant instant=Instant.now();
        System.out.println(instant);

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

        for (String s: ZoneId.getAvailableZoneIds()){
            System.out.println(s);
        }

        LocalDate l1=LocalDate.of(2019, Month.AUGUST,5);
        System.out.println(l1);

        LocalTime l2=LocalTime.of(12,45,55,555555555);
        System.out.println(l2);
    }
}
