package week;

import tree.ThreeBuilder;
import tree.TreeNode;

import java.util.*;

public class MaxLevelSum {
    public static void main(String[] args) {
        Integer[] nums = {10};
        System.out.println(maxLevelSum(ThreeBuilder.convert(nums)));
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> treeNodes = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, root.val);
        int count = 0;
        int cen = 1;
        List<TreeNode> tmpTreeNodes = new LinkedList<>();
        treeNodes.add(root);
        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (treeNode.left != null) {
                count += treeNode.left.val;
                tmpTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                count += treeNode.right.val;
                tmpTreeNodes.add(treeNode.right);
            }
            if (i == treeNodes.size() - 1 && !tmpTreeNodes.isEmpty()) {
                cen += 1;
                hashMap.put(cen, count);
                treeNodes.clear();
                treeNodes.addAll(tmpTreeNodes);
                tmpTreeNodes.clear();
                i = -1;
                count = 0;
            }
        }
        int minPlies = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int plies : hashMap.keySet()) {
            if (hashMap.get(plies) > maxValue) {
                minPlies = plies;
                maxValue = hashMap.get(plies);
            } else if (hashMap.get(plies) == maxValue) {
                if (minPlies > plies) {
                    minPlies = plies;
                }
            }
        }
        return minPlies;
    }
}
