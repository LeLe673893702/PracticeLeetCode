package graph;

import tree.ThreeBuilder;
import tree.TreeNode;

import java.util.*;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {
    public static void main(String[] args) {
        Integer[] nums = {1,2};
        TreeNode root = ThreeBuilder.convert(nums);
        PathSum pathSum = new PathSum();

        System.out.println(pathSum.hasPathSum(root, 1));
    }

    int count = 0;
    Set<Integer> results = new HashSet<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        if (root.val != sum && root.left == null && root.right == null) return false;
        if (root.left != null) {
            travalsel(root.left, root);
        }

        if (root.right != null) {
            travalsel(root.right, root);
        }

        for (Integer result : results) {
            if (result == sum) {
                return true;
            }
        }
        return false;
    }

    public void travalsel(TreeNode child, TreeNode parent) {
        if (child != null) {
            child.val += parent.val;
            travalsel(child.left, child);
            travalsel(child.right, child);
        }

        if (parent.left == null && parent.right == null) {
            results.add(parent.val);
        }
    }
}