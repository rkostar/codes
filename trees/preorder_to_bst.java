import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Tree tree= new Tree();
        int n= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            tree.InordetToBST(arr[i]);
        }

        tree.InOrder();
        
    }
}


class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

class Tree{
    Node root;
    int min=Integer.MAX_VALUE;
    void CreateTree(int data){
        Node newNode= new Node(data);
        if(root==null){
            root=newNode;
            return;
        }
        add(newNode, root);
    }
    Node add(Node newNode, Node current){
        if(current==null)
            return newNode;
        
        if(newNode.data<current.data){
            current.left=add(newNode, current.left);
        }
        else{
            current.right=add(newNode, current.right);
        }
        return current;
    }
    void InordetToBST(int data){
        root=create(root,data);
    }
    Node create(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }

        if(data<root.data)
            root.left=create(root.left, data);

        else
            root.right=create(root.right, data);

        return root;
    }

    void InOrder(){
        printTree(root);
    }
    private void printTree(Node root){
        if(root==null)
            return;

        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
}