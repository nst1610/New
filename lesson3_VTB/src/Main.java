//    1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
//    MyArrayDataException (в ячейке массива лежит что-то не то);
//    2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером
//    4×4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//    3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//    просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//    ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//    MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
//    данных для этой матрицы прекращается.
//    4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
//    MySizeArrayException и MyArrayDataException и вывести результат расчёта.

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };

        try {
            System.out.println(sumOfMatrixElements(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int sumOfMatrixElements(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if((matrix.length != 4) || !isMatrix(matrix)) {
            throw new MyArraySizeException("Неправильный размер матрицы.");
        } else {
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    try {
                        sum += Integer.valueOf(matrix[i][j]);
                    }
                    catch (NumberFormatException e){
                        throw new MyArrayDataException("В ячейке [" + i + ", " + j + "] что-то не то.");
                    }
                }
            }
        }
        return sum;
    }

    public static boolean isMatrix(String[][] array){
        for (int i = 0; i < array.length; i++){
            if(array[i].length != array.length){
                return false;
            }
        }
        return true;
    }
}