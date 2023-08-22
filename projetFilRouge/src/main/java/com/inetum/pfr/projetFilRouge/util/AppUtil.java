package com.inetum.pfr.projetFilRouge.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AppUtil {

	public static Date ajouterJours(Date date, Integer jours) {
		LocalDate localDate = asLocalDate(date);
		localDate = localDate.plusDays(jours);
		return asDate(localDate);

	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

	}

}
