package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Ingredient ingredient, addIngredient;

    @Mock
    Bun bun;
    private int index;
    private float bunPrice =  (float) Math.random()*100;
    private float ingredientsPrice = (float) Math.random()*100;
    private float burgerPrice = bunPrice * 2 + ingredientsPrice;
    private String bunName = "Булка";
    private String ingredientsName = "Начинка";
    private String expectedReceipt = String.format("(==== %s ====)%n", bunName)+
            String.format("= sauce %s =%n", ingredientsName)+
            String.format("(==== %s ====)%n", bunName) + "" +
            String.format("%nPrice: %f%n", burgerPrice);

    @Before
    public void start(){
        burger = new Burger();
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        assertFalse(burger.ingredients.contains(ingredient));
    }
    @Test
    public void moveIngredientTest(){
        int newIndex = 1;
        burger.addIngredient(ingredient);
        burger.addIngredient(addIngredient);
        index = burger.ingredients.indexOf(ingredient);
        burger.moveIngredient(index, newIndex);
        assertEquals(newIndex, burger.ingredients.indexOf(ingredient));
    }
    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientsPrice);
        assertEquals(burgerPrice, burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientsPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientsName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        System.out.println(burger.getReceipt());
        System.out.println(expectedReceipt);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
