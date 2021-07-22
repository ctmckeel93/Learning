package com.objectmaster.models;

public class HumanTest {

	public static void main(String[] args) {
		Human player = new Human();
		Human enemy = new Human();
		
		player.Attack(enemy);
		System.out.println(enemy.health);
	}

}
