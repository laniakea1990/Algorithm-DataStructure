package songoku.algorithm;

import java.util.Scanner;

/**
 *测试数组模拟环形队列的案例~~~
 */
public class CircleArrayQueueTest {

    public static void main(String[] args) {

        System.out.println("测试数组模拟循环队列的案例~~~~~~~");

        CircleArrayQueue circleQueue = new CircleArrayQueue(5);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取数据");
            System.out.println("h(head): 查看队列头数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int num = scanner.nextInt();
                    circleQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // todo handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int n = circleQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", n);
                    } catch (Exception e) {
                        // todo handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}


/**
 * 使用数组模拟一个环形队列
 */
class CircleArrayQueue{

    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * 队列头：front 指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
     * front的初始值 = 0
     */
    private int front;
    /**
     * 队列尾：rear 指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
     * rear 的初始值 = 0
     */
    private int rear;
    /**
     * 模拟环形队列的数组
     */
    private int[] arr;

    CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
    }

    /**
     * 判断队列是否已满
     * @return 是否已满
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    /**
     * 判断队列是否已空
     * @return 是否已空
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 添加数据到队列
     * @param n 待添加的数据
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加入数据...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 数据出队列
     * @return 出队数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法取出数据...");
        }
        int i = arr[front];
        front = (front + 1) % maxSize;
        return i;
    }

    /**
     * 显示队列所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，没有数据可以展示...");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列有多少个有效数据
     * @return 有效数据
     */
    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据，注意不是取出对头
     * @return 队头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法取出数据...");
        }
        return arr[front];
    }
}