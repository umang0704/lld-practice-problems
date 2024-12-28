# Requirements:

1. Multi Player game. Played on a grid of size 100. Each cell will have a number.
2. Some off the cell will have ladder which will jump to higher number.
3. Some cell will have a snake which will take you down to tail number.
4. Player will in turn roll a die(1-6). Based on the value user will advance.

---
# User Journey
    1. Game Start with players, board size, snakes and ladders.
    2. First player is prompted to roll dice, on result first player is moved.
    3. Simultaneously next player is selected and dice is rolled
    4. After every move, winner is checked.
---
# Class Diagram
## Game
    board : Board
    players : List<Players>
    currentPlayer : Player
    dice : Dice
---
    getNextPlayer() 
    rollDice()
    checkWinner()

## Board
    cells : List<Cell>
    snakes : List<Snake>
    ladders : List<Ladder>

## Player
    name : String
    color : Color
    currentCell : Cell
    moves : List<Move>

## Dice 
    possibleOutcome : List<Integer>
---
    rollDice()

## Cell
    x : Integer
    y : Integer

## Snake
    startCell : Cell
    endCell : Cell

## Ladder
    startCell : Cell
    endCell : Cell

## Move
    currentCell : Cell
    diceOutcome : Integer
    nextCell : Integer 
    snakeBite : Boolean
    ladderUp : Boolean

---



    
    
    

