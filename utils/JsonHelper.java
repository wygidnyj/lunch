package complex.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
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

    /**
     * Return object Menu
     * @param fileName name of file we want to save menu
     * @return object Menu
     * @throws FileNotFoundException
     */

    public static Menu readFromFile(String fileName)
            throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);

        Reader reader = new InputStreamReader(fileInputStream);
        JsonReader jsonReader = new JsonReader(reader);
        Gson gson = new GsonBuilder().create();

       return  gson.fromJson(jsonReader, Menu.class);

    }

    /**
     * Save Menu object to JSON file
     * @param fileName name of file to store Menu object
     * @param menu Menu object we want to save in JSON
     * @throws IOException
     */

    public static boolean writeToFile(String fileName,
                                      Menu menu) throws IOException {

        Writer writer = new FileWriter(fileName);
        Gson gson = new GsonBuilder().create();
        gson.toJson(menu, writer);
        writer.close();

        return true;

    }

}
