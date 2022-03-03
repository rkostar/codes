import java.io.*;
import java.util.*;
public class Main {
    public static int func(int[] arr, int k){
        int maxSum=Integer.MIN_VALUE;
        int i=0,j=0,sum=0;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1<k)  // j-i+1 denotes the size of window
                j++;
            else if(j-i+1==k){
                maxSum=Math.max(maxSum,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
    public static void main(String args[]) {
        // your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.print(func(arr,k));
    }
}