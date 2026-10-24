package other;

import java.util.*;

public class BFSDemo {

    private final int V;
    private final List<List<Integer>> adj;

    public BFSDemo(int v) {
        this.V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * 从 start 开始做 BFS
     * 同时计算 start 到每个顶点的最短边数（层数）
     */
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, -1);        // -1 表示不可达

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        dist[start] = 0;
        queue.offer(start);

        System.out.print("BFS 遍历（从 " + start + " 开始）: ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int w : adj.get(v)) {
                if (!visited[w]) {
                    visited[w] = true;         // 入队时就标记，避免重复入队
                    dist[w] = dist[v] + 1;
                    queue.offer(w);
                }
            }
        }
        System.out.println();

        System.out.println("从 " + start + " 出发到各顶点的最短距离（边数）：");
        for (int i = 0; i < V; i++) {
            System.out.println("  " + start + " -> " + i + " : " + dist[i]);
        }
    }

    /** 进阶：按层打印 BFS，便于直观看"层"的概念 */
    public void bfsByLevel(int start) {
        boolean[] visited = new boolean[V];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int level = 0;
        System.out.println("按层 BFS 输出：");
        while (!queue.isEmpty()) {
            int size = queue.size();     // 当前层节点数
            System.out.print("第 " + level + " 层: ");
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                System.out.print(v + " ");
                for (int w : adj.get(v)) {
                    if (!visited[w]) {
                        visited[w] = true;
                        queue.offer(w);
                    }
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        BFSDemo g = new BFSDemo(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.bfs(0);
        System.out.println();
        g.bfsByLevel(0);
    }
}
