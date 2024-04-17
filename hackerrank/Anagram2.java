import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagram2 {

    public static void main(String[] args) {
        //第一種寫法
        String a = "anagram";
        String b = "margana";

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(b1);
        System.out.println(Arrays.equals(a1,b1));


        //第二種寫法
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() != b.length()){
            System.out.println("not anagram");
        }

        int[] arr = new int[26];

        for (int i =0; i<a.length();i++){
            arr[a.charAt(i)-'a']++;
            arr[b.charAt(i)-'a']--;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                System.out.println("not anagram");
            }
        }

        System.out.println("anagram");
    }
}
