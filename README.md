# DAT153 oblig 1 and 2

Group members:
- Aleksandar Bibic
- Sindre Ryland

# Oblig 2 task 2:
**Test method playButtonOpensQuizActivity():**  
This test checks if pressing the "Play Quiz" button on the main activity opens the quiz activity.

Line 49: launches the MainActivity class.  
Line 50: clicks on the button to play the quiz. The view should change to the QuizAcitvity class.  
Line 51: checks if the QuizActivity class is displayed on the screen.
 
 &nbsp;
 
**Test method scoreUpdatesCorrectly1():**  
This test opens the quiz activity and chooses the correct answer. It tests if the score gets tracked correctly.  

Line 57: launches the QuizActivity class.  
Line 60: Casting the current activity to type QuizActivity, because we know it is.  
Line 61: References the current QuizCard displayed in the activity.  
Line 62: References the correct answer of this  QuizCard  
Line 64 to 66: References to the 3 possible Button alternatives in the quiz activity.  
Line 68 to 74: Clicks on the correct alternative  
Line 77: Checks if the TextView containing the score matches to "1 out of 1 correct".  

&nbsp;

**Test method scoreUpdatesCorrectly2():**  
The test class is configured to run the tests in a specific order, so scoreUpdatesCorrectly2 will always run after scoreUpdatesCorrectly1. This is because it depends on it.  
scoreUpdatesCorrectly2 does the same as scoreUpdatesCorrectly1, but chooses the wrong answer instead.  

The code is almost identical to scoreUpdatesCorrectly1, except that it clicks on a wrong alternative instead.  
And at the end it checks if the TextView matches "1 out of 2 correct".  

&nbsp;

**Test method addNewCardUpdatesDatabase():**  
This test checks if adding a new QuizCard correctly saves it in the Room database.  

Line 106: launches the DatabaseActivity class.  
Line 107: Casting the current activity to type DatabaseActivity.   
Line 110: Create a new list *sizes* with Integers. Each list element says how many QuizCard entries there are in the database.  
Line 112 to 118: Observing changes in the database for the QuizCard table. It is done through DatabaseActivity's viewModel.  
Line 113: If there is a change, the new amount of QuizCards will be added to the *sizes* list.  
Line 115 to 117: If a new QuizCard gets added, it tests if the size of the database table has increased by 1. Because the observing is an asynchronous function, these lines will be ran after a new QuizCard has been added.  
Line 120 to 121: Adds a new QuizCard to the database through one of DatabaseActivity's methods.  

![image](https://user-images.githubusercontent.com/21562012/222832723-6affdc0f-d4ab-403b-b208-0c8fb983c30a.png)
&nbsp;  

# Oblig 2 task 3:
