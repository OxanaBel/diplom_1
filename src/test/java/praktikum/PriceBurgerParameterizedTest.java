package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class PriceBurgerParameterizedTest {

    private final float priceBun;
    private final List<Float> ingredientPrices;
    private final float amount;

    public PriceBurgerParameterizedTest(float priceBun, List<Float> ingredientPrices, float amount) {
        this.priceBun = priceBun;
        this.ingredientPrices = ingredientPrices;
        this.amount = amount;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {200f, List.of(250f, 150f, 400f, 200f), 1400f},
                {100f, List.of(250f, 150f, 400f), 1000f},
                {400f, List.of(250f, 150f), 1200f},
                {250f, List.of(250f), 750f},
        };
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("Бриошь", priceBun));
        for (Float price : ingredientPrices) {
            Ingredient ingredient = new Ingredient(FILLING, "Ингридиент", price);
            burger.addIngredient(ingredient);
        }
        assertEquals(burger.getPrice(), amount, 0f);
    }
}
