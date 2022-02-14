console.log('Connected to js');


// Import the modules needed for file system and path
const fs = require("fs");
const path = require('path')

// Initialize math 
const random = Math.random
const floor = Math.floor
const min = Math.min 


// Grab the JSON data
const boyNames = JSON.parse(fs.readFileSync(path.join(__dirname,"boyNames.json")).toString()).data;
const girlNames = JSON.parse(fs.readFileSync(path.join(__dirname,"girlNames.json")).toString()).data;
const lastNames = JSON.parse(fs.readFileSync(path.join(__dirname,"lastNames.json")).toString()).data;


// Set form info 
class Character  {
    constructor(firstName="", lastName="", gender=""){
        // Basic Info
        this.firstName = firstName
        this.lastName = lastName
        this.gender = gender

        // Bio
        this.race = ""
        this.class = ""
        this.backStory =""

        // Stats
        this.strength = 0
        this.dexterity = 0
        this.constitution = 0
        this.wisdom = 0
        this.intelligence = 0
        this.charisma = 0

        // Initialize with random data
        this.generateStats()
        // writeBackstory()
        // If 
        if (this.firstname || this.lastName || this.gender == ""){
            this.generateRandom()
        }

        
    }
    generateStats() {
        this.strength = rollStat()
        this.dexterity = rollStat()
        this.constitution = rollStat()
        this.wisdom = rollStat()
        this.intelligence = rollStat()
        this.charisma = rollStat()
    }

    generateRandom() {
        var genderArr = ["Male", "Female"]

        this.gender = genderArr[floor(random() * genderArr.length)]

        switch(this.gender) {
            case "Male":
                this.firstName = boyNames[floor(random() * boyNames.length)]
                break
            case "Female":
                this.firstName = girlNames[floor(random() * girlNames.length)]
                break
            default:
                this.firstName = "Skye"

        } 

        this.lastName = lastNames[floor(random() * lastNames.length)]
    }


   
}


const rollStat = () => {
    var result = 0
    var rolls = [];

    for (let i=0; i < 4; i++) {
        var rng = floor(((random() * (6-2)) + 2) + 1)
        rolls.push(rng)
    }

    rolls[rolls.indexOf(min(...rolls))] = 0
    return rolls.reduce((num, result) => result += num )
}

var char1 = new Character()

console.log(char1)


