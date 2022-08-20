package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @aurhor Adam Wu
 * @date 2022-06-08 10:02:52
 */
public class Solution105 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursionTree(preorder, 0, preorder.length - 1, 0);
    }

    TreeNode recursionTree(int[] preorder, int preI, int preR, int parentIndex) {
        if (preI > preR) {
            return null;
        }
        int val = preorder[preI];
        TreeNode root = new TreeNode(val);
        if (preI == preR) {
            return root;
        }

        Integer index = map.get(val);
        root.left = recursionTree(preorder, preI + 1, preI + index - parentIndex, index);
        root.right = recursionTree(preorder, preI + index + 1 - parentIndex, preR, index);
        return root;
    }


    public static void main(String[] args) {
        TreeNode node = new Solution105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        TreeNode node = new Solution105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(node);
    }

    // 法1
    // 数组copy效率低下。
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        root.left = buildTree1(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree1(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        return root;
    }
}
