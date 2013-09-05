package timeslot.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class DateUtil {
	public static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_HH_MM_SS = "HH:mm:ss";
	
	public static String formatDate(DateTime dt, String useFormat){
		 DateTimeFormatter fmt = DateTimeFormat.forPattern(useFormat);
		 return fmt.print(dt);
	}
	public static String formatDate(Calendar calDt, String useFormat){
		Date dt = calDt.getTime();
		SimpleDateFormat fmt= new SimpleDateFormat(useFormat);
		 return fmt.format(dt);
	}
	public static DateTime parseDateString(String dateStr){
		DateTimeParser[] parsers = { 
	        DateTimeFormat.forPattern( "yyyy-MM-dd" ).getParser(),
	        DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" ).getParser(),
	        DateTimeFormat.forPattern( "HH:mm:ss" ).getParser(),
	        DateTimeFormat.forPattern( "MM/dd/yy" ).getParser(),
	        DateTimeFormat.forPattern( "MM-dd-yyyy" ).getParser() };
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().append( null, parsers ).toFormatter();
		return formatter.parseDateTime(dateStr);
	}
	
    // List of all date formats that we want to parse.
    // Add your own format here.
    private static List<SimpleDateFormat>
            dateFormats = new ArrayList<SimpleDateFormat>() {
		private static final long serialVersionUID = 1L;
		{
            add(new SimpleDateFormat("M/dd/yyyy"));
            add(new SimpleDateFormat("dd.M.yyyy"));
            add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
            add(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"));
            add(new SimpleDateFormat("yyyy-mm-dd"));
            add(new SimpleDateFormat("hh:mm:ss"));
            add(new SimpleDateFormat("mm/dd/yyyy hh:mm:ss a"));
            add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
            add(new SimpleDateFormat("dd.MMM.yyyy"));
            add(new SimpleDateFormat("dd-MMM-yyyy"));
        }
    };

    /**
     * Convert String with various formats into java.util.Date
     *  '2013-02-15','09:00:00','09:50:00','B','',NULL,NULL,'2013-02-15 00:00:00'
     * @param input
     *            Date as a string
     * @return java.util.Date object if input string is parsed
     *          successfully else returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if(null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            try {
            	format.setLenient(false);
                date = format.parse(input);
            } catch (ParseException e) {
                //Shhh.. try other formats
            }
            if (date != null) {
                break;
            }
        }

        return date;
    }

}