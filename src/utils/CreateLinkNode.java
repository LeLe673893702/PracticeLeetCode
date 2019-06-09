package utils;

public class CreateLinkNode {
    public static ListNode getLinkedNode(int[] nums) {
        ListNode first = null;
        ListNode result = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                first = new ListNode(nums[i]);
                result = first;
            } else {
                first.next = new ListNode(nums[i]);
                first = first.next;
            }
        }
        return result;
    }
}
