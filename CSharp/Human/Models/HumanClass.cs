using System;
using System.Drawing;

namespace Human.Models
{
    public class HumanClass
    {
        public string charName {get; set;}
        public double strength {get; set;}
        public int health {get;set;}


        public double dexterity{get;set;}
        public double constitution{get;set;}
        public double wisdom {get;set;}
        public double intelligence {get;set;}
        public double charisma {get;set;}
        public double level {get;set;}
        public int armorClass {get; set;}

        public WeaponClass equippedWeapon {get;set;} 

        public HumanClass(string name, int str, int dex, int con, int wis, int intel, int cha, WeaponClass weapon)
        {
            charName = name; 
            level = 1;
            strength = str + 1;
            dexterity = dex + 1; 
            constitution = con + 1;
            wisdom = wis + 1;
            intelligence = intel + 1;
            charisma = cha + 1;
            health = setHealth();
            equippedWeapon = weapon;
            armorClass = ((int)dexterity/2 - 5)+10;
        }


            public int setHealth() 
            {
                Random rand = new Random();
                this.health = (int)(rand.Next(1,11) + ((this.constitution/2) - 5) * level) + 10;
                return health;
            }


            public int rollAttack(HumanClass target)
            {
                if (this.health <= 0)
                {
                    Console.WriteLine("You are already dead.");
                    return 0;
                }
                else if (target.health <= 0)
                {
                    Console.WriteLine("Target has fainted");
                    return 0;
                }
                Random roll = new Random();

                double finalRoll = roll.Next(1, 21) + equippedWeapon.modifier ;
                Console.WriteLine($"{charName} rolled a {finalRoll}");
                int damage;
                if (finalRoll >= target.armorClass)
                {
                    damage = roll.Next(1,equippedWeapon.die+1) + equippedWeapon.modifier;
                    if (finalRoll - equippedWeapon.modifier == 20)
                    {
                        damage*=2;
                    }
                    target.health -= damage;
                }
                else
                {
                    damage = 0;
                    Console.WriteLine("Attack missed!");
                }
                Console.WriteLine($"{charName} attacked {target.charName} dealing {damage} points of damage\n {target.charName} has {target.health}hp remaining");
                if (target.health <= 0)
                {
                    Console.WriteLine($"{target.charName} has fainted");
                }
                return (int)finalRoll;
            }

            public void stats()
            {
                Console.WriteLine($"Name: {charName}");
                Console.WriteLine($"Strength: {strength}", Color.Green);
                Console.WriteLine($"Dexterity: {dexterity}");
                Console.WriteLine($"Constitution: {constitution}");
                Console.WriteLine($"Wisdom: {wisdom}");
                Console.WriteLine($"Intelligence: {intelligence}");
                Console.WriteLine($"Charisma: {charisma}");
                Console.WriteLine($"Weapon: {equippedWeapon.name}");
                Console.WriteLine($"HP: {health}");
            }

    }
}