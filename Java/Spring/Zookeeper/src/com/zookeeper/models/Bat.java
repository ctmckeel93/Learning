package com.zookeeper.models;

public class Bat extends Mammal {
	
	public Bat() {
		this.energy = 300;
	}
	
	public void fly() {
		System.out.println("Wooosh! The bat took to the sky!");
		this.energy -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Oh goodness its eating them!");
		this.energy -= 25;
	}
	
	public void attackTown() {
		System.out.println("brsssshhh, crackle...oh dear...the town is in flames");
		this.energy -= 100;
	}
}
