package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 把存储的作为下标，并且按照顺序存储
 */
public class Graph {
    private int V;
    private int E;
    private List<Node> adj;
    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            Node node = new Node();
            node.vList = new LinkedList<>();
        }
    }

    public int v() {
        return V;
    }

    public int e() {
        return E;
    }

    public void addEage(int v, int w) {
        adj.get(v).vList.add(w);
        adj.get(w).vList.add(v);
        E++;
    }

    /**
     * 返回v的相邻节点
     */
    public List<Integer> adj(int v) {
        return adj.get(v).vList;
    }

    class Node {
        int x;
        List<Integer> vList;
    }
}
