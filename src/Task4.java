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
            boolean isEqual = true;
            List<String> allLines = Files.readAllLines(pathFile);

            if(allLines.size() != 6){
                System.out.println("Входные данные некорректны!");
                return;
            }

            Map<String,Integer> sides = new HashMap<>();
            Map<Integer,Integer> valueCount = new HashMap<>();
            for (String line : allLines) {
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);

                int max = Math.max(a, b);
                int min = Math.min(a, b);

                if(max < 1 || max > 1000 || min < 1 || min > 1000){
                    System.out.println("Невозможно!");
                    return;
                }

                if(max != min){
                    isEqual = false;
                }

                String key = max + "x" + min;
                valueCount.put(max, valueCount.getOrDefault(max, 0) + 1);
                valueCount.put(min, valueCount.getOrDefault(min, 0) + 1);
                sides.put(key, sides.getOrDefault(key,0) + 1);
            }
            
            if(sides.values().stream().anyMatch(value -> value % 2 != 0) || (!isEqual && sides.size() == 1)){
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

            for (Integer value : valueCount.values()) {
                if(value % 4 != 0){
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
