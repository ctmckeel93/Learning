class Human 
    attr_accessor :strength, :intelligence, :stealth, :health 
    def initialize
        @strength = 3 
        @intelligence = 3 
        @stealth = 3 
        @health = 100 
    end 

    def attack(target)
        if target.class.ancestors.include?(Human)
            puts "You attacked #{target}"
            target.health -= 10
            true
        else  
            puts "Invalid target"
            false
        end 
    end 
end

human1 = Human.new 
human2 = Human.new 
human1.attack(human2)
human1.attack("Not a Human")
puts human2.health 
puts human1.health 