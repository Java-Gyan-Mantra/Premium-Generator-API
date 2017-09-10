package com.health.insurance.premium.api.util;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.health.insurance.premium.api.common.Constants;

@Component
public class HealthUtil {
	private static Map<String, Integer> map = new TreeMap<>();

	static {
		map.put("18-25", 10);
		map.put("25-30", 10);
		map.put("30-35", 10);
		map.put("35-40", 10);
	}

	public double calculatePoint(int enterAge) {
		double amount = Constants.MIN_PREMIUM_AMOUNT;
		int startAge = 0;
		int endAge = 0;
		double perc = 0;
		for (String age : map.keySet()) {
			startAge = splitAgeLimit(age)[0];
			endAge = splitAgeLimit(age)[1];
			if ((enterAge >= startAge && enterAge <= endAge)
					|| (enterAge >= startAge && enterAge >= endAge)) {
				perc = (double) map.get(age) / 100;
				amount = amount + (amount * perc);
			}
		}
		return amount;
	}

	private static int[] splitAgeLimit(String age) {
		String[] s = age.split("-");
		return new int[] { Integer.valueOf(s[0]), Integer.valueOf(s[1]) };
	}
}
