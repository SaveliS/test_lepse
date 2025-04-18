import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        new Task1(Path.of("test_file\\test1.txt")).start();
        new Task2(new int[][] {{3,5,2},{4,1,6},{7,8,9}}).start();
        new Task3().start("unchanged");
        new Task3().start("tryToConvertMe");
        new Task3().start("some_variable");
        new Task3().start("InvalidMethod");
        new Task3().start("bad_VarName");
        new Task4(Path.of("test_file\\test2.txt")).start();
    }
}
