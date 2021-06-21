using System.Collections.Generic;

namespace Human.Models
{
    public class WeaponClass
    {
        public string name { get; set; }
        public string type { get; set; }
        public int modifier { get; set; }
        public int die {get;set;}
        
        

        public WeaponClass(string wName, string wType, int mod, int diceRoll)
        {
            name = wName;   
            type = wType; 
            modifier = mod;
            die = diceRoll;
        }
    }
}