user1=input("Player1's name")
user2=input("Player2's name")
user1_answer=input(user1+"Do you want to choose rock, paper or scissors?").lower()
user2_answer=input(user2+"Do you want to choose rock, paper or scissors?").lower()

if user1_answer==user2_answer:
    print("It's a tie!")
elif user1_answer=="rock":
    if user2_answer=="scissors":
        print("rock wins!")
    else:
        print("paper wins!")
elif user1_answer=="Scissors":
    if user2_answer=="paper":
        print ("scissors wins!")
    else:
        print("Rock wins!")
elif user1_answer=="paper":
    if user2_answer=="rock":
        print("rock wins!")
    else:
        print("scissors wins!")                        
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")