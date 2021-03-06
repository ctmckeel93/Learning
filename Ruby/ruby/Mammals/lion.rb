require_relative "mammal"

class Lion < Mammal 
    def initialize
        @health = 170
        self 
    end 

    def fly 
        @health -= 10
        self 
    end 

    def attack_town 
        @health -= 50 
        self 
    end 

    def eat_humans 
        @health += 20 
        self 
    end 

    def display_health
        puts "This is a Lion"
        super 
    end 
end 

l = Lion.new.attack_town.attack_town.attack_town.eat_humans.eat_humans.fly.fly.display_health
