package tree;

/**
 * 把一个有序数组转换为平衡二叉搜索树
 */
public class ConvertSortedArrayToBinarySearchTree {
    private static int[] nums = {-10, -3, 0, 5, 9};

    public static void main(String[] args) {
        sortedArrayToBST(nums);
    }

    // create(root) = create(left) , create(right)
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return convert( nums, 0, nums.length-1);
    }

    public static TreeNode convert(int[] nums, int left, int right) {
        if (left > right) return null;
        // 先构建中点接点
        int center = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[center]);
        treeNode.left = convert(nums, left, center-1);
        treeNode.right = convert(nums, center + 1, right);
        return treeNode;
    }
}
