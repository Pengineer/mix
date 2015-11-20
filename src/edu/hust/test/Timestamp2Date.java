package edu.hust.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Timestamp2Date {
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		Date d = (Date) ts;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		String str = sdf.format(d);
		
		System.out.println(str);
	}
}
