package complex.objects;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComplexTest {
    private Complex complex;
    private Dish borsch;
    private Dish kasha;
    private Dish tea;

    @BeforeClass
    public void setUp() throws Exception {
        borsch = new Dish("Borsch",DishCategory.FIRST);
        borsch.addToDish(new Ingredient("voda",10.0),1.0);

        kasha = new Dish("Grechka",DishCategory.SECOND);
        kasha.addToDish(new Ingredient("voda",20.0),1.0);

        tea = new Dish("Tea",DishCategory.DRINK);
        tea.addToDish(new Ingredient("voda",30.0),1.0);

        complex = new Complex(borsch,kasha,tea);


    }

    @Test
    public void testGetFirst() throws Exception {

        Assert.assertEquals(complex.getFirst(),borsch,"not same first dish");

    }

    @Test
    public void testGetSecond() throws Exception {

        Assert.assertEquals(complex.getSecond(),kasha,"not same second dish");

    }

    @Test
    public void testGetDrink() throws Exception {

        Assert.assertEquals(complex.getDrink(),tea,"not same  drink");
    }

    @Test
    public void testGetPriceOfComplex() throws Exception {

        Assert.assertEquals(complex.getPriceOfComplex(),60d,"wrong price");

    }

}