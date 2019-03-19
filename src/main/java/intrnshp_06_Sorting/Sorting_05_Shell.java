package intrnshp_06_Sorting;

import java.util.Arrays;

public class Sorting_05_Shell {

    static int numOfSwaps = 0;

    public static void main(String[] args) {

        int[] array = {10, 2, 10, 3, 1, 2, 5, 0, -1, -10};
        System.out.println(Arrays.toString(array));

        // Высчитываем промежуток между проверяемыми элементами
        int gap = array.length / 2;

        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Items: " + array.length);
        System.out.println("Swaps: " + numOfSwaps);
    }


    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
        numOfSwaps++;
    }

}
