package LeetCode;


/* 617. Merge Two Binary Trees

    Given two binary trees and imagine that when you put one of them to cover the other,
    some nodes of the two trees are overlapped while the others are not.
    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
    then sum node values up as the new value of the merged node. Otherwise,
    the NOT null node will be used as the node of new tree.

    Example 1:

    Input:
        Tree 1                     Tree 2
              1                         2
             / \                       / \
            3   2                     1   3
           /                           \   \
          5                             4   7
    Output:
    Merged tree:
             3
            / \
           4   5
          / \   \
         5   4   7


    Note: The merging process must start from the root nodes of both trees.
 */
public class Tree_617 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); 
		System.out.println("start");

        Solution2 solution2 = new Solution2();

        Solution2.TreeNode treeNode1_root = new Solution2.TreeNode(1);
        Solution2.TreeNode treeNode2 = new Solution2.TreeNode(2);
        Solution2.TreeNode treeNode3 = new Solution2.TreeNode(3);
        Solution2.TreeNode treeNode5 = new Solution2.TreeNode(5);

        treeNode1_root.right = treeNode2;
        treeNode1_root.left = treeNode3;
        treeNode3.left = treeNode5;

        Solution2.TreeNode treeNode1_1 = new Solution2.TreeNode(1);
        Solution2.TreeNode treeNode2_1_root = new Solution2.TreeNode(2);
        Solution2.TreeNode treeNode3_1 = new Solution2.TreeNode(3);
        Solution2.TreeNode treeNode4_1 = new Solution2.TreeNode(4);
        Solution2.TreeNode treeNode7_1 = new Solution2.TreeNode(7);

        treeNode2_1_root.left = treeNode1_1;
        treeNode2_1_root.right = treeNode3_1;
        treeNode1_1.right = treeNode4_1;
        treeNode3_1.right = treeNode7_1;

        solution2.mergeTrees(treeNode1_root, treeNode2_1_root);

        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start ));
	}

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return  t1;
        }

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}














