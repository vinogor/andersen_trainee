package intrnshp_06_Sorting;

import java.util.Arrays;

public class Sorting_02_Selection {

    static int numOfSwaps = 0;

    public static void main(String[] args) {

        int[] array = {10, 2, 10, 3, 1, 2, 5, 0, -1, -10};

        System.out.println(Arrays.toString(array));

        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
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
