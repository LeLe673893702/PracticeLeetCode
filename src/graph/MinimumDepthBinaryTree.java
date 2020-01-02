package graph;

import tree.TreeNode;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return getMax(root);
        if (root.left != null && root.right == null) return getMax(root);
        return getMin(root);
    }

    public int getMin(TreeNode root) {
        if (root == null) return 0;

        return Math.min(minDepth(root.left) +1, minDepth(root.right)+1);
    }

    public int getMax(TreeNode root) {
        if (root == null) return 0;

        return Math.max(minDepth(root.left) +1, minDepth(root.right)+1);
    }
}
