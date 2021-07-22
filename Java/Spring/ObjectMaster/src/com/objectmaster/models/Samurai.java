package com.objectmaster.models;

public class Samurai extends Human {
	public static int count = 0;
	
	public Samurai() {
		count++;
		this.health = 200;
	}
	
	public void deathBlow(Human target) {
		target.health = 0;
		this.health /= 2;
	}
	
	public void meditate() {
		this.health += (this.health/2);
	}
	
	public static void howMany() {
		System.out.println(count); 
	}
}
