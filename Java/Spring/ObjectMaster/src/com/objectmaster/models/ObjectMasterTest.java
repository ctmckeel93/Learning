package com.objectmaster.models;

public class ObjectMasterTest {
	public static void main(String[] args) {
		Ninja nin = new Ninja();
		Samurai sam = new Samurai();
		Wizard wiz = new Wizard();
		
		Samurai.howMany();
		
		nin.Attack(wiz);
		wiz.heal(wiz);
		
		wiz.fireball(nin);
		wiz.fireball(sam);
		
		nin.steal(wiz);
		sam.deathBlow(wiz);
		nin.runAway();
		System.out.println("Sam wins!");
		
	}

}
