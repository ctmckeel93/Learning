package com.zookeeper.models;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla kong = new Gorilla();
		for (int i = 0; i < 3; i++) {
			kong.throwSomething();
		}
		
		for (int i = 0; i < 2; i++) {
			kong.eatBananas();
		}
		
		kong.climb();
		
		kong.displayEnergy();
		
	}

}
