fruit_Store = {
    "apple": 200,
    "banana": 50,
    "orange": 100,
    "peaches": 150
}

checkFruit = input("What are you looking for? ").lower()
Cost = 0

if(checkFruit in fruit_Store):
    Cost = fruit_Store[checkFruit]
    print("Yes, " + checkFruit + " is available. \nThe Cost is: " )
    print(Cost)
else:
    print("No, " + checkFruit + " is not available. ")