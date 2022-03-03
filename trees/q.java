
import java.util.*;
import java.io.*;

public class Main {
  static long maxVal=Integer.MIN_VALUE;
  public static void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
  
  public static void func(int[] arr, int index){
    if(index==arr.length){
      String ans="";
      for(int i=0;i<arr.length;i++)
        ans+=arr[i];
      long k= Long.parseLong(ans);
      maxVal=Math.max(maxVal,k);
      return;
    }
    
    for(int i=index;i<arr.length;i++){
      swap(arr, i, index);
      func(arr, index+1);
      swap(arr, i, index);
    }
  }
    public static void main(String args[]) {
        //your code here
      Scanner sc= new Scanner(System.in);
      int n=sc.nextInt();

      int[] arr= new int[n];
      for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
      ArrayList<String> ls= new ArrayList<>();
      func(arr,0);
      System.out.print(maxVal);
    }
}