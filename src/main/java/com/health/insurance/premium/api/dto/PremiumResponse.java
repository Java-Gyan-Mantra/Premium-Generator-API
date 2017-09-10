package com.health.insurance.premium.api.dto;

public class PremiumResponse {
	private String name;
	private double amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PremiumResponse [name=" + name + ", amount=" + amount + "]";
	}

}
