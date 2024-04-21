package simpledashboard.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

    public static String convertDate(Date date) {
        final String NEW_FORMAT = "MM/dd-HH-mm";
        SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
        String newDateString = sdf.format(date);
        return newDateString;
    }


    public static String convertDate(Date date, String NEW_FORMAT) {
        SimpleDateFormat sdf = new SimpleDateFormat(NEW_FORMAT);
        String newDateString = sdf.format(date);
        return newDateString;
    }

    public static Date StringToDate(String miadata){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ITALIAN);
        TemporalAccessor parsedDate = formatter.parse(miadata);

        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.set(Calendar.YEAR, parsedDate.get(ChronoField.YEAR));
        cal.set(Calendar.MONTH, parsedDate.get(ChronoField.MONTH_OF_YEAR) - 1); // Month in Calendar is zero-based
        cal.set(Calendar.DAY_OF_MONTH, parsedDate.get(ChronoField.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, parsedDate.get(ChronoField.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, parsedDate.get(ChronoField.MINUTE_OF_HOUR));
        cal.set(Calendar.SECOND, parsedDate.get(ChronoField.SECOND_OF_MINUTE));


        Date date = Date.from( cal.toInstant());



        return date;
    }

    public static List<Map<Date, Float>> ensureConsistentKeys(List<Map<Date, Float>> listOfMaps) {

        // Create a set to hold the union of all keys from all maps
        Set<Date> allKeys = new HashSet<>();

        for (Map<Date, Float> map : listOfMaps) {
            allKeys.addAll(map.keySet());
        }

        // Iterate over all maps and add missing keys with null values
        for (Map<Date, Float> map : listOfMaps) {
            for (Date key : allKeys) {
                if (!map.containsKey(key)) {
                    map.put(key, (float) 0);
                }
            }
        }
        return listOfMaps;
    }


}
