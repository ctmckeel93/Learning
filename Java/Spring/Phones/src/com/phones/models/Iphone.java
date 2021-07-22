package com.phones.models;

public class Iphone extends Phone implements Ringable {
	
	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringtone) {
		super(versionNumber, batteryPercentage, carrier, ringtone);
	}
	
	@Override
	public String ring() {
		String ringer = "ring ring ring!";
		return ringer;
	}
	
	@Override
	public String unlock() {
		return "Unlocking via facial recognition";
	}

	@Override
	public void displayInfo() {
		System.out.println("Version: " + getVersionNumber());
		System.out.println("Battery at " + getBatteryLevel() + "%");
		System.out.println("Carrier: " + getCarrier());
		System.out.println("Ringtone: " + getRingtone());
	}

	

}
