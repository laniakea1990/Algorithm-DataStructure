package songoku.algorithm;

import java.util.Arrays;

/**
 * 简单选择排序测试
 */
public class SelectSortTest {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前：" + Arrays.toString(arr));

        selectSort(arr);

        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
//                if (min > arr[j]) { // 说明假定的最小值，并不是最小
//                    min = arr[j]; // 重置min
//                    minIndex = j; // 重置minIndex
//                }
            }
            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
