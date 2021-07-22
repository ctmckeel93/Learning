package com.zookeeper.models;

public class Mammal {
	public int energy;
	public Mammal() {
		this.energy = 100;
	}
	
	public int displayEnergy() {
		System.out.println(this.energy);
		return this.energy;
	}
	
	
}
