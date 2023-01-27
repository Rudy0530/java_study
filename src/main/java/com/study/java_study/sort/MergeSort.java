package com.study.java_study.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MergeSort {

    @Test
    public void testMergeSort() {
        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, temp);// 对左侧序列进行拆分
            mergeSort(arr, mid + 1, high, temp); // 对右侧序列进行拆分
            merge(arr, low, mid, high, temp); // 拆分后数据进行归并；
            /**
             * 输入数组长度为 8，那么会排序7次。每次被排序对数组区间为：
             * 0-1
             * 2-3
             * 0-3
             * 4-5
             * 6-7
             * 4-7
             * 0-7
             * */
            print(arr);
        }

    }

    private void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int index = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        for (int t = 0; t < index; t++) {
            arr[low + t] = temp[t];
        }
    }


    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
