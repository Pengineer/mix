package edu.hust.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解决多线程下日期格式化异常问题
 * 
 * From Java API:
 * 期格式是不同步的。建议为每个线程创建独立的格式实例。如果多个线程同时访问一个格式，则它必须是外部同步的。
 * 
 * @author liangjian
 * @date 2016-01-12
 *
 */
public class DateTool {
	/**
	 * 按照指定格式将时间字符串转换成日期类型
	 * @param formatString 格式化字符串
	 * @param dateString 日期字符串
	 * @return
	 */
	public static Date parse(String formatString, String dateString) {
		try {
			return new SimpleDateFormat(formatString).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 按照指定格式将日期类型格式化成时间字符串
	 * @param formatString
	 * @param date
	 * @return
	 */
	public static String format(String formatString, Date date) {
		return new SimpleDateFormat(formatString).format(date).toString();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 获取线程安全的SimpleDateFormat
	 */
	private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
	public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
		SimpleDateFormat sdf = null;
		sdf = tl.get();
		if(sdf == null) {
			sdf = new SimpleDateFormat(datePattern);
			tl.set(sdf);
		}
		return sdf;
	}
}
