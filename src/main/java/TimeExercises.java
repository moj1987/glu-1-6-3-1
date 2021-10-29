import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class TimeExercises {

    boolean isBirthdayToday(LocalDate birthDate) {
        LocalDate today = LocalDate.now();

        return today.equals(birthDate);
    }

    boolean isCreditCardExpired(YearMonth expiryYearMonth) {
        YearMonth currentYearMonth = YearMonth.now();

        return currentYearMonth.isAfter(expiryYearMonth);
    }

    ArrayList<LocalDate> orderDatesAscending(ArrayList<LocalDate> dates) {
        Collections.sort(dates);

        return dates;
    }

    long getDaysBetweenTwoDates(LocalDate firstDate, LocalDate secondDate) {
        long days = ChronoUnit.DAYS.between(firstDate, secondDate);

        return Math.abs(days);
    }

    long getWeeksBetweenTwoDates(LocalDate firstDate, LocalDate secondDate) {
        long weeks = ChronoUnit.WEEKS.between(firstDate, secondDate);

        return Math.abs(weeks);
    }

    String formatDateToDdMmYyyy(LocalDate localDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.DD_MM_YYYY_DATE_FORMAT);

        return localDate.format(format);
    }

    ZoneOffset getZoneOffsetUTC(String zone) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of(zone);
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(currentDateTime);

        return zoneOffset;
    }
}
