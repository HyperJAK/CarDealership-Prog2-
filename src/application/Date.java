package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	public static String getDate() {
		String date;

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = dateFormat.format(Calendar.getInstance().getTime());

		return "Date of purchase: " + date;

	}
}
