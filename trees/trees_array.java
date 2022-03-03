import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Tree tr= new Tree();
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            
            tr.CreateTree(sc.nextInt());
        }
        tr.print(tr.root);
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
            return current;
        }
        else{
            current.right=add(newNode, current.right);
            return current;
        }
    }
    void print(Node node){
        if(node==null)
            return;
        print(node.left);
        System.out.print(node.data+" ");
        print(node.right);
        
    }
}