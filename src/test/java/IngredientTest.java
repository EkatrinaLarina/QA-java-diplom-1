import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataTest(){
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300}
        };
    }

    @Test
    public void IngredientGetPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента должна быть " + price, price, ingredient.getPrice(), 0);
        }

    @Test
    public void IngredientGetNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Наименование ингредиента должно быть  " + name, name, ingredient.getName());
    }

    @Test
    public void IngredientGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента должен быть  " + type, type, ingredient.getType());
    }
}

