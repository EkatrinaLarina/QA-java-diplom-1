import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.ArgumentMatchers.eq;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunTest(){
        Bun bun = new Bun("bun", 123F);
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredientTest(){
        Ingredient ingredient = new Ingredient(FILLING, "krevetka", 777F);
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(0,1);
        Mockito.verify(burger).moveIngredient(Mockito.anyInt(), eq(1));
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(15F);
        Mockito.when(ingredient.getPrice()).thenReturn(350F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedPrice=1430F;
        Assert.assertEquals("Ожидаемая цена " + expectedPrice, expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getName()).thenReturn("Krevetka");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== Bun ====)\r\n" +
                "= filling Krevetka =\r\n" +
                "(==== Bun ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        Assert.assertEquals("Ожидаемый рецепт" + expectedReceipt, expectedReceipt, burger.getReceipt());
    }
}
