package com.ailpha.common.util;

/**
 * 排序工具类
 *
 * @author andy
 *
 */
public class SortUtil {

    /**
     * Merge Sort
     *
     * @param array
     * @param begin
     * @param end
     */
    public static void mergeSort(int[] array, int begin, int end) {
        if (array == null || array.length == 0) return;
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];
        for (int l = 0; l < temp.length; l++) {
            array[begin + l] = temp[l];
        }
    }

    /**
     * Quick Sort
     *
     * @param array
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (array == null || array.length == 0) return;
        if (begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    /**
     * Partition
     *
     * @return
     */
    private static int partition(int[] array, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[counter];
        array[counter] = array[pivot];
        array[pivot] = temp;
        return counter;
    }

    /**
     * Bubble Sort
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Insertion Sort
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 1; i < array.length; i++) {
            int prev = i - 1;
            int current = array[i];
            while (prev >= 0 && array[prev] > current) {
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = current;
        }
    }

    /**
     * Selection Sort
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 6, 1, 7};
        //insertionSort(array);
        selectionSort(array);
        //bubbleSort(array);
        //quickSort(array, 0, array.length - 1);
        //mergeSort(array, 0, array.length - 1);
        for (int x : array) {
            System.out.println(x);
        }
    }

}
