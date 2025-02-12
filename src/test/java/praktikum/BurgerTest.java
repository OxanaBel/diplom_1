package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient expected = new Ingredient(SAUCE, "Шрирача", 305);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "Шрирача", 305);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient expected1 = new Ingredient(SAUCE, "Шрирача", 305);
        Ingredient expected2 = new Ingredient(SAUCE, "Майонез", 350);
        burger.addIngredient(expected1);
        burger.addIngredient(expected2);

        burger.moveIngredient(0, 1);

        Ingredient actual1 = burger.ingredients.get(1);
        Ingredient actual2 = burger.ingredients.get(0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test(expected = NullPointerException.class)
    public void testGetPriceNpe() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(FILLING, "Ингридиент", 100);
        burger.addIngredient(ingredient);
        burger.getPrice();
    }

    @Test(expected = NullPointerException.class)
    public void testGetReceiptNpe() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(FILLING, "Ингридиент", 100);
        burger.addIngredient(ingredient);
        burger.getReceipt();
    }
}
