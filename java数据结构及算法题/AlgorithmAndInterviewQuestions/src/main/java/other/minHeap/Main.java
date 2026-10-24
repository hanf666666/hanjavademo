package other.minHeap;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 读取输入（注意：牛客网很多时候是多组用例，最好用 hasNext 判断一下）
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt(); // 天数
            int d = scanner.nextInt(); // 保质期（可以保留几天的糖果）

            // 2. 创建一个小顶堆（PriorityQueue 默认就是小顶堆）
            // 堆里面存的就是我们目前“决定要买”的糖果甜度
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // 3. 按天遍历
            for (int i = 0; i < n; i++) {
                int sweet = scanner.nextInt();

                // 每天上架的新糖果，先无脑扔进堆里
                minHeap.offer(sweet);

                // 核心逻辑：如果堆里的数量超过了保质期 d
                // 说明最老的那颗糖果今天必须吃掉了，不然就过期浪费了
                // 但是小明每天只能买1颗，所以只能狠心淘汰掉堆里甜度最小的那颗
                if (minHeap.size() > d) {
                    minHeap.poll(); // 弹出堆顶（也就是甜度最小的那个）
                }
            }

            // 4. 计算最终能买到的最大甜度总和
            long totalSweetness = 0; // 用 long 防止甜度总和超过 int 最大值
            while (!minHeap.isEmpty()) {
                totalSweetness += minHeap.poll();
            }

            System.out.println(totalSweetness);
        }

        scanner.close();
    }
}
