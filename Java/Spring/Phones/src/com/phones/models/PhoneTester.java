package com.phones.models;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 100, "Verizon", "RIng ring ring");
		Iphone i10 = new Iphone("IphoneX", 100, "AT&T", "Zing");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		i10.displayInfo();
		System.out.println(i10.ring());
		System.out.println(i10.unlock());
	}

}
