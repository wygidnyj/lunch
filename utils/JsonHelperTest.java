package complex.utils;

import complex.objects.Dish;
import complex.objects.DishCategory;
import complex.objects.Ingredient;
import complex.objects.Menu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsonHelperTest {
    private Menu menu;
    private String fileName = "test.json";
    private String jSon = "{\"dishList\":[{\"dishName\":\"Борщ\",\"dishPrice\"" +
            ":20.0,\"dishCategory\":\"FIRST\",\"ingredients\":" +
            "[{\"ingredientName\":\"beet\",\"ingredientPrice\":10.0},{\"ingredientName\":" +
            "\"potatoes\",\"ingredientPrice\":10.0}]},{\"dishName\":\"Гречка\"" +
            ",\"dishPrice\":20.0,\"dishCategory\":\"SECOND\",\"ingredients\":" +
            "[{\"ingredientName\":\"beet\",\"ingredientPrice\":10.0}" +
            ",{\"ingredientName\":\"potatoes\",\"ingredientPrice\":10.0}]}" +
            ",{\"dishName\":\"Чай\",\"dishPrice\":20.0,\"dishCategory\":" +
            "\"DRINK\",\"ingredients\":[{\"ingredientName\":\"carrots\"," +
            "\"ingredientPrice\":10.0},{\"ingredientName\":\"onion\",\"" +
            "ingredientPrice\":10.0}]}]}";
    @BeforeClass
    public void setUp() throws Exception {
        menu = new Menu();


        Dish borsh = new Dish("Борщ", DishCategory.FIRST);
        borsh.addToDish(new Ingredient("beet", 10), 1.0);
        borsh.addToDish(new Ingredient("potatoes", 10),1.0);

        menu.addDish(borsh);

        Dish kasha = new Dish("Гречка", DishCategory.SECOND);
        kasha.addToDish(new Ingredient("beet", 10), 1.0);
        kasha.addToDish(new Ingredient("potatoes", 10), 1.0);

        menu.addDish(kasha);

        Dish tea = new Dish("Чай", DishCategory.DRINK);
        tea.addToDish(new Ingredient("carrots", 10), 1.0);
        tea.addToDish(new Ingredient("onion", 10), 1.0);
        menu.addDish(tea);



    }

    @Test
    public void toJson(){

        Assert.assertEquals(JsonHelper.jsonToMenu(jSon),menu,"unexpected " +
                "behavior in method jsonToMenu");
    }
    @Test
    public void fromJson(){
        String actualFromJson = JsonHelper.menuToJson(menu);

        Assert.assertEquals(actualFromJson,jSon,"unexpected behavior" +
                " in method menuToJson");

    }

    @Test
    public void testReadFromFile() throws Exception {

        String actualFromJson = JsonHelper.menuToJson(
                JsonHelper.readFromJson(fileName));
        Assert.assertEquals(actualFromJson,jSon,"wrong data from JSON");
    }

    @Test
    public void testWriteToFile() throws Exception {

        Assert.assertEquals(JsonHelper.writeToJson(fileName, menu)
                ,true,"writeToJson error");
    }

}