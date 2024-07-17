import org.w3c.dom.Node;

public class problem1 {
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


    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=countNode(root.left);
        int rightCount=countNode(root.right);
        int totalCount=leftCount+rightCount+1;
        return totalCount;
    }
    public static void main(String[] args) {
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(countNode(root));
    }
}
