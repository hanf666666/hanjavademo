package other;

import java.util.*;

public class DFSDemo {

    private final int V;                          // 顶点数
    private final List<List<Integer>> adj;        // 邻接表

    public DFSDemo(int v) {
        this.V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /** 无向图添加边 */
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // ============ 方式一：递归 DFS ============
    public void dfsRecursive(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("递归 DFS（从 " + start + " 开始）: ");
        dfsUtil(start, visited);
        System.out.println();

        // 若要遍历非连通图，可以补充：
        // for (int i = 0; i < V; i++) {
        //     if (!visited[i]) dfsUtil(i, visited);
        // }
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : adj.get(v)) {
            if (!visited[w]) {
                dfsUtil(w, visited);
            }
        }
    }

    // ============ 方式二：非递归 DFS（显式栈） ============
    public void dfsIterative(int start) {
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        System.out.print("迭代 DFS（从 " + start + " 开始）: ");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited[v]) continue;   // 可能被重复压栈，跳过已访问的

            visited[v] = true;
            System.out.print(v + " ");

            // 逆序压栈，保证弹出顺序与递归版一致（按邻接表的自然顺序）
            List<Integer> neighbors = adj.get(v);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int w = neighbors.get(i);
                if (!visited[w]) {
                    stack.push(w);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DFSDemo g = new DFSDemo(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.dfsRecursive(0);
        g.dfsIterative(0);
    }
}
