package com.health.insurance.premium.api.dto;

public class PremiumForm {
	private String name;
	private String gender;
	private int age;
	private String smoking;
	private String alcohol;
	private String dailyExercise;
	private String drugs;
	private String Hypertension;
	private String bloodPressure;
	private String bloodSugar;
	private String overWeight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getDailyExercise() {
		return dailyExercise;
	}

	public void setDailyExercise(String dailyExercise) {
		this.dailyExercise = dailyExercise;
	}

	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}

	public String getHypertension() {
		return Hypertension;
	}

	public void setHypertension(String hypertension) {
		Hypertension = hypertension;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(String bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public String getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(String overWeight) {
		this.overWeight = overWeight;
	}

	@Override
	public String toString() {
		return "PremiumForm [name=" + name + ", gender=" + gender + ", age="
				+ age + ", smoking=" + smoking + ", alcohol=" + alcohol
				+ ", dailyExercise=" + dailyExercise + ", drugs=" + drugs
				+ ", Hypertension=" + Hypertension + ", bloodPressure="
				+ bloodPressure + ", bloodSugar=" + bloodSugar
				+ ", overweight=" + overWeight + "]";
	}

}
