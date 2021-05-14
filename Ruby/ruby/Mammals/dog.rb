require_relative 'mammal'

class Dog < Mammal
    def pet
        puts "You pet the dog and he's very happy and filled with energy"
        self.health += 5
        self
    end 

    def walk 
        puts "You walked the dog and he's a little tired"
        self.health -= 1
        self
    end 

    def run 
        puts "The dog is all tuckered out after a run!"
        self.health -= 10
        self
    end 
end 

dog = Dog.new 
dog.walk.walk.walk.run.run.pet.display_health





