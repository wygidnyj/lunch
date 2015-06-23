package complex.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import complex.objects.Dish;
import complex.objects.Menu;

import java.io.*;

/**
 * The <code>JsonHelper</code> class contains two
 * useful method which help save and read Menu object from/to file
 * and methods. It cannot be instantiated.
 *@author avyhitc  exemple@gmail.com
 * @see Gson
 */

public class JsonHelper {
    private static Gson gson = new GsonBuilder().create();

    public static Menu readFromJson(String fileName)
            throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);

        Reader reader = new InputStreamReader(fileInputStream);
        JsonReader jsonReader = new JsonReader(reader);
        gson = new GsonBuilder().create();

       return  gson.fromJson(jsonReader, Menu.class);

    }


    public static boolean writeToJson(String fileName,
                                      Menu menu) throws IOException {

        Writer writer = new FileWriter(fileName);
        gson.toJson(menu, writer);
        writer.close();

        return true;

    }
    public static String menuToJson(Menu menu){

        return gson.toJson(menu,Menu.class);

    }
    public static Menu jsonToMenu(String json){
        return gson.fromJson(json,Menu.class);
    }

}
