package com.jlkf.donglianrider.mvpprojectdemo.utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * description
 *
 * @author created by wuwang on 2016/5/20
 */
public class TimeUtils {

    private static TimeUtils instance;

    private TimeUtils() {

    }

    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay))
            return 0;
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }

    public static CharSequence getDate(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        long l = time.getTimeInMillis() - today.getTimeInMillis();
        int t = (int) (l / (24 * 60 * 60 * 1000));
        switch (t) {
            case 0:
                return "今天";
            case 1:
                return "明天";
            case -1:
                return "昨天";
            case 2:
                return "后天";
            case -2:
                return "前天";
            default:
                if (time.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
                    return DateFormat.format("MM-dd", timeStamp);
                } else {
                    return DateFormat.format("yyyy-MM-dd", timeStamp);
                }
        }
    }

    public static CharSequence getMonth(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        int t = today.get(Calendar.MONTH) - time.get(Calendar.MONTH);
        switch (t) {
            case 0:
                return "本月";
            case 1:
                return "上月";
            default:
                if (time.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
                    return DateFormat.format("MM-dd", timeStamp);
                } else {
                    return DateFormat.format("yyyy-MM-dd", timeStamp);
                }
        }
    }

    public static CharSequence getDateWithTime(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        long l = time.getTimeInMillis() - today.getTimeInMillis();
        int t = (int) (l / (24 * 60 * 60 * 1000));
        switch (t) {
            case 0:
                return "今天" + DateFormat.format("  HH:mm", timeStamp);
            case 1:
                return "明天" + DateFormat.format("  HH:mm", timeStamp);
            case -1:
                return "昨天" + DateFormat.format("  HH:mm", timeStamp);
            case 2:
                return "后天" + DateFormat.format("  HH:mm", timeStamp);
            case -2:
                return "前天" + DateFormat.format("  HH:mm", timeStamp);
            default:
                return DateFormat.format("yyyy-MM-dd HH:mm", timeStamp);
        }
    }


    public static CharSequence getDateWithTime2(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        long l = time.getTimeInMillis() - today.getTimeInMillis();
        int t = (int) (l / (24 * 60 * 60 * 1000));
        switch (t) {
            case 0:
                return "今天" + DateFormat.format("  HH:mm", timeStamp);
            case 1:
                return "明天" + DateFormat.format("  HH:mm", timeStamp);
            case -1:
                return "昨天" + DateFormat.format("  HH:mm", timeStamp);
            case 2:
                return "后天" + DateFormat.format("  HH:mm", timeStamp);
            case -2:
                return "前天" + DateFormat.format("  HH:mm", timeStamp);
            default:
                return DateFormat.format("yyyy年MM月dd日 HH:mm", timeStamp);
        }
    }

    /**
     * 转化时间输入时间与当前时间的间隔
     *
     * @param timestamp
     * @return
     */
    public static String converTime(long timestamp) {
        long currentSeconds = System.currentTimeMillis() / 1000;
        long timeGap = currentSeconds - timestamp / 1000;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > 7 * 24 * 60 * 60) {
            timeStr = (String) getAllDate(timestamp);
        } else if (timeGap > 24 * 60 * 60) {// 1天以上
            timeStr = timeGap / (24 * 60 * 60) + "天前";
        } else if (timeGap > 60 * 60) {// 1小时-24小时
            timeStr = timeGap / (60 * 60) + "小时前";
        } else if (timeGap > 60) {// 1分钟-59分钟
            timeStr = timeGap / 60 + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * 转化时间输入时间与当前时间的间隔
     *
     * @param timestamp
     * @return
     */
    public static String converTime2(long timestamp) {
        long currentSeconds = System.currentTimeMillis() / 1000;
        long timeGap = currentSeconds - timestamp / 1000;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > 7 * 24 * 60 * 60) {
            timeStr = (String) getAllDate3(timestamp);
        } else if (timeGap > 24 * 60 * 60) {// 1天以上
            timeStr = timeGap / (24 * 60 * 60) + "天前";
        } else if (timeGap > 60 * 60) {// 1小时-24小时
            timeStr = timeGap / (60 * 60) + "小时前";
        } else if (timeGap > 60) {// 1分钟-59分钟
            timeStr = timeGap / 60 + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    public static String converTime3(long timestamp) {
        long currentSeconds = System.currentTimeMillis() / 1000;
        long timeGap = currentSeconds - timestamp / 1000;// 与现在时间相差秒数
        String timeStr = null;
        if (timeGap > 365 * 24 * 60 * 60){
            timeStr = timeGap / (365 *24 * 60 * 60) + "年前";
        }else if (timeGap > 30 * 24 * 60 * 60){
            timeStr = timeGap / (30 *24 * 60 * 60) + "个月前";
        } else if (timeGap > 7 * 24 * 60 * 60) {
            timeStr = timeGap / (7 *24 * 60 * 60) + "周前";
        } else if (timeGap > 24 * 60 * 60) {// 1天以上
            timeStr = timeGap / (24 * 60 * 60) + "天前";
        } else if (timeGap > 60 * 60) {// 1小时-24小时
            timeStr = timeGap / (60 * 60) + "小时前";
        } else if (timeGap > 60) {// 1分钟-59分钟
            timeStr = timeGap / 60 + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    public static CharSequence getTime(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        return getDate(timeStamp) + " " + format.format(timeStamp);
    }

    public static CharSequence getTime2(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTime2sub(long timeStamp) {
        if (timeStamp==0) return "0";
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        int h = time.get(Calendar.HOUR_OF_DAY)+1;
        int m = time.get(Calendar.MINUTE);
        String hh = "";
        String mm = "";
        if (h < 10) {
            hh ="0"+ h + "";
        }else {
            hh = h + "";
        } if (m < 10) {
            mm ="0"+ m + "";
        }else {
            mm = m + "";
        }
        return hh+":"+mm;

    }

    public static CharSequence getTime3(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        return format.format(timeStamp);
    }

    public static CharSequence getTime4(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd", Locale.CHINA);
        return format.format(timeStamp);
    }

    public static CharSequence getTime5(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss", Locale.CHINA);
        return format.format(timeStamp);
    }

    public static CharSequence getTime6(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTime7(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM月", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTimeLastHour(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        time.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY)+1);
        return DateFormat.format("HH:mm", time);
    }

    public static CharSequence getTime(long timeStamp, String format) {
        SimpleDateFormat s = new SimpleDateFormat(format, Locale.CHINA);
        return s.format(timeStamp * 1000);
    }
    public static CharSequence getTimeM(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM", Locale.CHINA);
        return format.format(timeStamp);
    }

    public static CharSequence getTimeHH(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTimeYM(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTimeD(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("dd", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static CharSequence getTimeMD(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd", Locale.CHINA);
        return format.format(timeStamp);
    }
    public static int getTimeD2(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        int day=time.get(Calendar.DAY_OF_MONTH);
        return day;
    }
    public static CharSequence getTimeW(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        int weekday=time.get(Calendar.DAY_OF_WEEK);
        switch (weekday) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
                default:
                    return "周日";
        }
    }

    public static CharSequence getTimeW2(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        int weekday=time.get(Calendar.DAY_OF_WEEK);
        switch (weekday) {
            case 1:
                return "日";
            case 2:
                return "一";
            case 3:
                return "二";
            case 4:
                return "三";
            case 5:
                return "四";
            case 6:
                return "五";
            case 7:
                return "六";
            default:
                return "日";
        }
    }

    public static CharSequence getAllDate(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);

        return DateFormat.format("yyyy-MM-dd  HH:mm", timeStamp);

    }

    public static CharSequence getAllDate2(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);

        return DateFormat.format("yy-MM-dd", timeStamp);

    }

    public static CharSequence getAllDate3(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);

        return DateFormat.format("yyyy-MM-dd", timeStamp);

    }

    //获取错一天
    public static CharSequence getData1(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);

        return DateFormat.format("yyyy-MM-dd  HH:mm:ss", timeStamp);
    }

    public static CharSequence getCnDate3(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);

        return DateFormat.format("yyyy·MM·dd", timeStamp);
    }

    public static CharSequence getCnDate4(long timeStamp) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);

        return DateFormat.format("yyyy.MM.dd", timeStamp);
    }

    public static CharSequence getCnDate(long timeStamp) {
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeStamp);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);

        return DateFormat.format("yyyy年MM月dd日", timeStamp);
    }

    public static CharSequence getCnDate2(long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        return format.format(timeStamp);
    }

    /**
     * 获取本周的第一天
     *
     * @return
     */
    public static long getTimeOfWeekStart() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_WEEK, ca.getFirstDayOfWeek());
        return ca.getTimeInMillis();
    }

    /**
     * 获取本周的最后一天
     *
     * @return
     */
    public static long getTimeOfWeekEnd() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.clear(Calendar.MINUTE);
        ca.clear(Calendar.SECOND);
        ca.clear(Calendar.MILLISECOND);
        ca.set(Calendar.DAY_OF_WEEK, ca.getActualMaximum(Calendar.DAY_OF_WEEK));
        return ca.getTimeInMillis();
    }

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    public static String getCurrentTime(long timeMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDate2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    public static String timeToMsString(int seconds) {
        int m = seconds / 60;
        int s = seconds % 60;
        String ms = "";
        if (m < 10) {
            ms = "0" + m;
        } else
            ms = m + "";
        String ss = "";
        if (s < 10) {
            ss = "0" + s;
        } else
            ss = s + "";
        return ms + "'" + ss + "''";
    }

    public static String timeToHMSString(int time) {
        int h = time / 60 / 60;
        String hs = "";
        if (h < 10) {
            hs = "0" + h;
        } else
            hs = h + "";
        int m = time / 60;
        String ms = "";
        if (m < 10) {
            ms = "0" + m;
        } else
            ms = m + "";
        int s = time % 60;
        String ss = "";
        if (s < 10) {
            ss = "0" + s;
        } else
            ss = s + "";
        return hs + ":" + ms + ":" + ss;
    }

    /**
     * 判断是否为今天
     */
    public static boolean IsToday(long time) {
        String todayStr = getCurrentDate();
        String dayStr = getAllDate3(time).toString();
        if (todayStr.equals(dayStr))
            return true;
        return false;
    }

    public static boolean isThisWeek(String date) {
        if (date==null||date.equalsIgnoreCase(""))
            return false;
        String[] str = date.split("~");
        if (str.length < 1)
            return false;
        int val1 = Integer.parseInt(str[0].replace("-", ""));
        int val2 = Integer.parseInt(str[1].replace("-", ""));
        String s = getCurrentDate();
        int tag = Integer.parseInt(s.replace("-", ""));
        if (tag >= val1 && tag <= val2)
            return true;
        else
            return false;
    }

    /**
     * 计算2个日期相差多少年
     *
     * @return
     */
    public static int yearCompare(long fromDate) {
        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(System.currentTimeMillis());
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);


        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(fromDate);
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return today.get(Calendar.YEAR) - time.get(Calendar.YEAR);
    }

    public static int yearCompare(String fromDate) {
        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(System.currentTimeMillis());
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);


        Calendar time = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format1.parse(fromDate);
            time.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        return today.get(Calendar.YEAR) - time.get(Calendar.YEAR);
    }

    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime, String formatType)
            throws android.net.ParseException {
        Date date = null; // String类型转成date类型
        try {
            date = stringToDate(strTime, formatType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws android.net.ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        Date date = null; // 把String类型转换为Date类型
        try {
            String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
            date = stringToDate(sDateTime, formatType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws android.net.ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = null; // date类型转成String
        try {
            strTime = dateToString(date, formatType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strTime;
    }



    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static String dateToString(Date date, String pattern)
            throws Exception {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date stringToDate(String dateStr, String pattern)
            throws Exception {
        return new SimpleDateFormat(pattern).parse(dateStr);
    }
}
