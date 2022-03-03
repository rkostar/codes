import java.util.*;

public class Main {
    public static int func(String str){
        HashMap<Character, Integer> map= new HashMap<>();

        int i=0,j=0,size=0;
        while(j<str.length()){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0)+1);

            if(j-i+1<map.size())
                j++;

            else if(j-i+1==map.size())
                size=Math.max(size, map.size());

            else if(j-i+1>map.size()){
                while(j-i+1>map.size()){
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i))==0)
                        map.remove(str.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return size;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();

        System.out.print(func(str));
    }
}
