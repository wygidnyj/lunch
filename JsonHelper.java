package complex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Gson gson;

    public JsonHelper() {


    }

    public Menu readFromFile(String fileName) {
        Menu menu = new Menu();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);

            Reader reader = new InputStreamReader(fileInputStream);
            JsonReader jsonReader = new JsonReader(reader);
            gson = new GsonBuilder().create();
            menu = gson.fromJson(jsonReader, Menu.class);




        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    public void writeToFile(String fileName, Menu menu) {

        try {
            Writer writer = new FileWriter(fileName);
            gson = new GsonBuilder().create();
           // for (Dish dish : dishes) {
                gson.toJson(menu, writer);
           // }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
