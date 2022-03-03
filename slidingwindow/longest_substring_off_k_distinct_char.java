import java.util.*;

public class longest_substring_off_k_distinct_char {
    public static int func(String str, int k){
        HashMap<Character, Integer> map= new HashMap<>();
        if(k==0)
            return 0;
            
        int i=0,j=0,size=0;
        while(j<str.length()){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);

            if(map.size()<k){
                j++;
                continue;
            }
            
            else if(map.size()==k){
                int sum=0;
                for(int val: map.values())
                    sum+=val;
                size=Math.max(size, sum);
            }

            else if(map.size()>k){
                while(map.size()>k){
                    map.put(str.charAt(i), map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i))==0)
                        map.remove(str.charAt(i));
                    i++;
                }
            }
            j++;
        }
        if(size==0)
            return str.length();
        return size;
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();
        int k= sc.nextInt();

        System.out.print(func(str, k));
    }
}
