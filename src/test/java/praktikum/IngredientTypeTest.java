package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void sauceNameTest(){
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
    @Test
    public void sauceCheckNumberTest(){
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }
    @Test
    public void fillingNameTest(){
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
    @Test
    public void fillingCheckNumberTest(){
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}
