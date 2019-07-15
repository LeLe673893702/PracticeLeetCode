package week;

import tree.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import tree.ThreeBuilder;

/**
 * 周赛145
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 * 求左子树>右子树的最小节点
 */
public class LowestCommonAncestorDeepestLeaves {
    public static void main(String[] args) {
        LowestCommonAncestorDeepestLeaves lowestCommonAncestorDeepestLeaves = new LowestCommonAncestorDeepestLeaves();
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = lowestCommonAncestorDeepestLeaves.lcaDeepestLeaves(ThreeBuilder.convert(nums));
        System.out.println(treeNode.val);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
    List<TreeNode> treeNodeList = new ArrayList<>();

    public class NullClass extends TreeNode {
        public NullClass() {
            this(-1);
        }

        public NullClass(int x) {
            super(x);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode first = root;
        treeNodeQueue.add(first);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode top = treeNodeQueue.peek();
            if (!(top instanceof NullClass) && (top.right != null || top.left != null)) {
                if (top.right == null) {
                    treeNodeQueue.add(new NullClass());
                } else {
                    treeNodeQueue.add(top.right);
                }

                if (top.left == null) {
                    treeNodeQueue.add(new NullClass());
                } else {
                    treeNodeQueue.add(top.left);
                }
            }

            treeNodeList.add(treeNodeQueue.poll());
        }

        int i = 1;
        while (i < treeNodeList.size() && !(treeNodeList.get(treeNodeList.size() - i) instanceof NullClass) &&
                !(treeNodeList.get(treeNodeList.size() - i - 1) instanceof NullClass)) {
            i += 2;
        }

        return treeNodeList.get(treeNodeList.size() - i);
    }
}
