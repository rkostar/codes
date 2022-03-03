import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Tree tree= new Tree();
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            
            tree.CreateTree(sc.nextInt());
        }
        tree.PrintTreeLevel();
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
    void PrintTreeLevel(){
        HashMap<Integer, Integer> map= new HashMap<>();
        printTree(root, 0, map);
        int max=-1;
        for(int val: map.values()){
            if(val>max)
                max=val;
        }
        // System.out.println(max);
        
        int i=0;
        while(i<=max){
            Iterator it= map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry mapEle= (Map.Entry)it.next();
                if((int)mapEle.getValue()==i)
                    System.out.print(mapEle.getKey()+" ");
            }
            i++;
        }
        
        
    }
    private void printTree(Node root, int l, HashMap<Integer,Integer> map){
        if(root==null)
            return;

        map.put(root.data,l);
        printTree(root.left, l+1, map);
        printTree(root.right, l+1, map);
       
    }
}