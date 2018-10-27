package arrays;

import java.util.Iterator;

public class SmallestCommonNumber {

    public static void main(String[] args) {
        System.out.println(find_least_common_number(
                new int[]{6, 7, 10, 25, 30, 63, 64},
                new int[]{-1, 4, 5, 6, 7, 8, 50},
                new int[]{1, 6, 10, 14}
        ));
    }


    static int find_least_common_number(int[] arr1,
                                        int[] arr2,
                                        int[] arr3) {

        int arr1CurrentIndex = 0;
        int arr2CurrentIndex = 0;
        int arr3CurrentIndex = 0;


        while ((arr1CurrentIndex < arr1.length && arr2CurrentIndex < arr2.length && arr3CurrentIndex < arr3.length) &&
                !(arr1[arr1CurrentIndex] == arr2[arr2CurrentIndex] && arr2[arr2CurrentIndex] == arr3[arr3CurrentIndex])) {

            if (arr2[arr2CurrentIndex] > arr1[arr1CurrentIndex]) {
                arr1CurrentIndex += 1;
            } else if (arr2[arr2CurrentIndex] < arr1[arr1CurrentIndex]) {
                arr2CurrentIndex += 1;
            }

            if (arr2[arr2CurrentIndex] > arr3[arr3CurrentIndex]) {
                arr3CurrentIndex += 1;
            } else if (arr2[arr2CurrentIndex] < arr3[arr3CurrentIndex]) {
                arr2CurrentIndex += 1;
            }

        }
        if (arr1CurrentIndex < arr1.length && arr2CurrentIndex < arr2.length && arr3CurrentIndex < arr3.length) {
            return arr1[arr1CurrentIndex];
        }
        return -1;
    }

    static int find_least_common_number2(int[] arr1,
                                        int[] arr2,
                                        int[] arr3) {
        int i=0, j=0, k=0;

        while(i < arr1.length &&
                j < arr2.length &&
                k < arr3.length) {

            // Found the smallest common number
            if(arr1[i] == arr2[j] &&
                    arr2[j] == arr3[k]) {
                return arr1[i];
            }

            // Let's advance the iterator
            // for the smallest value.

            if(arr1[i] <= arr2[j] &&
                    arr1[i] <= arr3[k]) {
                i++;
            }
            else if(arr2[j] <= arr1[i] &&
                    arr2[j] <= arr3[k]) {
                j++;
            }
            else if(arr3[k] <= arr1[i] &&
                    arr3[k] <= arr2[j]) {
                k++;
            }
        }

        return -1;
    }

}
