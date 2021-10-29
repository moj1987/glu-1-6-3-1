import java.time.ZoneId;
import java.time.ZoneOffset;

public class Utils {
    static final long SEVEN_DAYS_OF_WEEK = 7;
    static final long TWENTY_SIX_HUNDRED_HOURS = 2600;

    static final ZoneId PARIS_ZONE_ID = ZoneId.of("Europe/Paris");
    static final ZoneId TEHRAN_ZONE_ID = ZoneId.of("Asia/Tehran");
    // static final ZoneId BEIJING_ZONE_ID = ZoneId.of("Asia/Beijing");
    // static final ZoneId RIO_ZONE_ID = ZoneId.of("America/Rio de Janeiro");
    static final ZoneId SYDNEY_ZONE_ID = ZoneId.of("Australia/Sydney");
    static final ZoneId LONDON_ZONE_ID = ZoneId.of("Europe/London");

    static final String WWII_START_DATE = "1939-09-01";

    static final String YYYY_MM_DD_DATE_FORMAT = "yyyy/MM/dd";
    static final String DD_MM_YYYY_DATE_FORMAT = "dd-MM-yyyy";

    static final String MOJ_BIRTHDAY = "1987-06-12";

    static final ZoneOffset ZONE_OFFSET_BY_TWO_HOURS = ZoneOffset.ofHours(2);

}
