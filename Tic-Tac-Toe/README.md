# Tic Tac Toe 

This is the world-known 2 player game [Tic Tac Toe](https://github.com/henrique-efonseca/Portfolio/blob/master/Tic-Tac-Toe/tic_tac_toe.java). <br> 
<br>
Because I'm learning **Java** in [College](https://github.com/henrique-efonseca/College-Projects) I wanted to put the knowledge I had so far to practice and develop something. It couldn't be something too complex because I had only completed the "_Introduction to Programming_" class. So I decided to make the [Tic Tac Toe](https://github.com/henrique-efonseca/Portfolio/blob/master/Tic-Tac-Toe/tic_tac_toe.java) game but in a **text-based** version. 
Hopefully, I'll be making the GUI version soon. <br> 

The rules are simple, alternately each Player enters a Row and a Column, between [1-3], to choose a House to play (Houses are represented in a [3][3] Matrix).
The player who plays in 3 consecutive Houses (vertically, horizontally or perpendicular) wins the game.
If every House is filled without this happening it's consider a Tie. <br>
Players can play the game multiple times and the player who wins the most games is the Overall Winner. <br> <br>

## Game Mechanics

The game will ask if you want to play before beginning the game. If you answer positively it will ask for the Players Names:
```
Hello! This is Tic-Tac-Toe, do you want to play? Type 'y' for YES or 'n' for NO.
y

Please enter Player 1 name:
Henrique

Please enter Player 2 name:
Dudas
```
<br>


Then the game outputs the following:

```
Let's play Tic-Tac-Toe! Good luck!

| _ | _ | _ | 
| _ | _ | _ | 
| _ | _ | _ | 

Henrique, Please enter a Row and Column [1-3]: 
```
<br>


To choose, for example, the first House you input:
```
1
1
```
<br>


Then the game will output the following:

```
| X | _ | _ | 
| _ | _ | _ | 
| _ | _ | _ | 

Dudas, Please enter a Row and Column [1-3]: 
``` 

And you keep playing like this until someone wins or draws. <br>
<br>


When the game ends you can play again multiple times or not:
```
| X | O | O | 
| _ | X | _ | 
| _ | _ | X | 

Game over! Henrique wins!

SCORE: 
Henrique: 1
Dudas: 0
```

```
Do you want to play again [y/n] ?
n

SCORE: 
Henrique: 1
Dudas: 0

Henrique is the winner! Congratulations Henrique !

Thank you for playing Tic-Tac-Toe. Goodbye!
```
<br>


---

© [Henrique Fonseca](https://github.com/henrique-efonseca)
