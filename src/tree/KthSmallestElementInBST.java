package tree;

import java.util.Stack;

/**
 * 230.二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class KthSmallestElementInBST {
    int count = 0;
    int result = -1;
    /**
     * 非递归，先序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 遍历左子树
            while (root!=null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            }

            // 输出中点
            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            }

            // 遍历右子树
            root = root.right;
            if (root != null) {
                stack.push(root);
            }
        }
        return -1;
    }

    /**
     * 递归
     */
    public int kthSmallestRecursion(TreeNode root, int k) {
        travel(root, k);
        return result;
    }


    public void travel(TreeNode root, int k) {
        if (root == null) return;
        travel(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        travel(root.right, k);
    }

}
