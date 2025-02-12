package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerReceiptParameterizedTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String receipt;

    public BurgerReceiptParameterizedTest(Bun bun, List<Ingredient> ingredients, String receipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.receipt = receipt;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {new Bun("Бриошь", 200f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "Шрирача", 305f)
                        ),
                                "(==== Бриошь ====)" + System.lineSeparator() +
                                "= sauce Шрирача =" + System.lineSeparator() +
                                "(==== Бриошь ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 705,000000" + System.lineSeparator()},

                {new Bun("Чиабатта", 400f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "Майонез", 365f),
                                new Ingredient(IngredientType.FILLING, "Котлета", 500f)
                        ),
                                "(==== Чиабатта ====)" + System.lineSeparator() +
                                "= sauce Майонез =" + System.lineSeparator() +
                                "= filling Котлета =" + System.lineSeparator() +
                                "(==== Чиабатта ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 1665,000000" + System.lineSeparator()},

                {new Bun("Фокачча", 450f),
                        List.of(
                                new Ingredient(IngredientType.FILLING, "Котлета из мраморной говядины", 1000f),
                                new Ingredient(IngredientType.SAUCE, "Майонез", 365f),
                                new Ingredient(IngredientType.FILLING, "Сыр", 150f)
                        ),
                                "(==== Фокачча ====)" + System.lineSeparator() +
                                "= filling Котлета из мраморной говядины =" + System.lineSeparator() +
                                "= sauce Майонез =" + System.lineSeparator() +
                                "= filling Сыр =" + System.lineSeparator() +
                                "(==== Фокачча ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 2415,000000" + System.lineSeparator()},
        };
    }

    @Test
    public void testBurgerReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients = ingredients;
        assertEquals(burger.getReceipt(), receipt);
    }
}
