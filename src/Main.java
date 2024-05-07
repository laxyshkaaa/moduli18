import java.util.Arrays;
import java.util.Scanner;

interface SortCondition<T> {
    int compare(T a, T b);
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        Integer[] array = new Integer[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Сортировка по возрастанию
        sort(array, (a, b) -> a.compareTo(b));
        System.out.println("Отсортированный массив по возрастанию:");
        System.out.println(Arrays.toString(array));

        // Сортировка по убыванию
        sort(array, (a, b) -> b.compareTo(a));
        System.out.println("Отсортированный массив по убыванию:");
        System.out.println(Arrays.toString(array));

    }

    public static <T> void sort(T[] array, SortCondition<T> condition) {
        for (int i = 1; i < array.length; i++) {
            T currentElement = array[i];
            int j = i - 1;
            while (j >= 0 && condition.compare(array[j], currentElement) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentElement;
        }
    }
}