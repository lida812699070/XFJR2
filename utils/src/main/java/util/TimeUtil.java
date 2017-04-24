package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 */
public class TimeUtil {
	public static final long MILLIS_OF_SECOND = 1000L;
	public static final long MILLIS_OF_MINUTE = 60 * MILLIS_OF_SECOND;
	public static final long MILLIS_OF_HOUR = 60 * MILLIS_OF_MINUTE;
	public static final long MILLIS_OF_DAY = 24 * MILLIS_OF_HOUR;
	public static final long MILLIS_OF_WEEK = 7 * MILLIS_OF_DAY;
	public static final long ROUGH_MILLIS_OF_MONTH = 30 * MILLIS_OF_DAY;

	/**
	 * 通过long获得日期格式yyyy-MM-dd HH:mm:ss
	 *
	 * @param time
	 * @return
	 */
	public static String getStrTime(String time) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(time) * 1000);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		return sf.format(c.getTime());
	}

	public static String getStrTimeYMD(String time) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(time) * 1000);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		return sf.format(c.getTime());
	}

	public static String getStrTimeYG(String time) {
		if (StrUtils.isEmpty(time)){
			return "";
		}
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(time) * 1000);
		SimpleDateFormat sf = new SimpleDateFormat("MM-dd,HH:mm",Locale.getDefault());
		return sf.format(c.getTime());
	}

	public static String getCurrentTime(long time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss",Locale.getDefault());
		return sf.format(time);
	}

	public static String getDateTime(String time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		try {
			return sfd.format(sf.parse(time));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取一个毫秒数对应的天数的整数值
	 */
	public static int getDayCount(long millis) {
		return (int) ((millis + MILLIS_OF_HOUR * 8) / MILLIS_OF_DAY) + 1;
	}

	/**
	 * 获取当前时间毫秒数对应的天数的整数值
	 */
	public static int getTodayDayCount() {
		return getDayCount(System.currentTimeMillis());
	}

	/**
	 * 获取时间的初略描述
	 */
	public static String getRoughTimeText(Long millisTime) {
		long millis = System.currentTimeMillis() - NumberUtils.valueOf(millisTime);
		if (millis < MILLIS_OF_MINUTE) {
			return "刚刚";
		}
		StringBuilder sb = new StringBuilder();
		if (millis < MILLIS_OF_HOUR) {
			sb.append((int) (millis / MILLIS_OF_MINUTE)).append("分钟");
		} else if (millis < MILLIS_OF_DAY) {
			sb.append((int) (millis / MILLIS_OF_HOUR)).append("小时");
		} else if (millis < MILLIS_OF_WEEK) {
			sb.append((int) (millis / MILLIS_OF_DAY)).append("天");
		} else if (millis < ROUGH_MILLIS_OF_MONTH) {
			sb.append((int) (millis / MILLIS_OF_WEEK)).append("周");
		} else {
			sb.append((int) (millis / ROUGH_MILLIS_OF_MONTH)).append("月");
		}
		sb.append("前");
		return sb.toString();
	}

	/**
	 * 获取毫秒的时间描述如：1天23小时15分4秒
	 */
	public static String formatMilliseconds(long millis) {
		StringBuilder sb = new StringBuilder();
		if (millis < 1000) {
			sb.append(millis).append("毫秒");
		} else if (millis < MILLIS_OF_MINUTE) {
			sb.append((int) (millis / 1000)).append("秒");
			if (millis % 1000 != 0) {
				sb.append(formatMilliseconds(millis % 1000));
			}
		} else if (millis < MILLIS_OF_HOUR) {
			sb.append((int) (millis / MILLIS_OF_MINUTE)).append("分");
			if (millis % MILLIS_OF_MINUTE != 0) {
				sb.append(formatMilliseconds(millis % MILLIS_OF_MINUTE));
			}
		} else if (millis < MILLIS_OF_DAY) {
			sb.append((int) (millis / MILLIS_OF_HOUR)).append("小时");
			if (millis % MILLIS_OF_HOUR != 0) {
				sb.append(formatMilliseconds(millis % MILLIS_OF_HOUR));
			}
		} else if (millis < MILLIS_OF_WEEK) {
			sb.append((int) (millis / MILLIS_OF_DAY)).append("天");
			if (millis % MILLIS_OF_DAY != 0) {
				sb.append(formatMilliseconds(millis % MILLIS_OF_DAY));
			}
		} else if (millis < ROUGH_MILLIS_OF_MONTH) {
			sb.append((int) (millis / MILLIS_OF_WEEK)).append("周");
			if (millis % MILLIS_OF_WEEK != 0) {
				sb.append(formatMilliseconds(millis % MILLIS_OF_WEEK));
			}
		} else {
			sb.append((int) (millis / ROUGH_MILLIS_OF_MONTH)).append("月");
			if (millis % ROUGH_MILLIS_OF_MONTH != 0) {
				sb.append(formatMilliseconds(millis % ROUGH_MILLIS_OF_MONTH));
			}
		}
		return sb.toString();
	}

	/**
	 * 获取距离指定时间指定毫秒数的时间
	 */
	public static Date getNewDate(Date fromDate, long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(fromDate.getTime() + millis);
		return calendar.getTime();
	}

	/**
	 * 获取当前月的格式化字符串如：201309
	 */
	public static String getCurrentMonthCode() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM",Locale.getDefault());
		return simpleDateFormat.format(Calendar.getInstance().getTime());
	}

	/**
	 * 获取当前月的格式化字符串如：201309
	 */
	public static String getCurrentDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
		return simpleDateFormat.format(Calendar.getInstance().getTime());
	}

	/**
	 * 获取上n个月的格式化字符串如：201309
	 */
	public static String getLastMonthCode(int n) {
		if (n > 11) {
			throw new IllegalArgumentException("n must less than 12");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM",Locale.getDefault());
		Calendar calendar = Calendar.getInstance();
		calendar.get(Calendar.YEAR);
		//Calendar中月份从0开始
		int year = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int month = 0;
		int x = currentMonth - n;
		if (x >= 0) {
			month = x;
		} else {
			month = x + 12;
			year = year - 1;
		}
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(year, month, 15, 0, 0, 0);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 格式化时间
	 *
	 * @param timeMillis 时间毫秒数
	 * @param pattern    时间格式字符串 如：yyyy-MM-dd HH:mm:ss
	 * @return 指定格式的时间字符串
	 */
	public static String formatTime(Long timeMillis, String pattern) {
		if (timeMillis == null) timeMillis = 0l;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMillis);
		return formatTime(calendar.getTime(), pattern);
	}

	/**
	 * 格式化时间
	 *
	 * @param time    日期
	 * @param pattern 时间格式字符串 如：yyyy-MM-dd HH:mm:ss
	 * @return 指定格式的时间字符串
	 */
	public static String formatTime(Date time, String pattern) {
		if (time != null && pattern != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,Locale.getDefault());
			return simpleDateFormat.format(time);
		}
		return "";
	}

	/**
	 * @param times
	 * @return
	 */
	public static String getTime(long times) {
		if (times != 0) {
			long time = times * 1000;
			Timestamp ts = new Timestamp(time);
			String tsStr = "";
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
			tsStr = sdf.format(ts);
			return tsStr;
		} else {
			return "";
		}
	}

	/**
	 * 获取当前时间
	 */
	public static Date getTime() {
		return new Date();
	}

	/**
	 * 转换日期字符串为日期对象
	 *
	 * @param timeText 日期字符串
	 * @param pattern  日期格式（如yyyy-MM-dd HH:mm:ss）
	 * @return 成功返回日期对象，失败返回null。
	 */
	public static Date parseDate(String timeText, String pattern) {
		try {
			return new SimpleDateFormat(pattern,Locale.getDefault()).parse(timeText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换日期字符串为时间毫秒数
	 *
	 * @param timeText 日期字符串
	 * @param pattern  日期格式（如yyyy-MM-dd HH:mm:ss）
	 * @return 成功返回时间毫秒数，失败返回null。
	 */
	public static Long parseTime(String timeText, String pattern) {
		Date date = parseDate(timeText, pattern);
		if (date != null) {
			return date.getTime();
		}
		return null;
	}

	/**
	 * 获取一个日期的“日”
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取一个日期的当月的天数
	 */
	public static int getDayCountOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取天时分秒
	 * @param
	 * @param type
	 * @return
	 */
	public static int getLongTimeHMS(long closeTime,String type) {
		int day = (int) Math.floor(closeTime / (24*60*60));
		int hour = (int) Math.floor(closeTime / (60*60)) - day*24;
		int minute = (int) Math.floor(closeTime / 60) - day*24*60 - hour*60;
		int second = (int) Math.floor(closeTime) - day*24*60*60 - hour*60*60 - minute*60;
		if ("D".equals(type)) {
			return day;
		} else if ("H".equals(type)) {
			return hour;
		} else if ("M".equals(type)) {
			return minute;
		} else if ("S".equals(type)) {
			return second;
		}
		return 0;
	}

	/**
	 * 时间补0
	 * @param time
	 * @return
	 */
	public static String formatZeroTime(String time) {
		if (time.length()==1) {
			return "0"+time;
		} else {
			return time;
		}
	}

}

