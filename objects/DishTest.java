package complex.objects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DishTest {
    @Test
    public void testAddToDish() {
        Dish borsh = new Dish("����", DishCategory.FIRST);
        borsh.addToDish(new Ingredient("beet", 100), 1.0);
        borsh.addToDish(new Ingredient("potatoes", 1.00), 1.0);
        borsh.addToDish(new Ingredient("meat", 40.0), 0.5);

        Assert.assertEquals(borsh.getDishPrice(),121d,"wrong dish price");

    }
    @Test
    public void  addTwoSameProduct(){
        Dish tea = new Dish("Tea",DishCategory.DRINK);
        tea.addToDish(new Ingredient("Tea",100),1.0);
        tea.addToDish(new Ingredient("Tea",100),1.0);

        Assert.assertEquals(tea.getNumberOfIngredients(),1
                ,"adding same ingredients don't  work");

        tea.addToDish(new Ingredient("Water",1),1.0);

        Assert.assertEquals(tea.getNumberOfIngredients(),2
                ,"adding  ingredients don't  work");

    }

}