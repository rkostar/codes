import java.util.*;

public class delete_in_bst {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Tree tr= new Tree();
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            
            tr.CreateTree(sc.nextInt());
        }
        tr.DeleteData(sc.nextInt());
        tr.printPreOrder(tr.root);
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

    void printPreOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
        
    }
    void DeleteData(int data){
        delete(root, data);
    }
    private Node delete(Node root, int data){
        if(root==null)
            return null;

        if(data<root.data)
            root.left=delete(root.left, data);

        else if(data>root.data)
            root.right=delete(root.right, data);

        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            root.data=FindMin(root.right);
            root.right=delete(root.right, root.data);
        }
        return root;
    }
    int FindMin(Node root){
        Node current=root;
        while(current.left!=null){
            current=current.left;
        }
        return current.data;
    }
}