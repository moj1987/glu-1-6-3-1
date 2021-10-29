import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TimeExercisesTest {

    @Test
    @DisplayName("isBirthdayToday _ today's date _ true")
    void isBirthdayToday_todayDate_true() {
        LocalDate today = LocalDate.now();
        TimeExercises timeExercises = new TimeExercises();

        assertTrue(timeExercises.isBirthdayToday(today));
    }

    @Test
    @DisplayName("isBirthdayToday _ yesterday's date _ false")
    void isBirthdayToday_yesterday_false() {
        LocalDate today = LocalDate.now().minusDays(1);
        TimeExercises timeExercises = new TimeExercises();

        assertFalse(timeExercises.isBirthdayToday(today));
    }

    @Test
    @DisplayName("isBirthdayToday _ tomorrow's date _ false")
    void isBirthdayToday_tomorrow_false() {
        LocalDate today = LocalDate.now().plusDays(1);
        TimeExercises timeExercises = new TimeExercises();

        assertFalse(timeExercises.isBirthdayToday(today));
    }


    @Test
    @DisplayName("isCreditCardExpired _ current month and year _ false")
    void isCreditCardExpired_currentMonthAndYear_false() {
        YearMonth currentYearMonth = YearMonth.now();
        TimeExercises timeExercises = new TimeExercises();

        assertFalse(timeExercises.isCreditCardExpired(currentYearMonth));
    }

    @Test
    @DisplayName("isCreditCardExpired _ last month _ true")
    void isCreditCardExpired_lastMonthAndCurrentYear_true() {
        YearMonth currentYearMonth = YearMonth.now().minusMonths(1);
        TimeExercises timeExercises = new TimeExercises();

        assertTrue(timeExercises.isCreditCardExpired(currentYearMonth));
    }

    @Test
    @DisplayName("isCreditCardExpired _ next month _ false")
    void isCreditCardExpired_nextMonthAndCurrentYear_false() {
        YearMonth currentYearMonth = YearMonth.now().plusMonths(1);
        TimeExercises timeExercises = new TimeExercises();

        assertFalse(timeExercises.isCreditCardExpired(currentYearMonth));
    }

    @Test
    @DisplayName("isCreditCardExpired _ current month of last year _ true")
    void isCreditCardExpired_currentMonthAndLastYear_true() {
        YearMonth currentYearMonth = YearMonth.now().minusYears(1);
        TimeExercises timeExercises = new TimeExercises();

        assertTrue(timeExercises.isCreditCardExpired(currentYearMonth));
    }

    @Test
    @DisplayName("isCreditCardExpired _ current month and next year _ false")
    void isCreditCardExpired_currentMonthAndNextYear_false() {
        YearMonth currentYearMonth = YearMonth.now().plusYears(1);
        TimeExercises timeExercises = new TimeExercises();

        assertFalse(timeExercises.isCreditCardExpired(currentYearMonth));
    }

    @Test
    @DisplayName("order list of today, tomorrow, and yesterday _ list of the days _ ordered list of days ")
    void orderDatesAscending_listOfTodayTomorrowYesterday_listOfYesterdayTodayTomorrow() {
        ArrayList<LocalDate> dateArrayListInput = new ArrayList<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().minusDays(1)));
        TimeExercises timeExercises = new TimeExercises();

        ArrayList<LocalDate> expected = new ArrayList<>(Arrays.asList(LocalDate.now().minusDays(1), LocalDate.now(), LocalDate.now().plusDays(1)));

        assertEquals(expected, timeExercises.orderDatesAscending(dateArrayListInput));
    }

    @Test
    @DisplayName("order list of today, next year today, and last year today _ list of the days _ ordered list of days ")
    void orderDatesAscending_listOfTodayLastYearNextYear_listOfLastYearTodayNextYear() {
        ArrayList<LocalDate> dateArrayListInput = new ArrayList<>(Arrays.asList(LocalDate.now(), LocalDate.now().plusYears(1), LocalDate.now().minusYears(1)));
        TimeExercises timeExercises = new TimeExercises();

        ArrayList<LocalDate> expected = new ArrayList<>(Arrays.asList(LocalDate.now().minusYears(1), LocalDate.now(), LocalDate.now().plusYears(1)));

        assertEquals(expected, timeExercises.orderDatesAscending(dateArrayListInput));
    }


    @Test
    @DisplayName("getDaysBetweenTwoDates _ today, and yesterday _ 1")
    void getDaysBetweenTwoDates_todayYesterday_1() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 1;

        assertEquals(expected, timeExercises.getDaysBetweenTwoDates(today, yesterday));
    }

    @Test
    @DisplayName("getDaysBetweenTwoDates _ today, and last year today _ 365")
    void getDaysBetweenTwoDates_todayLastYearToday_365() {
        LocalDate today = LocalDate.now();
        LocalDate lastYearToday = LocalDate.now().minusYears(1);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 365;

        assertEquals(expected, timeExercises.getDaysBetweenTwoDates(today, lastYearToday));
    }

    @Test
    @DisplayName("getDaysBetweenTwoDates _ today, and next week _ 7")
    void getDaysBetweenTwoDates_todayNextWeek_7() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 7;

        assertEquals(expected, timeExercises.getDaysBetweenTwoDates(today, nextWeek));
    }

    @Test
    @DisplayName("getDaysBetweenTwoDates _ Feb 1st and March 1st _ 28")
    void getDaysBetweenTwoDates_1Feb2021And1March2021_28() {
        LocalDate febFirst = LocalDate.of(2021, 02, 01);
        LocalDate marchFirst = LocalDate.of(2021, 03, 01);
        TimeExercises timeExercises = new TimeExercises();

        long expected = 28;

        assertEquals(expected, timeExercises.getDaysBetweenTwoDates(marchFirst, febFirst));
    }


    @Test
    @DisplayName("getWeeksBetweenTwoDates _ now And Next Week _ 1")
    void getWeeksBetweenTwoDates_nowAndNextWeek_1() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 1;

        assertEquals(expected, timeExercises.getWeeksBetweenTwoDates(today, nextWeek));

    }

    @Test
    @DisplayName("getWeeksBetweenTwoDates _ now And Next Year Today _ 52")
    void getWeeksBetweenTwoDates_nowAndNextYearToday_52() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = LocalDate.now().plusYears(1);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 52;

        assertEquals(expected, timeExercises.getWeeksBetweenTwoDates(today, nextWeek));
    }

    @Test
    @DisplayName("getWeeksBetweenTwoDates _ 27 Oct 2021 And 11 Nov 2021 _ 2")
    void getWeeksBetweenTwoDates_27Oct2021And11Nov2021_2() {
        LocalDate twentySeventhOct2021 = LocalDate.of(2021, 10, 27);
        LocalDate elevenNov2021 = LocalDate.of(2021, 11, 11);

        TimeExercises timeExercises = new TimeExercises();

        long expected = 2;

        assertEquals(expected, timeExercises.getWeeksBetweenTwoDates(elevenNov2021, twentySeventhOct2021));
    }


    @Test
    @DisplayName("formatDate _ 28 Oct 2021 _ formatted(28-10-2021)")
    void formatDate_28Oct2021_formatted() {
        LocalDate date = LocalDate.of(2021,10,28);

        TimeExercises timeExercises = new TimeExercises();

        String expected = "28-10-2021";

        assertEquals(expected, timeExercises.formatDateToDdMmYyyy(date));
    }

    @Test
    @DisplayName("formatDate _ 01 Jan 1900 _ formatted(01-01-1900)")
    void formatDate_1Jan1900_formatted() {
        LocalDate date = LocalDate.of(1900,01,01);

        TimeExercises timeExercises = new TimeExercises();

        String expected = "01-01-1900";

        assertEquals(expected, timeExercises.formatDateToDdMmYyyy(date));
    }

    @Test
    @DisplayName("formatDate _ 28 Feb 2001 _ formatted(28-02-2001)")
    void formatDate_28Feb2001_formatted() {
        LocalDate date = LocalDate.of(2001,02,28);

        TimeExercises timeExercises = new TimeExercises();

        String expected = "28-02-2001";

        assertEquals(expected, timeExercises.formatDateToDdMmYyyy(date));
    }

    @Test
    void getZoneOffsetUTC_Tehran_plus3h30min() {
        String zoneId = Constants.TEHRAN_ZONE;

        TimeExercises timeExercises = new TimeExercises();

        String expected = "+03:30";

        assertEquals(expected, timeExercises.getZoneOffsetUTC(zoneId).toString());
    }

    @Test
    void getZoneOffsetUTC_NewYork_minus5h() {
        String zoneId = Constants.NewYork_ZONE;

        TimeExercises timeExercises = new TimeExercises();

        //Daylight saving has not hit yet
        String expected = "-04:00";

        assertEquals(expected, timeExercises.getZoneOffsetUTC(zoneId).toString());
    }
}