package com.zookeeper.models;

public class BatTest {

	public static void main(String[] args) {
		Bat b = new Bat();
		
		for (int i = 0; i < 3; i++) {
			b.attackTown();
		}
		
		for (int i = 0; i < 2; i++) {
			b.eatHumans();
			b.fly();
		}
	}

}
