package com.health.insurance.premium.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.insurance.premium.api.common.Constants;
import com.health.insurance.premium.api.dto.PremiumForm;
import com.health.insurance.premium.api.dto.PremiumResponse;
import com.health.insurance.premium.api.service.CalculatePremiumService;

@Controller
public class HealthInsurancePremiumController {
	@Autowired
	private CalculatePremiumService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/calculatePremium")
	public String calculateTotalPremium(
			@ModelAttribute("premiumForm") PremiumForm premiumForm, Model model) {
		double totalPremiumAmount = 0;
		PremiumResponse response = new PremiumResponse();
		try {
			logger.info("Input Request :" + premiumForm.toString());
			totalPremiumAmount = service.getPremiumAmount(premiumForm);
			response.setAmount(totalPremiumAmount);
			response.setName(premiumForm.getName());
		} catch (Exception e) {
			model.addAttribute("errorMessage",
					Constants.HEALTH_INSURANCE_ERROR_MESSAGE);
			logger.error("Error :" + e.getMessage());
			return "findPremium";
		}
		model.addAttribute("response", response);
		logger.info("Response of calculateTotalPremium() "
				+ response.toString());
		return "findPremium";
	}

}
