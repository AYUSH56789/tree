import org.w3c.dom.Node;

public class problem2 {
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


    public static int sumNode(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumNode(root.left);
        int rightSum=sumNode(root.right);
        int totalSum=leftSum+rightSum+root.data;
        return totalSum;
    }
    public static void main(String[] args) {
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(sumNode(root));
    }
}
