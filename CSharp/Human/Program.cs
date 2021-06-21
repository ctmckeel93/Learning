using System;
using Human.Models;

namespace Human
{
    class Program
    {
        static void Main(string[] args)
        {
            string name;
            string strength;
            string dexterity;
            string constitution;
            string wisdom;
            string intelligence;
            string charisma;
            WeaponClass weapon;
            HumanClass newPlayer;

            WeaponClass sword = new WeaponClass("Sword", "Slashing", 2, 6);
            HumanClass player = new HumanClass("Skye", 10, 18, 14, 16, 20, 12, sword);
            EnemyClass enemy = new EnemyClass("Goblin", 16, 16, 16, 10, 10, 10, sword);
            Console.WriteLine(player.health);
            Console.WriteLine(enemy.health);
            Random roll = new Random();
            void startGame()
            {

                Console.WriteLine("What is your name?");
                name = Console.ReadLine();
                Console.WriteLine("Awesome, we will generate your stats for you now.");
                string[] stats = new string[6];
                for (int i = 1; i <= 6; i++)
                {
                    stats[i - 1] = "" + ((roll.Next(2, 7)) + (roll.Next(2, 7)) + (roll.Next(2, 7)));
                }
                Console.WriteLine("Here are your stats! Assign them any way you wish ");
                foreach (string stat in stats)
                {
                    Console.WriteLine(stat);
                }
                Console.WriteLine("How strong are you?");
                strength = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == strength))
                {
                    Console.WriteLine("That is not one of the stats");
                    strength = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, strength);
                    stats[idx] = null;
                }
                Console.WriteLine("How fast are you?");
                dexterity = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == dexterity))
                {
                    Console.WriteLine("That is not one of the stats");
                    dexterity = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, dexterity);
                    stats[idx] = null;
                }
                Console.WriteLine("How durable are you?");
                constitution = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == constitution))
                {
                    Console.WriteLine("That is not one of the stats");
                    constitution = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, constitution);
                    stats[idx] = null;
                }
                Console.WriteLine("How wise are you?");
                wisdom = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == wisdom))
                {
                    Console.WriteLine("That is not one of the stats");
                    wisdom = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, wisdom);
                    stats[idx] = null;
                }
                Console.WriteLine("How intelligent are you?");
                intelligence = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == intelligence))
                {
                    Console.WriteLine("That is not one of the stats");
                    intelligence = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, intelligence);
                    stats[idx] = null;
                }
                Console.WriteLine("How charismatic are you?");
                charisma = Console.ReadLine();
                if (!Array.Exists(stats, stat => stat == charisma))
                {
                    Console.WriteLine("That is not one of the stats");
                    charisma = Console.ReadLine();
                }
                else
                {
                    int idx = Array.IndexOf(stats, charisma);
                    stats[idx] = null;
                }
                int str = Convert.ToInt32(strength);
                int dex = Convert.ToInt32(dexterity);
                int con = Convert.ToInt32(constitution);
                int wis = Convert.ToInt32(wisdom);
                int intel = Convert.ToInt32(intelligence);
                int cha = Convert.ToInt32(charisma);
                newPlayer = new HumanClass(name, str, dex, con, wis, intel, cha, sword);
                newPlayer.stats();
                Console.WriteLine($@"
            Welcome adventurer! Today you embark on a journey of heroism. You have selected your weapon of choice, built your body in preparation for this day and embarked from your hometown for an epic tale. Oh dear, it looks like the fun has already begun, a Goblin attacked!");
                while (newPlayer.health > 0 && enemy.health > 0)
                {

                    newPlayer.rollAttack(enemy);
                    enemy.rollAttack(newPlayer);
                }
                if (newPlayer.health < 0)
                {
                    Console.WriteLine("GAME OVER");
                }
                else
                {
                    Console.WriteLine("Congratulations! You defeated the Goblin! Play again?");
                    string answer = Console.ReadLine();
                    if (answer == "yes")
                    {
                        Console.Clear(); 
                        startGame();
                    }
                    
                    Console.WriteLine("Goodbye");
                    Console.Clear();
                }
            }
                    startGame();
        }
    }
}
