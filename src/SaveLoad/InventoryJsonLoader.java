package SaveLoad;

import com.google.gson.Gson;
import setting.Inventory;

import java.io.FileReader;
import java.io.IOException;

public class InventoryJsonLoader {
    private static final String FILE_PATH = "db/InventoryData.json";

    public static Inventory loadData() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Inventory.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}