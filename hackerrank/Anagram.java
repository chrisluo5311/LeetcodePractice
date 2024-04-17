import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        boolean flag = true;
        String a = "anagram";
        String b = "margana";
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<String,Integer> hmap = new HashMap<>();
        for(int i = 0;i<a.length();i++){
            char cur = a.charAt(i);
            if(hmap.containsKey(String.valueOf(cur))){
                int val = hmap.get(String.valueOf(cur));
                val += 1;
                hmap.put(String.valueOf(cur), val);
                continue;
            }
            hmap.put(String.valueOf(cur), 1);
        }

        for (int i =0 ; i<b.length();i++){
            char cur = b.charAt(i);
            int val = hmap.get(String.valueOf(cur));
            val -= 1;
            hmap.put(String.valueOf(cur),val);
        }

        for (int k : hmap.values()){
            if (k!=0){
                flag = false;
            }
            //System.out.println(k);
        }

        System.out.println(flag);

    }
}
