package complex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Gson gson;

    public JsonHelper() {


    }

    public List<Dish> readFromFile(String fileName) {
        List<Dish> dishList = new ArrayList<>();
       try {
           FileInputStream fileInputStream = new FileInputStream(fileName);

           Reader reader = new InputStreamReader(fileInputStream);
           gson = new GsonBuilder().create();
           Dish dish = gson.fromJson(reader, Dish.class);
           dishList.add(dish);
       }catch (Exception e){
           e.printStackTrace();
       }

        return dishList;
    }

    public void writeToFile(String fileName, List<Dish> dishes) {

        try {
            Writer writer = new FileWriter(fileName);

            gson = new GsonBuilder().create();
            gson.toJson(dishes.get(0), writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
