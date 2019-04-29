package tree;

/**
 * 二叉搜索树的插入
 * 如果没有后置节点直接插入
 * 如果有后置节点，插入后把后置节点放入节点后面
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
            if (pre != null) {
                // 右子树  当前节点 >= val >= 上个节点
                if (pre.val <= val && root.val >= val) {
                    treeNode.right = pre.right;
                    pre.right = treeNode;
                    TreeNode last = null;
                    while (root != null ) {
                        if (root.val < val) {
                            treeNode.left = root;
                            if (last != null)last.left = null;
                            break;
                        }
                        last = root;
                        root = root.left;
                    }
                    return saveRoot;
                }
                // 左子树 当前节点 <= val <= 上个节点
                if (pre.val >= val && root.val <= val) {
                    treeNode.left = pre.left;
                    pre.left = treeNode;
                    TreeNode last = null;
                    while (root != null ) {
                        if (root.val > val) {
                            treeNode.right = root;
                            root.right = null;
                            if (last != null) last.right = null;
                            break;
                        }
                        last = root;
                        root = root.right;
                    }
                    return saveRoot;
                }
            }
            pre = root;
            if (val >= root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (val > pre.val) {
            pre.right = treeNode;
        } else  {
            pre.left = treeNode;
        }
        return saveRoot;
    }
}
