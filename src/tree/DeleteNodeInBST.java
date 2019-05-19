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
                {2,1,3};
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

            if (findPreNode == null) {
                return deleteNodeByTwoChildNode(true,root);
            }

            if (findPreNode.right != null) {
                if (findPreNode.right.val == findCurNode.val) {
                    return deleteNodeByTwoChildNode(true, root);
                }
            }

            if (findPreNode.left != null) {
                if (findPreNode.left.val == findCurNode.val) {
                    return deleteNodeByTwoChildNode(false, root);
                }
            }

        }

        return deleteSubNode(key,  findCurNode,findPreNode, root);
    }

     private TreeNode deleteSubNode(int key, TreeNode curNode, TreeNode preNode, TreeNode root) {
         // 无子节点直接删除
         if (curNode.left == null && curNode.right == null) {
             if (preNode == null) {
                 return null;
             }
             if (preNode.right != null) {
                 if (preNode.right.val == curNode.val) {
                     preNode.right = null;
                     return root;
                 }
             }

             if (preNode.left != null) {
                 if (preNode.left.val == curNode.val) {
                     preNode.left = null;
                     return root;
                 }
             }

         }

         // 如果有一个右节点
         if (curNode.left == null && curNode.right != null) {
             if (preNode == null) {
                 return root.right;
             }
             if (preNode.right != null) {
                 if (preNode.right.val == curNode.val) {
                     preNode.right = curNode.right;
                     return root;
                 }
             }

             if (preNode.left != null) {
                 if (preNode.left.val == curNode.val) {
                     preNode.left = curNode.right;
                     return root;
                 }
             }
         }

         // 如果只有一个左节点
         if (curNode.left != null && curNode.right == null) {
             if (preNode == null) {
                 return root.left;
             }
             if (preNode.right != null) {
                 if (preNode.right.val == curNode.val) {
                     preNode.right = curNode.left;
                     return root;
                 }
             }

             if (preNode.left != null) {
                 if (preNode.left.val == curNode.val) {
                     preNode.left = curNode.left;
                     return root;
                 }
             }
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

    /**
     *  ，
     */
    private TreeNode deleteNodeByTwoChildNode(boolean right, TreeNode root) {
        if (findPreNode != null) {
            // 先把最小节点替换删除节点
            if (right) {
                findPreNode.right  = subMinCurNode;
            } else  {
                findPreNode.left = subMinCurNode;
            }
        }

        // 最小节点右子树接到上个节点，移除最小节点
        deleteSubNode(subMinCurNode.val, subMinCurNode, subMinPreNode, root);

        // 删除找到的节点
        subMinCurNode.left = findCurNode.left;
        subMinCurNode.right = findCurNode.right;

        if (findPreNode == null) {
            return subMinCurNode;
        } else  {
            return root;
        }
    }
}
