import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    private Path pathFile;

    public Task4 (Path pathFile) {
        this.pathFile = pathFile;
    }

    public void start() {
        try {
            List<String> allLines = Files.readAllLines(pathFile);

            if(allLines.size() != 6){
                System.out.println("Входные данные некорректны!");
                return;
            }

            Map<String,Integer> sides = new HashMap<>();
            for (String line : allLines) {
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);

                int max = Math.max(a, b);
                int min = Math.min(a, b);

                String key = max + "x" + min;
                sides.put(key, sides.getOrDefault(key,0) + 1);
            }
            
            if(sides.values().stream().anyMatch(value -> value % 2 != 0)){
                System.out.println("Невозможно!");
                return;
            }
            
            String pastKey = "";
            for (String key : sides.keySet()) {
                boolean isComplianceSide = false;
                if(pastKey == ""){
                    pastKey = key;
                }

                for (String value : key.split("x")) {
                    if(pastKey.contains(value)){
                        isComplianceSide = true;
                    }
                }

                if(isComplianceSide == false){
                    System.out.println("Невозможно!");
                    return;
                }
            }

            System.out.println("Возможно");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
