# Michael Cui's Subway Nutrition Calculator

## What will the application do?

The application will track the nutrition values of the Subway sandwich you make. Depending on the ingredients you select
it wil generate the **calories, protein, sugar** and such contents.

## Who will use it?

- Subway Customer
- Dietitian
- Subway Employee

## Why is this project of interest to me?

This project has a special meaning due to my experience tracking nutrition in my diet. As a teenager, I was always
overweight. One day, I decided that I had enough of it and began my weight loss journey. This started with tracking my
calories, and I found it very helpful when restaurants post their calories count. However, Subway is very tricky as you
get to decide the ingredients, which causes the nutrition count to fluctuate. Therefore, I am making this application
to make this process easier and convenient.

## User Stories

- As a user, I want to be able to create a new sandwich.
- As a user, I want to be able to view what is in my sandwich.
- As a user, I want to be able to save a sandwich and view it later.
- As a user, I want to be able to add ingredients into my new sandwich.
- As a user, I want to be able to remove an ingredient from my sandwich.
- As a user, I want to be able to see the nutrition value of my sandwich.
- As a user, I want to be able to load my previous sandwich and make adjustments.
- As a user, I want to be reminded and given the option to save my sandwich or not.

# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by typing in something and press add
- You can generate the second required action related to adding Xs to a Y by selecting a ingredient and clicking remove
- You can locate my visual component by display image
- You can save the state of my application by pressing save when done making sandwich
- You can reload the state of my application by clicking modifyExistingSandwich

# Phase 4: Task 2

Ingredient test ingredient 1 added to Sandwich.
Ingredient test ingredient 2 added to Sandwich.
Ingredient test ingredient 3 added to Sandwich.
Ingredient test ingredient 1 removed from Sandwich.
Sandwich Test Sandwich! added to ListOfSandwich.

Instruction:

- Run SandwichBuilderMenu
- Select Create New Sandwich
- Add the ingredients wanted, remove if wanted.
- Press Done afterwards
- Give the sandwich a name and save it.
- Close the application!
- Thank you :D

# Phase 4: Task 3

Refactoring:
It would have been a good idea to create an abstract class because of how similar my CreateSandwich
and my ModifySandwich classes were. For instance, they both create the same frame with an add and remove button, the 
only thing different would be the elements in the list which do not affect the design. Therefore, having an abstract 
class would significantly reduce the amount of code duplication. Another advantage of this refactoring would be that 
it will take less time to implement future changes to the UI package. It would be much quicker to make changes in the 
abstract methods than to implement it separately. This way it also lessens the risks of mistakes!

