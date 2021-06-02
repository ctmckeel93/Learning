//
//  main.swift
//  Suits
//
//  Created by Corey Mckeel on 6/2/21.
//

import Foundation

let suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
let cards = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
var deckOfCards = [String: [Int]]()
for suit in suits {
    deckOfCards["\(suit)"] = cards
}

print(deckOfCards)


func TossCoin() -> String {
    let choices = ["Heads", "Tails"]
    let flipResult: String = String(choices.randomElement()!)
    print("Tossing a coin")
    return flipResult
}

print(TossCoin())

func TossCoins(num:Int) -> Double {
    var sum: Double = 0
    for i in 1...num {
        var result = TossCoin()
        print(result)
        if result == "Heads" {
            print("Got one!")
            sum+=1
            print(sum)
        }
        
    }
    print(sum)
    print(num)
    print(sum/Double(num))
    return sum/Double(num)
}

print(TossCoins(num: 5))

