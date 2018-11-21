package LeetCode;

import javax.swing.tree.TreeNode;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return t1;
    }
}