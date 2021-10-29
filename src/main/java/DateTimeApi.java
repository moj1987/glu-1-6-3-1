import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeApi {
    public static void main(String[] args) {

        LocalTime currentLocalTime = LocalTime.now();
        LocalDate currentLocalDate = LocalDate.now();
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        LocalDate mojBirthDate = getDate(Constants.MOJ_BIRTHDAY);

        printDateTime(currentLocalTime);

        printDayOfWeek(currentLocalDate);

        printDateTime(currentLocalDate);

        printDateTime(currentDateAndTime);

        LocalDateTime localDateTimeAWeekFromNow = addDaysToCurrentTime(Constants.SEVEN_DAYS_OF_WEEK);
        printDateTime(localDateTimeAWeekFromNow);

        printDateTime(Constants.PARIS_ZONE_ID);
        printDateTime(Constants.TEHRAN_ZONE_ID);
        printDateTime(Constants.SYDNEY_ZONE_ID);

        long differenceDateInDays = calculateDifferenceDateInDays(LocalDate.parse(Constants.WWII_START_DATE), currentLocalDate);
        System.out.println(differenceDateInDays);

        LocalDateTime currentDateTimePlusTwentySixHundredHours = addHoursToCurrentTime(Constants.TWENTY_SIX_HUNDRED_HOURS);
        printDateTime(currentDateTimePlusTwentySixHundredHours);

        DateTimeFormatter format = getFormat(Constants.DD_MM_YYYY_DATE_FORMAT);
        System.out.println(formatDate(mojBirthDate, format));

        printDayOfWeek(mojBirthDate);

        OffsetDateTime currentTimeOffsetByTwoHours = OffsetDateTime.of(currentLocalDate, currentLocalTime, Constants.ZONE_OFFSET_BY_TWO_HOURS);
        System.out.println(currentTimeOffsetByTwoHours);
    }





    static void printDayOfWeek(LocalDate localDate) {
        System.out.println(localDate.getDayOfWeek());
    }

    static void printDateTime(LocalTime localTime) {
        System.out.println(localTime);
    }

    static void printDateTime(LocalDate localDate) {
        System.out.println(localDate);
    }

    static void printDateTime(LocalDateTime localDateTime) {
        System.out.println(localDateTime);
    }

    static void printDateTime(ZoneId locationZoneId) {
        System.out.println(ZonedDateTime.now(locationZoneId));
    }

    static LocalDateTime addDaysToCurrentTime(long days) {
        return LocalDateTime.now().plusDays(days);
    }

    static long calculateDifferenceDateInDays(LocalDate initialDate, LocalDate finalDate) {
        return ChronoUnit.DAYS.between(initialDate, finalDate);
    }

    static LocalDateTime addHoursToCurrentTime(long hours) {
        return LocalDateTime.now().plusHours(hours);
    }

    static LocalDate getDate(String date) {
        return LocalDate.parse(date);
    }

    static DateTimeFormatter getFormat(String format) {
        return DateTimeFormatter.ofPattern(format);
    }

    static String formatDate(LocalDate localDate, DateTimeFormatter format) {
        return localDate.format(format);
    }

}
