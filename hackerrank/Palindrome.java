/**
 * <a href="https://www.geeksforgeeks.org/java-program-to-check-whether-a-string-is-a-palindrome/">...</a>
 * */
public class Palindrome {
    public static void main(String[] args) {
        String A = "madam";
        String reverse = "";
        for (int i = A.length()-1;i >= 0;i--){
            reverse = reverse + A.charAt(i);
        }
        System.out.println(reverse);
        if (A.equals(reverse)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
