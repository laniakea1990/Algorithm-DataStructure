package songoku.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序测试
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = new int[10];
//        int[] arr = {5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前：" + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {

        // 标识变量，表示是否进行过交换
        int tmp = 0;
        // 进行 n-1 趟冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 重置flag!!!, 进行下次判断
            boolean flag = false;
            // 每一趟将最大的数字交换至数组最末端(即arr[arr.length - 1 - i])
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) {
                // 在一趟排序中，一次交换都没有发生过
                break;
            }
        }
    }
}