import java.io.*;
import java.util.*;
public class Main {
    public static int func(String str, String substr){
        int ans=0,k=substr.length();
        HashMap<Character, Integer> map= new HashMap<>();
        for(char ch: substr.toCharArray()){
            if(!map.containsKey(ch))
                map.put(ch,1);
            else
                map.put(ch,map.get(ch)+1);
        }
        int counter=map.size();
        int i=0,j=0;
        while(j<str.length()){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j),map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j))==0)
                    counter--;
            }
            if(j-i+1<k)  // j-i+1 denotes the size of window
                j++;
            else if(j-i+1==k){
                if(counter==0)
                    ans++;
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                    if(map.get(str.charAt(i))>0)
                        counter++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        // your code here
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        String substr=sc.next();

        System.out.print(func(str,substr));
    }
}