package complex.objects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DishTest {

    @Test
    public void testAddToDish() {
        Dish borsh = new Dish("Борщ", DishCategory.FIRST);
        borsh.addToDish(new Ingredient("beet", 100), 1.0);
        borsh.addToDish(new Ingredient("potatoes", 1.00), 1.0);
        borsh.addToDish(new Ingredient("meat", 40.0), 0.5);

        Assert.assertEquals(borsh.getDishPrice(),121d,"wrong dish price");

        borsh.addToDish(new Ingredient("potatoes", 1.00), 1.0);

        Assert.assertEquals(borsh.getDishPrice(),122d,"wrong adding to dish");



    }

}