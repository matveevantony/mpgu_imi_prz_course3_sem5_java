import java.util.Scanner;

public class pract_08_01 {
    // Главный метод класса
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ввод размерности массива
        int n;
        boolean nIsCorrent = false;
        System.out.print("Введите размерность массива (от 3 до 15): ");
        do {
            n = in.nextInt();
            if (n >= 3 && n <= 15) {
                nIsCorrent = true;
            }
            else {
                System.out.print("Введено некорректное значение. Повторите ввод: ");
            }
        } while (!nIsCorrent);

        int[] array = new int[n];                                                       // инициализация массива
        
        // Определение способа заполнения массива
        int inputMethod;
        boolean inputMethodIsCorrect = false;
        System.out.print("Выберите способ заполнения массива:\n1 - консольное заполнение;\n2 - заполнение (псевдо)случаными значениями.\nВаш выбор: ");
        do {
            inputMethod = in.nextInt();
            switch (inputMethod) {
                case 1:
                    inputMethodIsCorrect = true;
                    consoleArrayInput(array, in);                                       // консольное заполнение массива
                    break;
                case 2:
                    inputMethodIsCorrect = true;
                    randomArrayInput(array);                                            // заполнение массива (псевдо)случайными числами
                    break;
                default:
                    System.out.print("Введено некорректное значение. Повторите ввод: ");
            }
        } while (!inputMethodIsCorrect);

        printIntArray(array);                                                           // вывод заполненного массива на экран

        // Определение направления сортировки
        int sortDirection;
        boolean sortDirectionIsCorrect = false;
        System.out.print("Выберите направление сортировки массива:\n1 - в порядке неубывания;\n2 - в порядке невозрастания;\nВаш выбор: ");
        do {
            sortDirection = in.nextInt();
            switch (sortDirection) {
                case 1:
                    sortDirectionIsCorrect = true;
                    break;
                case 2:
                    sortDirectionIsCorrect = true;
                    break;
                default:
                    System.out.print("Введено некорректное значение. Повторите ввод: ");
            }
        } while (!sortDirectionIsCorrect);

        // Определение способа сортировки массива
        int sortMethod;
        boolean sortMethodIsCorrect = false;
        System.out.print("Выберите способ сортировки массива:\n1 - пузырьковая сортировка;\n2 - сортировка выбором;\n3 - сортировка вставками;\n4 - сортировка Шелла;\n5 - пирамидальная сортировка\nВаш выбор: ");
        do {
            sortMethod = in.nextInt();
            switch (sortMethod) {
                case 1:
                    sortMethodIsCorrect = true;
                    bubbleSort(array, sortDirection);                                   // пузырьковая сортировка
                    break;
                case 2:
                    sortMethodIsCorrect = true;
                    choiceSort(array, sortDirection);                                   // сортировка выбором
                    break;
                case 3:
                    sortMethodIsCorrect = true;
                    insertSort(array, sortDirection);                                   // сортировка вставками
                    break;
                case 4:
                    sortMethodIsCorrect = true;
                    shellSort(array, sortDirection);                                    // сортировка Шелла
                    break;
                case 5:
                    sortMethodIsCorrect = true;
                    pyramidSort(array, sortDirection);                                  // пирамидальная сортировка
                    break;
                default:
                    System.out.print("Введено некорректное значение. Повторите ввод: ");
            }
        } while (!sortMethodIsCorrect);

        printIntArray(array);                                                           // вывод отсортированного массива на экран

        // Ввод искомого в массиве числа
        int goal;
        System.out.print("Введите число, которое требуется найти в массиве: ");
        goal = in.nextInt();

        // Определение метода поиска
        int searchMethod;
        boolean searchMethodIsCorrect = false;
        int searchResult = -1;
        System.out.print("Выберите способ поиска в массиве:\n1 - линейный поиск;\n2 - бинарный поиск;\nВаш выбор: ");
        do {
            searchMethod = in.nextInt();
            switch (searchMethod) {
                case 1:
                    searchMethodIsCorrect = true;
                    searchResult = linearSearch(array, goal);                           // линейный поиск
                    break;
                case 2:
                    searchMethodIsCorrect = true;
                    searchResult = binarySearch(array, sortDirection, goal);            // бинарный поиск
                    break;
                default:
                    System.out.print("Введено некорректное значение. Повторите ввод: ");
            }
        } while (!searchMethodIsCorrect);

        // Вывод в консоль результата поиска
        if (searchResult != -1) {
            System.out.println("Искомый элемент присутствует в массиве и имеет индекс " + searchResult);
        }
        else {
            System.out.println("Искомый элемент отсутствует в массиве");
        }
    }

    // Статический метод консольного заполнения массива
    public static void consoleArrayInput(int[] array, Scanner in) {
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
    }

    // Метод заполнения массива (псевдо)случайными числами
    public static void randomArrayInput(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 199) - 99;
        }
    }

    // Метод вывода массива в консоль
    public static void printIntArray(int[] array) {
        System.out.println("Массив:");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[array.length - 1]);
    }

    // Метод пузырьковой сортировки массива
    public static void bubbleSort(int[] array, int sortDirection) {
        int tmp;
        switch (sortDirection) {
            case 1:
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] > array[j + 1]) {
                            tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] < array[j + 1]) {
                            tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
                break;
            default:
                System.out.println("Невозможно осуществить сортировку: неверно указано направление");
        }
    }

    // Метод сортировки массива выбором
    public static void choiceSort(int[] array, int sortDirection) {
        int tmp;
        switch (sortDirection) {
            case 1:
                int minId;
                for (int i = 0; i < array.length - 1; i++) {
                    minId = i;
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[j] < array[minId]) {
                            minId = j;
                        }
                    }
                    if (minId != i) {
                        tmp = array[i];
                        array[i] = array[minId];
                        array[minId] = tmp;
                    }
                }
                break;
            case 2:
                int maxId;
                for (int i = 0; i < array.length - 1; i++) {
                    maxId = i;
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[j] > array[maxId]) {
                            maxId = j;
                        }
                    }
                    if (maxId != i) {
                        tmp = array[i];
                        array[i] = array[maxId];
                        array[maxId] = tmp;
                    }
                }
                break;
            default:
                System.out.println("Невозможно осуществить сортировку: неверно указано направление");
        }
    }

    // Метод сортировки массива вставками
    public static void insertSort(int[] array, int sortDirection) {
        int tmp;
        switch (sortDirection) {
            case 1:
                for (int i = 1; i < array.length; i++) {
                    for (int j = i; (j > 0) && (array[j] < array[j - 1]); j--) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }
                }
                break;
            case 2:
                for (int i = 1; i < array.length; i++) {
                    for (int j = i; (j > 0) && (array[j] > array[j - 1]); j--) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }
                }
                break;
            default:
                System.out.println("Невозможно осуществить сортировку: неверно указано направление");
        }
    }

    // Метод сортировки Шелла
    public static void shellSort(int[] array, int sortDirection) {
        int tmp;
        switch (sortDirection) {
            case 1:
                for (int step = array.length / 2; step > 0; step /= 2) {
                    for (int i = step; i < array.length; i++) {
                        tmp = array[i];
                        int j;
                        for (j = i; j >= step; j -= step) {
                            if (tmp < array[j - step]) {
                                array[j] = array[j - step];
                            }
                            else {
                                break;
                            }
                        }
                        array[j] = tmp;
                    }
                }
                break;
            case 2:
                for (int step = array.length / 2; step > 0; step /= 2) {
                    for (int i = step; i < array.length; i++) {
                        tmp = array[i];
                        int j;
                        for (j = i; j >= step; j -= step) {
                            if (tmp > array[j - step]) {
                                array[j] = array[j - step];
                            }
                            else {
                                break;
                            }
                        }
                        array[j] = tmp;
                    }
                }
                break;
            default:
                System.out.println("Невозможно осуществить сортировку: неверно указано направление");
        }
    }

    // Метод пирамидальной сортировки массива
    public static void pyramidSort(int[] array, int sortDirection) {
        int tmp;
        switch (sortDirection) {
            case 1:
                for (int i = array.length - 1; i >= 0; i--) {
                    heapifyUp(array, 0, i);
                    tmp = array[i];
                    array[i] = array[0];
                    array[0] = tmp;
                }
                break;
            case 2:
                for (int i = array.length - 1; i >= 0; i--) {
                    heapifyDown(array, 0, i);
                    tmp = array[i];
                    array[i] = array[0];
                    array[0] = tmp;
                }
                break;
            default:
                System.out.println("Невозможно осуществить сортировку: неверно указано направление");
        }
    }
    public static void heapifyUp(int[] array, int topId, int endId) {                   // метод сортировки бинарной кучи по возрастанию
        int tmp;
        for (int i = endId; i >= topId; i--) {
            if (i *2 + 1 <= endId && i *2 + 2 <= endId) {
                int maxId = i;
                if (array[i *2 + 1] > array[maxId]) {
                    maxId = i *2 + 1;
                }
                if (array[i *2 + 2] > array[maxId]) {
                    maxId = i *2 + 2;
                }
                if (maxId != i) {
                    tmp = array[maxId];
                    array[maxId] = array[i];
                    array[i] = tmp;
                    heapifyUp(array, maxId, endId);
                }
            } else {
                if (i *2 + 1 <= endId && i *2 + 2 > endId) {
                    if (array[i] < array[i *2 + 1]) {
                        tmp = array[i];
                        array[i] = array[i *2 + 1];
                        array[i *2 + 1] = tmp;
                    }
                }
            }
        }
    }
    public static void heapifyDown(int[] array, int topId, int endId) {                 // метод сортировки бинарной кучи по убыванию
        int tmp;
        for (int i = endId; i >= topId; i--) {
            if (i *2 + 1 <= endId && i *2 + 2 <= endId) {
                int minId = i;
                if (array[i *2 + 1] < array[minId]) {
                    minId = i *2 + 1;
                }
                if (array[i *2 + 2] < array[minId]) {
                    minId = i *2 + 2;
                }
                if (minId != i) {
                    tmp = array[minId];
                    array[minId] = array[i];
                    array[i] = tmp;
                    heapifyDown(array, minId, endId);
                }
            } else {
                if (i *2 + 1 <= endId && i *2 + 2 > endId) {
                    if (array[i] > array[i *2 + 1]) {
                        tmp = array[i];
                        array[i] = array[i *2 + 1];
                        array[i *2 + 1] = tmp;
                    }
                }
            }
        }
    }

    // Метод линейного поиска в массиве
    public static int linearSearch(int[] array, int goal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == goal) {
                return i;
            }
        }
        return -1;
    }

    // Метод бинарного поиска в массиве
    public static int binarySearch(int[] array, int sortDirection, int goal) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;
        switch (sortDirection) {
            case 1:
                while (left <= right) {
                    if (goal < array[middle]) {
                        right = middle - 1;
                        middle = (left + right) / 2;
                    }
                    else {
                        if (goal > array[middle]) {
                            left = middle + 1;
                            middle = (left + right) / 2;
                        }
                        else {
                            return middle;
                        }
                    }
                }
                break;
            case 2:
                while (left <= right) {
                    if (goal < array[middle]) {
                        left = middle + 1;
                        middle = (left + right) / 2;
                    }
                    else {
                        if (goal > array[middle]) {
                            right = middle - 1;
                            middle = (left + right) / 2;
                        }
                        else {
                            return middle;
                        }
                    }
                }
                break;
            default:
                System.out.println("Невозможно осуществить поиск: неверно указано направление сортировки");
        }
        return -1;
    }
}
