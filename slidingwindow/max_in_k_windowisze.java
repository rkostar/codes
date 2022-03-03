
import java.io.*;
import java.util.*;
public class Main {
    public static void func(int[] arr, int k){
        ArrayList<Integer> ls= new ArrayList<>();
        int i=0,j=0;
        while(j<arr.length){
            ls.add(arr[j]);
            
            if(j-i+1<k)
                j++;

            else if(j-i+1==k){
                int m=Collections.max(ls);
                System.out.print(m+" ");
                ls.remove(0);
                i++;
                j++;
            }
        }
    }
    public static void main(String args[]) {
        // your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        func(arr, k);
    }
}