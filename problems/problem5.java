
public class problem5 {
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


    // this is used to find max heihgt of the tree
    private static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    // variable to store max height between two node
    static int max=Integer.MIN_VALUE;

    // brute force solution : with time complexity O(N^2) with space complexity O(N)
    public static int bruteForceSolutionForDiameter(Node root){
        if(root==null){
            return 0 ;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        max=Math.max(max,lh+rh);
        bruteForceSolutionForDiameter(root.left);
        bruteForceSolutionForDiameter(root.right);
        return max;        
    }


    // optimal solution with time complexity O(N) with space complexity O(N)
    public static int optimalSolutionForDiameter(Node root,int []diameter){
        if(root==null){
            return 0;
        }
        int lh=optimalSolutionForDiameter(root.left, diameter);
        int rh=optimalSolutionForDiameter(root.right, diameter);
        diameter[0]=Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }

    public static void main(String[] args) {
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(6);
        root.right.left.left.left = new Node(8);
        root.right.right = new Node(5);
        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(9);

        System.out.println(bruteForceSolutionForDiameter(root));
        // bruteForceSolutionForDiameter(root);
        int diameter[]=new int[1];
        optimalSolutionForDiameter(root,diameter);
        System.out.println(diameter[0]);
    }
}


/*



*/
