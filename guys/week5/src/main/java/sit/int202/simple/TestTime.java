package sit.int202.simple;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        // Initialize dates
        Date startedDate = new Date(0L); // 1 Jan 1970
        Date dateAfter1Minute = new Date(1_000L * 60);
        Date dateAfter1Day = new Date(1_000L * 60 * 60 * 24);
        Date specificMilliSeconds = new Date(1698491006409L);

        // Add one day to the specific millisecond
        Date nextDay = new Date(1698491006409L + 1_000L * 60 * 60 * 24);

        // Print the results
        System.out.println("Started Date: " + startedDate);
        System.out.println("Date after 1 minute: " + dateAfter1Minute);
        System.out.println("Date after 1 day: " + dateAfter1Day);
        System.out.println("Current system time in milliseconds: " + System.currentTimeMillis());
        System.out.println("Specific date in milliseconds: " + specificMilliSeconds);
        System.out.println("Next day: " + nextDay);
    }
}
