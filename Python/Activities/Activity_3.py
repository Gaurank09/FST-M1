# Get the users names
Player1 = input("Enter Player 1's name: ")
Player2 = input("Enter Player 2's name: ")

player1_answer = input(Player1 + "!! Choose 1 option. Rock, Paper or Scissors: ").lower()
player2_answer = input(Player2 + "!! Choose 1 option. Rock, Paper or Scissors: ").lower()

if player1_answer == player2_answer:
    print("Tie")

elif player1_answer == 'rock':
    if player2_answer == 'scissors':
        print(Player1 + " is Winner. Rock wins!")
    else:
        print(Player2 + " is Winner. Paper wins!")

elif player1_answer == 'scissors':
    if player2_answer == 'paper':
        print(Player1 + " is Winner. Scissors win!")
    else:
        print(Player2 + "is Winner. Rock wins!")

elif player1_answer == 'paper':
    if player2_answer == 'rock':
        print(Player1 + " is Winner. Paper wins!")
    else:
        print(Player2 + " is Winner. Scissors win!")
else:
    print("Invalid Option Selected!!! Choose an option from  Rock, Paper or Scissors, try again.")