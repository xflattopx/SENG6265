package project.property;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PropertyLoader {

    public static ArrayList<Property> loadProperties(String filePath) {
        Gson gson = new Gson();
        ArrayList<Property> properties = null;

        try (Reader reader = new FileReader(filePath)) {
            // Define the type for ArrayList<Property>
            Type propertyListType = new TypeToken<ArrayList<Property>>() {}.getType();

            // Deserialize JSON to ArrayList<Property>
            properties = gson.fromJson(reader, propertyListType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }
}