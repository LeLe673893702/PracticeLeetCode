package tree;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 94. 二叉树的中序遍历
 * 145.二叉树的后序遍历
 * 102. 二叉树的层序遍历 -> -> -> -> ->
 * 103. 二叉树锯形遍历-> <- -> <- ->
 *
 */
public class BinaryTreeTraversal {
    public Integer[] integers = {1,null,3,4};
    List<Integer> results = new ArrayList<>() ;

    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        TreeNode root = new TreeNode(binaryTreeTraversal.integers[0]);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        binaryTreeTraversal.levelOrder(root);
        binaryTreeTraversal.results.stream().forEach(System.out::print);
    }

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            results.add(root.val);
            results = preorderTraversal(root.left);
            results = preorderTraversal(root.right);
        }
        return  results;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            results = inorderTraversal(root.left);
            results.add(root.val);
            results = inorderTraversal(root.right);
        }
        return  results;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            results = postorderTraversal(root.left);
            results = postorderTraversal(root.right);
            results.add(root.val);
        }
        return  results;
    }

    /**
     * 层序遍历，每层按照从左到右的顺序
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        List<List<Integer>> results = new ArrayList<>();
        treeNodeQueue.offer(root);
        leftToRightTraversal(treeNodeQueue, results);
        return results;
    }

    public Queue<TreeNode> leftToRightTraversal(Queue<TreeNode> rootNodeQueue, List<List<Integer>> allResults) {
        List<Integer> subResults = new ArrayList<>(rootNodeQueue.size());
        int count = rootNodeQueue.size();
        if (rootNodeQueue.isEmpty()) return rootNodeQueue;
        while (count > 0) {
            TreeNode treeNode = rootNodeQueue.poll();
            subResults.add(treeNode.val);
            if (treeNode.left != null) {
                rootNodeQueue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                rootNodeQueue.offer(treeNode.right);
            }
            count --;
        }
        if (!subResults.isEmpty()) {
            allResults.add(subResults);
        }
         return leftToRightTraversal(rootNodeQueue, allResults);
    }


    /**
     * 二叉树的锯齿形层次遍历，上层左->右，下层右->左
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<List<Integer>> results = new ArrayList<>();
        treeNodeStack.push(root);
        zigzagTraversal(treeNodeStack, results, 0);
        return results;
    }

    public Stack<TreeNode> zigzagTraversal(Stack<TreeNode> rootNodeStack,
                                           List<List<Integer>> allResults,
                                           int level) {
        List<Integer> subResults = new ArrayList<>(rootNodeStack.size());
        Stack<TreeNode> tmpTreeNodeStack = new Stack<>();
        if (rootNodeStack.isEmpty()) return tmpTreeNodeStack;
        while (!rootNodeStack.isEmpty()) {
            TreeNode treeNode = rootNodeStack.pop();
            subResults.add(treeNode.val);
            if (level % 2 == 0) {
                if (treeNode.left != null) {
                    tmpTreeNodeStack.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    tmpTreeNodeStack.push(treeNode.right);
                }
            } else  {
                if (treeNode.right != null) {
                    tmpTreeNodeStack.push(treeNode.right);
                }

                if (treeNode.left != null) {
                    tmpTreeNodeStack.push(treeNode.left);
                }
            }
        }
        if (!subResults.isEmpty()) {
            allResults.add(subResults);
        }
        return zigzagTraversal(tmpTreeNodeStack, allResults, level+1);
    }



}
