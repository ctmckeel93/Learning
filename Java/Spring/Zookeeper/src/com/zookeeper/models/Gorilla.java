package com.zookeeper.models;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla threw a banana peel!");
		this.energy -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Awe, hes enjoying a snack, some delicious bananas!");
		this.energy += 10;
	}
	
	public void climb() {
		System.out.println("Oh, hes so high, look at him climb!");
		this.energy -= 10;
	}
}
