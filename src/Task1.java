import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

public class Task1 {
    
    private Path pathFile;
    
    public Task1 (Path pathFile) {
        this.pathFile = pathFile;
    }

    public Task1 start(){
        try {
            List<String> allLines = Files.readAllLines(pathFile);
            for (String line : allLines) {
                //Убираем все символы в строке кроме скобок
                String newLine = line.replaceAll("[^\\[\\]\\{\\}\\(\\)]", "");
                
                if(isValid(newLine)){
                    System.out.println(line + " правильная скобочная последовательность");
                } else {
                    System.out.println(line + " неправильная скобочная последовательность");
                }
                
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        //Возращаю текущий объект для удобства вызова
        return this;
    } 

    private boolean isValid(String line){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if(!stack.isEmpty()){
                char lastSymbol = stack.peek();
                /*
                 * Если текущая строка является закрывающей скобкой, то прошлая скобка должна быть открывающей.
                 * Если символы совпадают и являются парой то убираем из стека.
                 */
                if(isPair(current, lastSymbol)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(current);
        }

        return stack.isEmpty();
    }

    private boolean isPair(char current, char last){
        return (current == ')' && last == '(') ||
               (current == ']' && last == '[') ||
               (current == '}' && last == '{');
    }
}
