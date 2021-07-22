package com.phones.models;

public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private String carrier;
	private String ringtone;
	public Phone(String versionNumber, int batteryPercentage, String carrier, String ringtone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.carrier = carrier;
		this.ringtone = ringtone;
	}
	
	public abstract void displayInfo();
	
	public String getVersionNumber() {
		return this.versionNumber;
	}
	
	public int getBatteryLevel() {
		return this.batteryPercentage;
	}
	
	public String getCarrier() {
		return this.carrier;
	}
	
	public String getRingtone() {
		return this.ringtone;
	}

}
