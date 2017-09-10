package com.health.insurance.premium.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.insurance.premium.api.common.Constants;
import com.health.insurance.premium.api.dto.PremiumForm;
import com.health.insurance.premium.api.util.HealthUtil;

@Service
public class CalculatePremiumService {

	@Autowired
	private HealthUtil util;

	public double getPremiumAmount(PremiumForm form) {
		double amountToBePaid = 0;
		// condition based on age
		amountToBePaid = totalPercentByAgeLimit(form.getAge());
		// condition based on gender
		amountToBePaid = amountByGender(form.getGender(), amountToBePaid);
		// condition based on Health and Habits
		amountToBePaid = getCostForHealthStatus(form, amountToBePaid);
		return amountToBePaid;
	}

	private double totalPercentByAgeLimit(int age) {
		double amount = 0;
		amount = age <= 40 ? util.calculatePoint(age) : util
				.calculatePoint(age) + (util.calculatePoint(age) * 0.2);
		return amount;
	}

	private double amountByGender(String gender, double amount) {
		double amountByAge = 0;
		if (gender.equalsIgnoreCase(Constants.MALE)
				|| gender.equalsIgnoreCase(Constants.FEMALE)) {
			amountByAge = amount + (amount * 0.02);
		}
		return amountByAge;
	}

	private double getCostForHealthStatus(PremiumForm form, double amount) {
		if (form.getBloodPressure().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.01);
		}
		if (form.getBloodSugar().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.01);
		}
		if (form.getHypertension().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.01);
		}
		if (form.getOverWeight().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.01);
		}
		if (form.getAlcohol().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.03);
		}
		if (form.getDrugs().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.03);
		}
		if (form.getSmoking().equalsIgnoreCase(Constants.YES)) {
			amount = amount + (amount * 0.03);
		}
		if (form.getDailyExercise().equalsIgnoreCase(Constants.YES)) {
			amount = amount - (amount * 0.03);
		}
		return amount;
	}
}
