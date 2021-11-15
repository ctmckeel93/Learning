def say_name(name=""):
    if name == "": 
        print("I have no name")
    else:
        print("My name is", name)\

    return name


say_name()
say_name("Corey")
# print(say_name())

class Pokemon():
    def __init__(self, name, atk, defense):
        self.name = name
        self.speed = 5
        self.attack = atk
        self.defense = defense
        self.health = 100
    
    def attack_pokemon(self,poke):
        print("Target:", poke.__dict__)
        print("Attacking pokemon:", self.__dict__)
        print("Attacking pokemon's attack:", self.attack)
        print("Target's defense", poke.defense)
        damage = self.attack - poke.defense
        print("Final damage:", damage)
        poke.health -= damage
        print(f"{self.name} attacked {poke.name} and dealt {damage} damage")
        print(f"{poke.name} has {poke.health}hp remaining")
    
pikachu = Pokemon("Pikachu", 6, 2)
charizard = Pokemon("Charizard", 4, 1)
pikachu.attack_pokemon(charizard)
# print(charizard.health)

game = True

start_auto_attack():
    
while game == True:
    if poke1.speed > poke2.speed:
        poke1.attack_pokemon(poke2)
    else:
        poke2.attack_pokemon(poke1)