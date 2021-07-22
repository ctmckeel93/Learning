package com.phones.models;

public class Galaxy extends Phone implements Ringable {
	
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringtone) {
		super(versionNumber, batteryPercentage, carrier, ringtone);
	}
	
	@Override
	public String ring() {
		
		return getRingtone();
	}
	
	@Override
	public String unlock() {
		return "Unlocking via fingerprint";
	}

	@Override
	public void displayInfo() {
		System.out.println("Version: " + getVersionNumber());
		System.out.println("Battery at " + getBatteryLevel() + "%");
		System.out.println("Carrier: " + getCarrier());
		System.out.println("Ringtone: " + getRingtone());
	}

	

}
