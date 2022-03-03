import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<Integer> func(int[] arr, int k){
        ArrayList<Integer> ls= new ArrayList<Integer>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        int i=0,j=0;
        while(j<arr.length){
            if(arr[j]<0)
                ls.add(arr[j]);
            if(j-i+1<k)  // j-i+1 denotes the size of window
                j++;
            else if(j-i+1==k){
                if(ls.size()==0){
                    ans.add(0);
                    i++;
                    j++;
                    continue;
                }
                ans.add(ls.get(0));
                i++;
                j++;
                if(arr[i-1]==ls.get(0))
                    ls.remove(0);
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        // your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        ArrayList<Integer> ans=(func(arr,k));

        for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");
    }
}