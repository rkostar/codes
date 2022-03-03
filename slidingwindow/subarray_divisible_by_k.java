import java.util.*;

public class Main {
    public static int func(int[] arr, int k){
        int i=0,j=0,count=0,sum=0;

        while(j<arr.length){ // 1 2 3 4 5
            sum+=arr[j];

            if(sum%k!=0)
                j++;
            else if(sum%k==0){
                count++;
                sum-=arr[j];
                i++;
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.print(func(arr, k));
    }
}
