package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildBst(nums, 0, nums.length-1);
    }

    private TreeNode BuildBst(int[] nums, int left, int right) {
        // TODO Auto-generated method stub
        if(left > right)return null;

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BuildBst(nums, left, mid-1);
        root.right = BuildBst(nums, mid+1, right);

        return root;
    }
}
