package songoku.algorithm;

import java.util.Arrays;

/**
 * ��ѡ���������
 */
public class SelectSortTest {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("����ǰ��" + Arrays.toString(arr));

        selectSort(arr);

        System.out.println("�����" + Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        //ѡ������ʱ�临�Ӷ��� O(n^2)
        // ���� n-1 ��ѡ������
        // ���ȼ����i(��0������һ����ʼ)��Ϊ��Сֵ��ÿһ��ѡ�����С��ֵ���ڵ�index���͵�i�����н���
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
//                if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
//                    min = arr[j]; // ����min
//                    minIndex = j; // ����minIndex
//                }
            }
            // ����Сֵ������arr[0], ������
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
