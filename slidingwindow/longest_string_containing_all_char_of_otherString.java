import java.util.*;

public class longest_string_containing_all_char_of_otherString {

    public static ArrayList<String> func(String str, String substr) {

        HashMap<Character, Integer> map= new HashMap<>();
        ArrayList<String> ls= new ArrayList<String>();
        for(int i=0;i<substr.length();i++)
            map.put(substr.charAt(i), map.getOrDefault(substr.charAt(i),0)+1);
        
        int i=0,j=0,counter=map.size(),size=Integer.MAX_VALUE;
        String ans="";
        while(j<str.length()){
            char ch=str.charAt(j);
            
            if(map.containsKey(ch) && counter>0){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0)
                    counter--;
                // ans+=ch;
                if(counter!=0)
                    j++;
            }
            else if(!map.containsKey(ch) && counter>0){
                // ans+=ch;
                j++;
            }
            if(counter==0){
                int len=j-i+1;
                System.out.println(map);
                // for(int l=i;l<=j;l++)
                //     ans+=str.charAt(l);
                // ls.add(ans);
                size=Math.min(size,len);
                while(counter==0){
                    if(map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i),map.get(str.charAt(i))+1);
                        if(map.get(ch)>0)
                            counter++;
                    }
                    if(counter==0)
                        i++;
                }
                j++;
            }
        }
        System.out.println(size);
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        String substr=sc.next();

        ArrayList<String> ls=func(str,substr);
        for(int i=0;i<ls.size();i++)
            System.out.print(ls.get(i)+" ");

    }
}
