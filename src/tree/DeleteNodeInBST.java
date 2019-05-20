package tree;

import jdk.nashorn.internal.ir.ThrowNode;

/**
 * 450，删除二叉搜索树中的节点
 */
public class DeleteNodeInBST {
    public static void main(String[] args) {
        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();

        Integer[] ints =
//                {2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6};
                {5,3,6,2,4,null,7};
        Integer[] outs =
                {2,0,34,null,1,25,40,null,null,11,31,36,45,10,18,29,32,35,39,43,46,4,null,12,24,26,30,null,null,null,null,38,null,42,44,null,48,3,9,null,14,22,null,null,27,null,null,37,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,null,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,7,null,16,null,null,20,6};

        Integer[] rights =
                {2,0,34,null,1,25,40,null,null,11,31,35,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,null,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6};

        TreeNode root = ThreeBuilder.convert(ints);
        TreeNode out = ThreeBuilder.convert(outs);
        TreeNode right = ThreeBuilder.convert(rights);


        root = deleteNodeInBST.deleteNode(root, 2);
    }

    // 子树下的最小节点，子树下的最小节点的父节点
    private TreeNode subMinCurNode, subMinPreNode;
    private TreeNode findCurNode, findPreNode;
    /**
     * 1. 无子节点，直接删除
     * 2. 有子节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        findCurNode = root;
        findPreNode = null;

        if (root == null) {
            return null;
        }

        findNode(key);
        if (findCurNode == null) {
            return root;
        }

        // 如果两边都有节点, 找到右子树的左边最小节点
        if (findCurNode.left != null && findCurNode.right != null) {
            subMinPreNode = findCurNode;
            subMinCurNode = findCurNode.right;
            findMinNode();

            findCurNode.val = subMinCurNode.val;
            findCurNode = subMinCurNode;
            findPreNode = subMinPreNode;
        }

        TreeNode curChildNode = null;
        // 先处理删除节点有一个节点和无节点的情况
        if (findCurNode.left != null) {
            // 删除节点的左节点不为空
            curChildNode = findCurNode.left;
        } else if (findCurNode.right != null){
            // 删除节点的左节点不为空
            curChildNode = findCurNode.right;
        }

        // 再判断处理删除节点是父节点的左节点还是右节点
        if (findPreNode == null) {
            // 删除根节点，直接返回null
            root = curChildNode;
        } else if (findPreNode.left == findCurNode) {
            // 删除左节点
            findPreNode.left = curChildNode;
        } else if (findPreNode.right == findCurNode) {
            // 删除右节点
            findPreNode.right = curChildNode;
        }

        return root;
    }

    /**
     * 先找指定节点
     */
    private void findNode(int key) {
        if (findCurNode == null || findCurNode.val == key) return;

        findPreNode = findCurNode;

        if (findCurNode.val > key) {
            findCurNode = findCurNode.left;
            findNode(key);
        } else  {
            findCurNode = findCurNode.right;
            findNode(key);
        }
    }

    /**
     * 查找右子树中最小节点，右子树中的左子树最后一个
     */
    private void findMinNode() {
        while (subMinCurNode.left != null) {
            subMinPreNode = subMinCurNode;
            subMinCurNode = subMinPreNode.left;
        }
    }
}
