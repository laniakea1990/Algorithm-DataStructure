package songoku.algorithm;

import java.util.Arrays;

/**
 * ð���������
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = new int[10];
//        int[] arr = {5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("����ǰ��" + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("�����" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {

        // ��ʶ��������ʾ�Ƿ���й�����
        int tmp = 0;
        // ���� n-1 ��ð������
        for (int i = 0; i < arr.length - 1; i++) {
            // ����flag!!!, �����´��ж�
            boolean flag = false;
            // ÿһ�˽��������ֽ�����������ĩ��(��arr[arr.length - 1 - i])
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) {
                // ��һ�������У�һ�ν�����û�з�����
                break;
            }
        }
    }
}