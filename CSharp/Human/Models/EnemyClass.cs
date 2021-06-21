using System;

namespace Human.Models
{
    public class EnemyClass : HumanClass
    {
        public EnemyClass(string charName, int str, int dex, int con, int wis, int intel, int cha, WeaponClass equipped ) : base(charName, str, dex, con, wis, intel, cha, equipped) 
        {
        }
            // public int attack(HumanClass target)
            // {
            //     Random roll = new Random();
            //     double atkRoll = roll.Next(1,21) + equippedWeapon.modifier;
            //     if (atkRoll >= target.armorClass)
            //     {
            //         target.health -= roll.Next(1, equippedWeapon.die) + equippedWeapon.modifier;
            //     }
            //     else
            //     {
            //         Console.WriteLine("Attack missed!");
            //     }
            //     Console.WriteLine($"{charName} attacked {target.charName}/n {target.charName} has {target.health}hp remaining");
            //     return target.health;
            // }
    }
}