package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;
    public IngredientTest(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }
    @Parameterized.Parameters(name = "Тестовые данные: type = {0}, name = {1}, price = {2}")
    public  static Object [][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337}
        };
    }
    @Before
    public void start(){
       ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }
   @Test
    public void getPriceTest (){
        assertEquals(price, ingredient.getPrice(),0);
    }
   @Test
    public void getTypeTest (){
        assertEquals(type, ingredient.getType());
    }
}
