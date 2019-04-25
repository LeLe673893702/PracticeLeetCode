package tree;

import sun.net.www.protocol.http.Handler;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(maxDepth(treeNode));
    }
    public  static  int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
