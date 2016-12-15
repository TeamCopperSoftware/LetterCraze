#LetterCraze

WPI group project for CS3733 with Professor George Heineman
B Term 2016

Made by Team Copper:
* Goutham Deva
* John Dyer
* Anthony Gringeri
* Annie Hernandez
* James Kradjian

[Github repository link] 
(https://github.com/TeamCopperSoftware/LetterCraze#lettercraze)

##Importing the project into Eclipse
To import this project, open Eclipse. Navigate to File -> Import -> General -> Archive File. Select our project.

##Running the application
See instructions below. Be sure to **READ THE INSTRUCTIONS** for testing before running our JUnit test cases.

###LetterCraze
To run the LetterCraze player application, navigate to the playermain package. Right click on Main.java and select "Run as -> Java Application". 

On execution, a splash screen with team credits should appear.

After 5 seconds, the main menu should appear. Click on "Play Game" which will take you to the main "Adventure" map. The first 3 levels are unlocked to begin so that you can test them all out. Level 1 is a Puzzle Level, Level 2 is a Lightning Level, and Level 3 is a Theme level. This pattern continues until the end of the game. The remaining 12 levels are locked. Levels are unlocked in chronological order, and to unlock it, you need to obtain at least one star in the level before it. Refer to the instructions below for details on playing the levels.

If you return to the main menu, clicking on "Play Custom Levels" which will take you to the custom level map which should show 15 level "slots". Here, levels that are created in the builder will appear here exactly as they were in the builder. Here, they can be played. All custom levels are unlocked all the time. 

On the main menu, there is also an option to reset your main game progress. This will quit the application and erase your scores and all other progress in the main game. Note that this will not erase high scores in the custom levels. Open the application back up to see that you have reset your progress. 

###LetterCraze Builder
To run the builder application, navigate to the buildermain package. Right click on Main.java and select "Run as -> Java Application". 

On execution, splash screen with team credits should appear.

After 5 seconds, the main menu for builder should appear. Clicking on "Create New Level" will take you to the level builder screen. Refer to the instructions below for details on building levels.

Clicking on "Edit Saved Levels" will take you to a map containing all built custom levels. Clicking on any of these levels will allow you to modify any levels that you have previously saved. Click on the back button to go back to the main menu.

##Playing LetterCraze
LetterCraze's main map contains 15 levels with 3 different types of level: Puzzle, Lightning, and Theme. Puzzle limits the amount of moves you can make, Lightning limits the time you have with no limit on the amount of words you can play, and Theme is based on finding specific words based on a given topic. 

Selecting words in a level are performed by clicking on letters in the tiles and following that tile path until it forms a word. Each consecutive tile is clicked seperately. The tile path can take any shape, as long as the next tile is above, below, to the left, to the right, or in any diagonal direction of the tile before it. Words must be real words and must be 3 letters or longer. Once you select a valid word by highlighting the tiles, press the "Add Word" button to attempt to add a word. It will appear in the list of words and the tiles will be removed from the board if the word selected is valid. For Puzzle and Lightning levels, new tiles will be generated after all remaining tiles float up on the board. Scores, stars, and objectives will be updated accordingly. After making a move, you can undo it. You can also reset the board at any time, but this will reset the objective for Puzzle and Theme levels. The Lightning level's timer will continue to run, however. You can exit a level at any time and your score will be saved if it beats the score displayed on the map. Each level's high score will appear around the level in the main map. Levels can be unlocked sequentially by achieving at least one star in the level before it. Custom levels can also be played by going back to the Main Menu and selecting custom levels. The same rules apply for custom levels, with the exception that all custom levels are always unlocked. 

##Building a LetterCraze level
LetterCraze's Builder application allows you to customize your own levels and import them to LetterCraze.
 
To create a new level, click on "Create New Level" on the main menu. Here, you can select which tiles are active on a board, select the type of level, set star goals, and set objectives for each level type. To select a level type, click on the drop down box on the top right and select the level you wish to make. For puzzle, select the number of moves a player can make. For lightning, select the amount of time (in seconds) the player has to complete the level. For theme, you must add a theme description and a list of words that matches the theme description. To add a word, type it into the text field and click "Add". To delete a word, type the word you'd like to delete from the list and click "Delete". 

Some notes about building theme levels:
* The builder will not allow you to add words twice. 
* You will need to decide where to place the letters of your words. If you misspell a word or place the letters in such a way that the level cannot be completed, the player will not be able to complete it.
* To ensure that scoring is proper, the value entered for "Star 3 Goal" should be equal to the amount of words in your level, "Star 2 Goal" should be equal to the amount of words in your level subtracted by 1, and "Star 3 Goal" should be equal to the amount of words in your level subtracted by 2. 
* Once you have entered all of your information, click the "Save Level" at the bottom of the screen to save your level.
 
To edit a saved level, navigate back to the main menu and click on "Edit Saved Level". From here you can navigate through a map of all the levels you saved. Click on the level you wish to edit and continue to work on the level from there. Make sure to save the level again before exiting. To delete a level, click on the icon located on the top left of each level button. To publish your saved levels to LetterCraze player, click the "Publish Levels to LetterCraze" button on the top right corner of the custom levels map. Doing this will publish all of your levels that are saved. Don't worry if you forget to press this button though; when you exit the builder application your levels will be saved and ready to play when LetterCraze is opened.

##Beating the first three levels
Both the first Puzzle level and the first Lightning level should be able to be beaten fairly easily. For first theme level, one correct way to solve it is to select words in this order:

1. CORN (Near the top left corner, forms 2x2)
2. PUMPKIN (Bottom right corner)
3. BEAN (Top right corner)
4. KALE (Bottom left of remaining tiles)
5. ONION

##Testing
To run a suite of JUnit3 test cases on our project, right click on the project folder and select Coverage As -> JUnit Test. **IF ANY DIALOG WINDOWS WITH MULTIPLE OPTIONS POP UP, CHOOSE THE "NO" OPTION.** Note that these tests may take a few seconds. Navigate to the source folder "test" to view specific tests that were run on our project.
