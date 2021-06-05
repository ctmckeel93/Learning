//
//  main.swift
//  DeckofCards
//
//  Created by Corey Mckeel on 6/4/21.
//

import Foundation
var colorArray: [String] = ["Blue","Red", "Green"]
var playerArray: [String] = ["Skye", "Gaius", "Donovan", "Rose"]
struct Card {
    var color: String
    var roll: Int
    
    init (color: String, roll: Int=0) {
        self.color = color
        self.roll = roll
        switch self.color {
        case "Blue":
            self.roll = Int.random(in: 1...2)
        case "Red":
            self.roll = Int.random(in: 3...4)
        case "Green":
            self.roll = Int.random(in: 5...6)
        default:
            self.roll = 0
        }
    }
    
}

class Deck {
    var cards: [Card]
    init() {
        self.cards = []
        
        for color in colorArray {
            for _ in 1...10 {
                self.cards.append(Card(color: color ))
            }
        }
        print(self.cards)
        
        
        
    }
    func IsEmpty() -> Bool{
        if self.cards.count > 0{
            return false
        }
        else {
            return true
        }
    }
    func Deal() -> Card{
                return self.cards.removeFirst()
            }
            
    func Shuffle() {
        self.cards.shuffle()
    }
}

class Player {
    var name: String
    var hand: [Card]
    var coins: Int

    init(name:String){
        self.name = name
        self.hand = []
        self.coins = 0
    }
    
    
    func Draw(deck:Deck) -> Card {
        let drawnCard = deck.Deal()
        self.hand.append(drawnCard)
        return drawnCard
    }
    
    func Roll() -> Int{
        return Int.random(in: 1...6)
    }
    
    func matchingCards(color: String, value: Int) -> Int{
        var count = 0
        for card in self.hand{
            if card.color == color && card.roll == value {
                count += 1
            }
        }
        print("Yay! \(self.name) found \(count) cards that match!")
        return count
    }
}

class Game {
    var players: [Player]
    var deck: Deck
    var turnIdx: Int
    init(){
        self.players = []
        self.deck = Deck()
        self.turnIdx = 0
        for player in playerArray {
                self.players.append(Player(name: player ))
            }
        self.deck.Shuffle()
        for p in self.players{
            for _ in 1...3{
                p.hand.append(p.Draw(deck: self.deck))
            }
        }
    }
    
    
    
    
    
    func Play(){
        
        while self.deck.IsEmpty() == false {
            TakeTurn(p: self.players[self.turnIdx])
            self.turnIdx += 1
            if self.turnIdx > self.players.count-1 {
                self.turnIdx = 0
            }
        }
        AnnounceWinner()
    }
    
    func TakeTurn(p: Player){
        let rollResult = p.Roll()
        if rollResult == 5 || rollResult == 6{
            let matchCount = p.matchingCards(color: "Green", value: rollResult)
            print("Count: \(matchCount)")
            p.coins += (2 * matchCount)
        }
        else if rollResult == 3 || rollResult == 4 {
            for player in self.players {
                if player.name == p.name {
                    continue
                }
                else {
                    if player.matchingCards(color: "Red", value: rollResult) > 0{
                        if p.coins > 0 {
                            p.coins -= 1
                            player.coins += 1
                        }
                    }
                    print("\(p.name) has \(p.coins) coins")
                }
            }
        }
        else if rollResult == 1 || rollResult == 2 {
            for player in self.players {
                if player.matchingCards(color: "Blue", value: rollResult) > 0 {
                    player.coins += 1
                }
            }
        }
        
        let drawn = p.Draw(deck: self.deck)
        print(drawn.color)
        print("Deck count: \(deck.cards.count)")
    }
    
    func AnnounceWinner(){
        var winner = ""
        var max = 0
        for player in self.players {
            if player.coins > max{
                max = player.coins
                winner = player.name
            }
        }
        print("The winner is \(winner)")
    }
}



let game = Game()
game.Play()
