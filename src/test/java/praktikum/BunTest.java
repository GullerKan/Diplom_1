package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    RandomBun randomBun = new RandomBun();
    Bun bun;
    String name = randomBun.getRandomBun().getName();
    float price = randomBun.getRandomBun().getPrice();
    @Before
    public void start(){
        this.bun = new Bun(name, price);
    }
    @Test
    public  void getNameTest (){
        assertEquals(name, bun.getName());
    }
    @Test
    public  void getPriceTest (){
        assertEquals(price, bun.getPrice(), 0);
    }
}
