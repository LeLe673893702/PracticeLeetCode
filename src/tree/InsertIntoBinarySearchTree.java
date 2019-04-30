package tree;

/**
 * 701.二叉搜索树的插入
 * 小于值找左子树，大于值找右子树，找到之后直接插入
 */
public class InsertIntoBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.right = new TreeNode(55);
        treeNode.right.left = new TreeNode(39);
        treeNode.right.left.left = new TreeNode(11);
        TreeNode root = insertIntoBST(treeNode, 17);

    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode saveRoot = root;
        TreeNode pre = null;
        TreeNode treeNode = new TreeNode(val);
        if (root == null) return treeNode;
        while (root != null) {
            pre = root;
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (val < pre.val) {
            pre.left = treeNode;
        } else  {
            pre.right = treeNode;
        }
        return saveRoot;
    }
}
