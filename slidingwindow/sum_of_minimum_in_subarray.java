import java.util.*;

public class Main {
    public static ArrayList<Integer> func(int[] arr){
        int n= arr.length;
        ArrayList<Integer> ls= new ArrayList<>();
        int i=0,j=0,minNum=Integer.MAX_VALUE;
        while(j<n){
            minNum=Math.min(arr[j], minNum);
            if(j!=n-1){
                ls.add(minNum);
                j++;
            }
            else if(j==n-1){
                ls.add(minNum);
                i++;
                j=i;
                minNum=Integer.MAX_VALUE;
                if(i==n)
                    break;
            }
            
        }
        
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        // int k= sc.nextInt();
        
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();

        ArrayList<Integer> ans=func(arr);
        int sum=0;
        for(int i=0;i<ans.size();i++){
            sum+=ans.get(i);
        }
        System.out.print(sum);
    }
}
