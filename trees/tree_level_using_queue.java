import java.util.*;

public class tree_level_using_queue {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        BST tree= new BST();
        for(int i=0;i<n;i++)
            tree.CreateTree(sc.nextInt());

        tree.PrintTreeLevel();
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

class BST{
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
        }
        else{
            current.right=add(newNode, current.right);
        }
        return current;
    }

    void PrintTreeLevel(){
        print(root);
    }
    private void print(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.peek();
            System.out.print(cur.data+" ");
            if(cur.left!=null)
                q.add(cur.left);
            else if(cur.right!=null)
                q.add(cur.right);
            q.remove();
        }
    }

    void topView(){
        view(root);
    }
    private void view(Node root){
        Pair<Integer, Integer> pair= new Pair<>();
        Queue<pair> q= new LinkedList<>();
    }
}