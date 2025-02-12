package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testIngredient() {
        IngredientType expectedType = IngredientType.SAUCE;
        String expectedName = "Шрирача";
        float expectedPrice = 305;
        Ingredient actual = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, actual.getType());
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedPrice, actual.getPrice(), 0f);
    }
}
