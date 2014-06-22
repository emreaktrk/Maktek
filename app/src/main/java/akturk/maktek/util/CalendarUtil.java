package akturk.maktek.util;


import java.util.Calendar;

public class CalendarUtil {
    private static Calendar mCalendarBegin;
    private static Calendar mCalendarEnd;

    public static Calendar getBeginTime() {
        if (mCalendarBegin == null) {
            mCalendarBegin = Calendar.getInstance();
            mCalendarBegin.set(2014, Calendar.JULY, 14, 9, 00);
        }

        return mCalendarBegin;
    }

    public static Calendar getEndTime() {
        if (mCalendarEnd == null) {
            mCalendarEnd = Calendar.getInstance();
            mCalendarEnd.set(2014, Calendar.JULY, 19, 18, 0);
        }

        return mCalendarEnd;
    }


}
