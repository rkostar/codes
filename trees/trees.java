import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Tree tr= new Tree();
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            
            tr.CreateTree(sc.nextInt());
        }
        // tr.minimum();
        // System.out.println(tr.min);
        // int data=sc.nextInt();
        // boolean ans=tr.search(tr.root, data);
        // System.out.println(ans);
        tr.printInorder(tr.root);
        // System.out.println();
        // tr.printPostOrder(tr.root);
        // System.out.print(tr.height(tr.root));
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
    void printInorder(Node node){
        if(node==null)
            return;
        printInorder(node.left);
        System.out.print(node.data+" ");
        printInorder(node.right);
        
    }
    void printPostOrder(Node node){
        if(node==null){
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+" ");
    }
    int height(Node node){
        if(node==null){
            return 0;
        }
        
        int h1=1+height(node.left);
        int h2=1+height(node.right);
        return Math.max(h1,h2);
    }
    boolean search(Node root,int data){
        if(root==null)
            return false;
        if(root.data==data)
            return true;
        
        boolean ans;
        if(data<root.data){
            ans=search(root.left, data);
        }
        else{
           ans=search(root.right, data);
        }
        return ans;
    }
    void minimum(){
        FindMin(root);
    }
    void FindMin(Node root){
        if(root==null){
            return ;
        }
        min=Math.min(root.data,min);

        FindMin(root.left);
        FindMin(root.right);
    }
}