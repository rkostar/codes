import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<Integer> func(int[] arr, int k, ArrayList<Integer> ls){
        // int maxSum=Integer.MIN_VALUE;
        ArrayList<Integer> track= new ArrayList<>();

        int maxNum=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<arr.length){
            track.add(arr[j]);
            maxNum=Math.max(maxNum,arr[j]);
            if(j-i+1<k)  // j-i+1 denotes the size of window
                j++;
            else if(j-i+1==k){
                ls.add(maxNum);
                // if(maxNum==arr[i]){
                //     track.remove(0);
                //     maxNum=Collections.max(track);
                // }
                track.remove(0);
                maxNum=Collections.max(track);
                i++;
                j++;
            }
        }
        return ls;
    }
    public static void main(String args[]) {
        // your code here
        ArrayList<Integer> ls= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        ArrayList<Integer> ans=(func(arr,k,ls));

        for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");
    }
}