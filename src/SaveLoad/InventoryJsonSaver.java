package SaveLoad;

import com.google.gson.Gson;
import setting.Inventory;

import java.io.FileWriter;
import java.io.IOException;

public class InventoryJsonSaver {
    private static final String FILE_PATH = "DB/InventoryData.json";

    public static void saveData(Inventory inventory) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(inventory, writer);
            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
