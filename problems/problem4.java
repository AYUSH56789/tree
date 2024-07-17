public class problem4 {
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

    // check tree is balance or not
    public static int checkBalance(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=checkBalance(root.left);
        int rightHeight=checkBalance(root.right);
        if(leftHeight==-1 && rightHeight==-1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            System.out.println("hlo");
            return -1;
        }
        int max=Math.max(leftHeight, rightHeight)+1;
        return max;
    }

    public static void main(String[] args) {
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        // root.right.right.right = new Node(8);
        // root.right.right.right.right = new Node(9);
        // root.right.right.right.right.right = new Node(10);

        System.out.println(checkBalance(root));
    }
}
