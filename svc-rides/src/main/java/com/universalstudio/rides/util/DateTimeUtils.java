package com.universalstudio.rides.util;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

public class DateTimeUtils {

	public static String formateDateTime(Time time) {
		long now = System.currentTimeMillis();
		Time current = new Time(now);
		LocalTime from = current.toLocalTime();
		LocalTime to = time.toLocalTime();
		Duration d = Duration.between(from, to);
		return d.toMinutes() + "min";
	}

}
