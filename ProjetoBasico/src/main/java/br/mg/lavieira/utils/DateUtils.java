package br.mg.lavieira.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date getDateWithDifferenceDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	public static String formatedDate(Date date) {
		DateFormat formart = new SimpleDateFormat("dd/MM/YYYY");
		return formart.format(date);
	}

}
