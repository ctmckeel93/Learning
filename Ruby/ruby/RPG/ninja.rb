require_relative "human" 

class Ninja < Human 
    def initialize
        @stealth = 175 
    end 
    
    def steal(target)
        target.health -= 10
        @health += 10 
        self 
    end 

    def get_away
        @health -= 15
    end 
end 