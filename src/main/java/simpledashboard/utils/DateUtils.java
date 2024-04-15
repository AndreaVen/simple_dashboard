package simpledashboard.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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


}
