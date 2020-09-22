# Sudoku Solver

This is the world-known **Sudoku game**.  <br> 

I did this project to learn about the **Backtracking Algorithm** and because I like Sudoku and found the project funny.
<br>
<br>


## Game Mechanics

The board it self is in the [working.py](https://github.com/henrique-efonseca/Portfolio/blob/master/Sudoku/working.py) file, so you just need to run the file and it will automatically solve the board. If you want you can change the board in the file.

```
python working.py

- - - - - - - - - - - - - 
7 8 0  | 4 0 0  | 1 2 0
6 0 0  | 0 7 5  | 0 0 9
0 0 0  | 6 0 1  | 0 7 8
- - - - - - - - - - - - - 
0 0 7  | 0 4 0  | 2 6 0
0 0 1  | 0 5 0  | 9 3 0
9 0 4  | 0 6 0  | 0 0 5
- - - - - - - - - - - - - 
0 7 0  | 3 0 0  | 0 1 2
1 2 0  | 0 0 7  | 4 0 0
0 4 9  | 2 0 6  | 0 0 7

 solving sudoku... 

- - - - - - - - - - - - - 
7 8 5  | 4 3 9  | 1 2 6
6 1 2  | 8 7 5  | 3 4 9
4 9 3  | 6 2 1  | 5 7 8
- - - - - - - - - - - - - 
8 5 7  | 9 4 3  | 2 6 1
2 6 1  | 7 5 8  | 9 3 4
9 3 4  | 1 6 2  | 7 8 5
- - - - - - - - - - - - - 
5 7 8  | 3 9 4  | 6 1 2
1 2 6  | 5 8 7  | 4 9 3
3 4 9  | 2 1 6  | 8 5 7

```
<br>


One good and simple addiction (and that I'll maybe add in the fucture) to this project would be to let the user add '.txt' files with boards and then the program would prompt for the file name of the file containing the board to be solved.
<br>

To use the GUI version (it doesn't have a solver built-in) you just need to run the [GUI.py](https://github.com/henrique-efonseca/Portfolio/blob/master/Sudoku/GUI.py) .
Note: You'll need to have pygame installed.
<br>
<br>

![Game](https://github.com/henrique-efonseca/Portfolio/blob/master/Sudoku/sudoku_gui.jpeg)
<br>

I did this project based on the Tutorial of [Tec With Tim](https://techwithtim.net/tutorials/python-programming/sudoku-solver-backtracking/).


<br>


---

© [Henrique Fonseca](https://github.com/henrique-efonseca)
