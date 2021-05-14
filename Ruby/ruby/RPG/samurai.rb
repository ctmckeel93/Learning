require_relative "human"

class Samurai < Human 
    @@how_many = 0
    def initialize
        @health = 200
        @@how_many += 1
    end 

    def death_blow(target)
        target.health = 0
        self 
    end 
    def meditate 
        @health = 200
        self 
    end 

    def self.count
        @@how_many
    end 
end 

s1 = Samurai.new 
s2 = Samurai.new 
puts Samurai.count 
