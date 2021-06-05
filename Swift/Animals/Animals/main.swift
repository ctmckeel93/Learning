//
//  main.swift
//  Animals
//
//  Created by Corey Mckeel on 6/4/21.
//

import Foundation

class Animal {
    var name: String
    var health = 100
    init(name: String){
        self.name = name
    }
    
    func DisplayHealth() -> Self{
        print("This animal has \(self.health)hp")
        return self
    }
}

class Cat: Animal {
    override init(name:String){
        super.init(name: name)
        self.health = 150
    }
    
    func Growl() -> Self{
        print("RAWR!!!")
        return self
    }
    
    func Run() -> Self{
        if self.health >= 50 {
            print("Running")
            self.health -= 10
        }
        else {
            print("Cheetah is too tired")
        }
        return self
    }
}

class Cheetah: Cat {
    
    override func Run() -> Self{
        print("Running fast")
        self.health -= 50
        if self.health < 0 {
            self.health = 0
        }
        return self
    }
    
    func Sleep() -> Self{
        self.health += 50
        if self.health > 200 {
            self.health = 200
        }
        return self
    }
    
}

class Lion: Cat {
    override init(name: String){
        super.init(name: name)
        self.health = 200
    }
    override func Growl() -> Self {
        print("ROAR!!! I'm the king of the jungle!")
        return self
    }
}

var cheetah = Cheetah(name:"Cheezy")

cheetah.Run().Run().Run().Run().DisplayHealth()

var lion = Lion(name: "Simba")

lion.Run().Run().Run().Run().Growl()





