# word-game

This code creates a simple word game using a JFrame and some panel configurations.

When a word is placed inside of the text box and submitted, it will appear in the scrollable text area if it has not already been submitted before. In the case that a word has already been submitted, a message will pop up to inform the user that the word is alreayd in the list, and neither the score nor the text area will be altered.

The scoring system is awarded based on number of letters in a submitted word: 
- (0, 4] = 20 pts
- (4, 6] = 40 pts
- (6, 8] = 60 pts
- (8, inf) = 100 pts

The aim of the game is for the user to input as many real words as they can think of given a randomized letter that all the words must start with.



future functions:
Increased difficulty - 10 sec timer
Spellcheck
