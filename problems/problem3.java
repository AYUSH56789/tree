public class problem3 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    // solution
    public static int treeHeight(Node root){
        if(root==null){
            return 0;
        }
        
        int leftHight=treeHeight(root.left);
        int rightHight=treeHeight(root.right);
        int maxHight=Math.max(leftHight,rightHight)+1;
        return maxHight;
    }

    
    public static void main(String[] args) {
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(treeHeight(root));
    }
}
/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example1:
Input: root = [3,9,20,null,null,15,7]
Output: 3


Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

Note: maximum depthin the tree and max height of the tree is the same question.
*/