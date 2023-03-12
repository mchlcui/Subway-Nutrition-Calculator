package persistence;

import model.Category;
import model.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;
//citation: used given example as sample code
public class JsonTest {
    protected void checkIngredient(String name, Category category, Ingredient ingredient) {
        assertEquals(name, ingredient.getName());
        assertEquals(category, ingredient.getCategory());
    }
}
