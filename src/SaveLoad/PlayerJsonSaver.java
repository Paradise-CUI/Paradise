package SaveLoad;

import com.google.gson.Gson;
import setting.Player;

import java.io.FileWriter;
import java.io.IOException;

public class PlayerJsonSaver {
    private static final String FILE_PATH = "db/PlayerData.json";

    public static void saveData(Player player) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(player, writer);
            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
