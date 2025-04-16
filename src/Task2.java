public class Task2 {
    
    private int [][] matric;

    public Task2 (int [][] matric){
        this.matric = matric;
    }

    public Task2 start(){
        boolean found = false;
        int rows = matric.length;
        int columns = matric[0].length;

        int [] min_row = new int[rows];
        int [] max_columns = new int[columns];

        //Перебираем все элементы строки, чтобы найти минимальный в строке.
        for (int i = 0; i < rows; i++) {
            min_row[i] = matric[i][0];
            for (int j = 0; j < columns; j++) {
                if(matric[i][j] < min_row[i]){
                    min_row[i] = matric[i][j]; 
                }
            }
        }

        //Перебираем все элементы столбца, чтобы найти максимальный в столбце.
        for (int j = 0; j < columns; j++) {
            max_columns[j] = matric[0][j];
            for (int i = 1; i < rows; i++) {
                if (matric[i][j] > max_columns[j]) {
                    max_columns[j] = matric[i][j];
                }
            }
        }

        //Если минимальный и максимальный столбец, один и тот же то выводим "седловую точку".
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matric[i][j] == min_row[i] && matric[i][j] == max_columns[j]) {
                    System.out.println("Позиция: (" + i + ", " + j + "), Значение: " + matric[i][j]);
                    found = true;
                }
            }
        }

        if(!found)
            System.out.println("Седловых точек нет");


        return this;
    }
}
