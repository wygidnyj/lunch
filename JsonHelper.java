package complex;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Gson gson;

    public JsonHelper() {
        gson = new Gson();

    }

    public List<Dish> readFromFile(String fileName) {
        List<Dish> dishList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName));

            Dish dishObject = gson.fromJson(br, Dish.class);
            dishList.add(dishObject);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishList;
    }

    public void writeToFile(String fileName, List<Dish> dishes) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Dish dish : dishes) {
                String content = gson.toJson(dish, Dish.class);
                writer.write(content);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
