require_relative "human"

class Wizard < Human 
    def initialize
        @health = 50
    end 

    def heal
        @health += 10
        self 
    end 

    def fireball(target)
        taget.health -= 20
        self 
    end 
end 