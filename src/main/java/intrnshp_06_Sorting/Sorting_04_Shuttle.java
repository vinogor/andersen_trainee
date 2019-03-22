package intrnshp_06_Sorting;

import java.util.Arrays;

public class Sorting_04_Shuttle {

    static int numOfSwaps = 0;

    public static void main(String[] args) {

        int[] array = {10, 2, 10, 3, 1, 2, 5, 0, -1, -10};
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
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
