import java.util.*;

public class Main {
    public static int func(int[] arr, int k){
        int n= arr.length;

        int i=0,j=0,sum=0,size=0;
        while(j<n){
            sum+=arr[j];
            if(sum<k)
                j++;

            else if(sum==k){
                size=Math.max(j-i+1, size);
                j++;
            }

            else if(sum>k){
                while(sum>k){
                    sum-=arr[i];
                    i++;
                }
                j++;
            }
        }
        return size;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();

        System.out.print(func(arr,k));
    }
}
