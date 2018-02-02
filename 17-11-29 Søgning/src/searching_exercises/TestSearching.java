package searching_exercises;

import java.util.Arrays;

public class TestSearching {

    public static void main(String[] args) {

        // Test for exercise 1
        int[] array1 = { 2, 4, 8, 2 };
        System.out.println("Array: " + Arrays.toString(array1));
        System.out.println("Are there uneven numbers in the array? " + Searching.findUneven(array1));
        array1[2] = 15;
        System.out.println("Array: " + Arrays.toString(array1));
        System.out.println("Are there uneven numbers in the array? " + Searching.findUneven(array1));
        System.out.println();

        // TODO: test exercise 2-7
        int[] array2 = { 7, 56, 34, 3, 7, 14, 13, 4 };
        System.out.println("Array: " + Arrays.toString(array2));
        System.out.println("Which is the first number between 10 and 15? " + Searching.findFirst(array2));
        System.out.println();

        int[] array3 = { 7, 9, 13, 7, 9, 13 };
        System.out.println("Array: " + Arrays.toString(array3));
        System.out.println("Are there any same numbers in a row? " + Searching.findSame(array3));
        array3[3] = 13;
        array3[4] = 9;
        array3[5] = 7;
        System.out.println("Array: " + Arrays.toString(array3));
        System.out.println("Are there any same numbers in a row? " + Searching.findSame(array3));
        System.out.println();

    }

}
