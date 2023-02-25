package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SandwichTest {

    private Sandwich testSandwich;


    @BeforeEach
    void runbefore(){
        testSandwich = new Sandwich("random");

    }

    @Test
    void testAddIngredient() {
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        testSandwich.addIngredient(steak);
        Ingredient first = testSandwich.getIngredient(0);
        Assertions.assertEquals(steak, first);
    }

    @Test
    void testAllIngredient() {
        List<String> display = new ArrayList<>();
        display.add("Steak");
        display.add("Provolone");
        display.add("White Bread");
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        Ingredient cheese = new Ingredient ("Provolone", 50, 5, 1);
        Ingredient bread = new Ingredient ("White Bread", 220, 1, 5);
        testSandwich.addIngredient(steak);
        testSandwich.addIngredient(cheese);
        testSandwich.addIngredient(bread);
        Assertions.assertEquals(display, testSandwich.allIngredients());
    }

    @Test
    void testRemoveIngredient() {
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        Ingredient cheese = new Ingredient ("Provolone", 50, 5, 1);
        Ingredient bread = new Ingredient ("White Bread", 220, 1, 5);
        testSandwich.addIngredient(steak);
        testSandwich.addIngredient(cheese);
        testSandwich.addIngredient(bread);
        int original = testSandwich.sandwich.size();
        testSandwich.removeIngredient(1);
        int later = testSandwich.sandwich.size();
        List<Ingredient> sando = new ArrayList<>();
        sando.add(steak);
        sando.add(bread);

        Assertions.assertEquals(later, original - 1);
        Assertions.assertEquals(testSandwich.sandwich, sando);
    }

    @Test
    void testCalculateTotalCal() {
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        Ingredient cheese = new Ingredient ("Provolone", 50, 5, 1);
        Ingredient bread = new Ingredient ("White Bread", 220, 1, 5);
        testSandwich.addIngredient(steak);
        testSandwich.addIngredient(cheese);
        testSandwich.addIngredient(bread);
        Assertions.assertEquals(490, testSandwich.calculateTotalCalories());
    }

    @Test
    void testCalculateTotalPro() {
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        Ingredient cheese = new Ingredient ("Provolone", 50, 5, 1);
        Ingredient bread = new Ingredient ("White Bread", 220, 1, 5);
        testSandwich.addIngredient(steak);
        testSandwich.addIngredient(cheese);
        testSandwich.addIngredient(bread);
        Assertions.assertEquals(21, testSandwich.calculateTotalProtein());
    }
    @Test
    void testCalculateTotalSug() {
        Ingredient steak = new Ingredient ("Steak", 220, 15, 5);
        Ingredient cheese = new Ingredient ("Provolone", 50, 5, 1);
        Ingredient bread = new Ingredient ("White Bread", 220, 1, 5);
        testSandwich.addIngredient(steak);
        testSandwich.addIngredient(cheese);
        testSandwich.addIngredient(bread);
        Assertions.assertEquals(11, testSandwich.calculateTotalSugar());
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("random", testSandwich.getName());
    }

}
