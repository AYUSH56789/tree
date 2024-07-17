public class problem6{
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


    private static int nodeSum(Node root){
        if(root==null){
            return 0;
        }
        int ls=nodeSum(root.left);
        int rs=nodeSum(root.right);
        return Math.max(ls,rs)+root.data;
    }

    static int maxSum=Integer.MIN_VALUE;

    public static int bruteForceSolution(Node root){
        if(root==null){
            return 0;
        }
        // we need ls or rs >than 0 or 0 becuse less than 0 can'nt give maxSum result of nodes.
        int leftSum=Math.max(0,nodeSum(root.left));
        int rightSum=Math.max(0,nodeSum(root.right));
        maxSum=Math.max(maxSum,leftSum+rightSum+root.data);
        bruteForceSolution(root.left);
        bruteForceSolution(root.right);
        return maxSum;
    }


    // with time complexity O(N) with space complexity O(1)
    public static int optimalSolution(Node root,int ms[]){
        if(root==null){
            return 0;
        }
        int ls=Math.max(0,optimalSolution(root.left, ms));
        int rs=Math.max(0,optimalSolution(root.right, ms));
        ms[0]=Math.max(ms[0],ls+rs+root.data);
        return root.data+Math.max(rs,ls);
    }

    
    public static void main(String[] args) {
        // create tree
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        

        System.out.println(bruteForceSolution(root));

        int maxSum[]=new int[1];
        optimalSolution(root,maxSum);
        System.out.println(maxSum[0]);

    }
}

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
*/
