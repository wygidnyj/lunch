package complex.utils;

import complex.objects.Menu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JsonHelperTest {
    private Menu menu;
    private String fileName = "test.json";

    @BeforeClass
    public void setUp() throws Exception {
        menu = new Menu();
        menu.fillDishList();

    }

    @Test
    public void testReadFromFile() throws Exception {

        menu = new Menu();
        menu.fillDishList();
        Assert.assertEquals(JsonHelper.readFromFile(fileName)
                ,menu,"wrong data from file");
    }

    @Test
    public void testWriteToFile() throws Exception {

        Assert.assertEquals(JsonHelper.writeToFile(fileName,menu)
                ,true,"writeToFile error");
    }

}