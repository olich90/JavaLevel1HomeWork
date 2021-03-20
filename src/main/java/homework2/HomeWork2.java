package homework2;

public class HomeWork2 {
    public static void main(String[] args) {
        /* 1 */ invertArr();
        /* 2 */ fillArr();
        /* 3 */ changeArr();
        /* 4 */ fillMatrix();
        /* 5 */ searchMinMax();

        //6
        int[] array = {0, 5, 2, 2, 1};
        boolean a = checkBalance(array);
        System.out.println("\nЕсть ли в массиве место, в котором сумма левой и правой его частей равны? " + a);
        //6

        //7
        int[] m = {1, 2, 3, 4, 5};
        int n = 1;
        moveValOfArr(m, n); // работает только для n = 1 и n = 2. долго бился, но для универсального решения ума не хватило,
        // но чувствую, что истина где-то рядом.. -_-
        //7
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}.
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void invertArr() {
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив:        ");
        for (byte b : array) System.out.print(b + " ");

        System.out.print("\nИнвертированный массив: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
            System.out.print(array[i] + " ");
        }
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями {0, 3, 6, 9, 12, 15, 18, 21};
    public static void fillArr() {
        int[] array = new int[8];
        System.out.print("\n\nЗаполненный массив размером 8: " + array[0] + " ");
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + 3;
            System.out.print(array[i] + " ");
        }
    }

    // 3. Задать массив {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1} пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArr() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("\n\nИсходный массив  : ");
        for (int b : array) System.out.print(b + "  ");

        System.out.print("\nИзмененный массив: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
            System.out.print(array[i] + "  ");
        }
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillMatrix() {
        int[][] array = new int[9][9];
        System.out.println("\n\nИсходный массив:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int a = 0, l = array.length - 1;
        System.out.println("\nИзмененный массив (единицы по диагонали):");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[a][a] = 1;
                array[a][l] = 1;
                System.out.print(array[i][j] + " ");
            }
            a += 1;
            l -= 1;
            System.out.println();
        }
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void searchMinMax() {
        int[] array = new int[7];
        System.out.print("\nЭлементы массива: ");
        for (int i = 0; i < array.length; i++) { // заполним массив рандомными значениями: минимальное 0, максимальное 99
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        int max, min;
        max = min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
            if (min > array[i]) min = array[i];
        }
        System.out.println("\nМаксимальный элемент = " + max);
        System.out.println("Минимальный элемент = " + min);

    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
    // checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] array) {
        int i = array[0]; // сохраним в переменную значение первого элемента
        int sum = 0;
        boolean z = false;
        for (int j = 1; j < array.length; j++) { // определим сумму значений элементов от 2 до последнего
            sum += array[j];
        }
        for (int j = 1; j < array.length; j++) {
            if (i != sum) {      // если значение первого элемента не равно сумме значений остальных элементов,
                i += array[j];   // то увеличим значение первого элемента на величину второго элемента,
                sum -= array[j]; // а сумму убавим на величину второго элемента, и т.д.
            } else z = true;     // если в случае перебора массива будет равество - вернем true, иначе - false
        }
        return z;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void moveValOfArr(int[] m, int n) {
        System.out.println("\nИсходный массив: ");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
        }
        System.out.println();
        int c = 0; // для временного хранения замещаемого элемента 1
        int d = 0; // для временного хранения замещаемого элемента 1
        int l = m.length; // длина массива
        int z = 0; // вспомогательный параметр для обработки цикла 1
        int x = 1; // вспомогательный параметр для обработки цикла 1
        int nn = n; // сохраним исходное значение n
        for (int i = 0; i < m.length; i++) {
            c = m[i];
            if(l - n == m.length) break;
            m[i] = m[l - n];
            if (z + 1 != nn || n == 1) {
                for (int j = 0; j < m.length - n; j++) {
                    if(n == nn){d = m[j + x + z];}
                    else { if(d == m.length) break; d = m[j + x + z-1];}
                    if(j + x == m.length) break; m[j + x] = c;
                    c = d;
                }
                z++;
                x++;
            }
            n--;
        }
        System.out.println("Измененный массив: ");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
        }
    }
}