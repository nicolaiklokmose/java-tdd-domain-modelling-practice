# Java Domain Modelling Practice Exercises

## Learning Objectives
- Create domain models for various exercises
- Implement tests for the exercises
- Write the code that meets the criteria detailed in the tests using the Red-Green-Refactor methodology

## Exercise 1

Implement a random student selector similar to the one used during lessons.

### User Stories

```
1. When I run the program I see a menu giving me options to use each of the functions of the program.

```

### Class StudentSelector

| Member Variables | Methods    | Scenario                                         | Output                                |
|------------------|------------|--------------------------------------------------|---------------------------------------|
|                  | run()      | When I launch the program, it starts if possible | If success: true _ else: false        |
|                  | showMenu() | When the program has successfully launched,      | If success: Show menu _ else: abort() |
|                  |            | show the user its allows inputs                  |                                       |

```
2. When I select the option it will output a randomly chosen student from the list.
```
### Class StudentSelector

| Member Variables | Methods                   | Scenario                                               | Return / Output                       |
|------------------|---------------------------|--------------------------------------------------------|---------------------------------------|
|                  | run()                     | When I launch the program, it starts if possible       | If success: true _ else: false        |
|                  | showMenu()                | When the program has successfully launched,            | If success: Show menu _ else: abort() |
|                  |                           | show the user its allows inputs.                       |                                       |
|                  | optionA()                 | When I want to randomly select a student from the list | If success: Return student and print  |
|                  | instantiateListFromFile() | When I run program I want it to contain the students   | If success: true _ else: false        |


```
3. When I select the option it will output a list of all of the students as randomly chosen pairs.
```

### Class StudentSelector

| Member Variables | Methods                   | Scenario                                               | Return / Output                       |
|------------------|---------------------------|--------------------------------------------------------|---------------------------------------|
| filePath: String | run()                     | When I launch the program, it starts if possible       | If success: true _ else: false        |
| students: List   | showMenu()                | When the program has successfully launched,            | If success: Show menu _ else: abort() |
| random: Random   |                           | show the user its allows inputs.                       |                                       |
|                  | optionA()                 | When I want to randomly select a student from the list | If success: Return student and print  |
|                  | instantiateListFromFile() | When I run program_A I want it to contain the students | If success: true _ else: false        |
|                  | optionB()                 | When I want to randomly select students as pairs       |                                       |

```
4. When I select the option it will output a random list of Peer Groups for all of the students (groups of 4 students).
```
### Class StudentSelector

| Member Variables | Methods                   | Scenario                                               | Return / Output                       |
|------------------|---------------------------|--------------------------------------------------------|---------------------------------------|
| filePath: String | run()                     | When I launch the program, it starts if possible       | If success: true _ else: false        |
| students: List   | showMenu()                | When the program has successfully launched,            | If success: Show menu _ else: abort() |
| random: Random   |                           | show the user its allows inputs.                       |                                       |
|                  | optionA()                 | When I want to randomly select a student from the list | If success: Return student and print  |
|                  | instantiateListFromFile() | When I run program_A I want it to contain the students | If success: true _ else: false        |
|                  | optionB()                 | When I want to randomly select students as pairs       |                                       |
|                  | optionC()                 | When I want ro randomly select students as groups of 4 |                                       |

```
5. When I run the program it should load the list of current students from a text file.
```

## Exercise 2

Thinking about the Poker Challenge implement a deck of cards (52 cards - 4 suits - 13 cards per suit)

### User Stories

```
1. When I run the program a new deck of cards should be created and then they should be shuffled.

2. I should be able to select an option to display the current state of the deck.

3. I should be able to select an option to shuffle the deck.

4. I should be able to select an option to create a hand of cards dealt from the top of the deck, I can specify how many cards should be in it.

5. I should be able to deal out 4 hands of 5 cards each and see the dealt hands.

6. I should be able to view the top card of the deck.

7. I should be able to cut the cards and see a card from an arbitrary point in the deck.
```
### Class Card

| Member Variables | Methods | Scenario | Return | Output |
|------------------|---------|----------|--------|--------|
| suit: Suit       |         |          |        |        |
| rank: Rank       |         |          |        |        |



### Class PlayingCards

| Member Variables | Methods                  | Scenario                                 | Return | Output  |
|------------------|--------------------------|------------------------------------------|--------|---------|
| cards: List      | initializeCards()        | When I want to create list of Cards      | void   | null    |
|                  | shuffleCards()           | When I want to shuffle the list of cards | void   | null    |
|                  | currentState()           | When I want to see list of cards         | void   | Sys.out |
|                  | createHand()             | When I want to create a hand of cards    | void   | Sys.out |
|                  | dealFourHandsFiveCards() | When I want to simulate Poker            | void   | Sys.out |
|                  | viewTopCard()            | When I want to see the card on top       | void   | Sys.out |
|                  | cutCards()               | When I want to see individual cards      | void   | Sys.out |
