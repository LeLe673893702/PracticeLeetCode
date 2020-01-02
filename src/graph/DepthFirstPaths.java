package graph;

import java.util.Stack;

/**
 * 问题模型：通过深度优先查找路径
 */
public class DepthFirstPaths {
    Graph g;
    private int s;
    boolean[] marks;
    private int[] edgeTo;
    public DepthFirstPaths(Graph g, int s) {
        this.g = g;
        this.s = s;
        marks = new boolean[g.v()];
    }

    public void dfs(int v) {
        marks[v] = true;
        for (int w : g.adj(v)) {
            if (!marks[w]) {
                hasPathTo(w);

                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marks[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
