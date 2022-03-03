import java.io.*;
import java.util.*;
public class Main {
  public static int func(int[] arr, int a, int b){
    int ans=0;
    int i=0,j=0;
    while(j<arr.length){

      if(arr[j]>=a && arr[j]<=b){
        ans++;
        j++;
      }
      else{
        j++;
        i=j;
        
      }
    }
    return ans;
  }
    public static void main(String args[]) {
        // your code here
      Scanner sc= new Scanner(System.in);
      int n= sc.nextInt();

      int arr[]= new int[n];
      for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

      int a=sc.nextInt();
      int b= sc.nextInt();
      System.out.print(func(arr,a,b));
    }
}