package com.objectmaster.models;

public class Ninja extends Human {

	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(Human target) {
		int damage = this.stealth;
		target.health -= damage;
		this.health += damage;
	}
	
	public void runAway() {
		this.health -= 10;
	}
}
