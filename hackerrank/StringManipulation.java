import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int aLength = A.length();
        int bLength = B.length();
        System.out.println(aLength+bLength);
        char a = A.charAt(0);
        char b = B.charAt(0);
        System.out.println(((Object) a).getClass().getSimpleName());
        System.out.println(A.getClass().getSimpleName());
        if (a > b){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        String capitalizedA = A.substring(0,1).toUpperCase() + A.substring(1);
        String capitalizedB = B.substring(0,1).toUpperCase() + B.substring(1);
        System.out.println(capitalizedA + " " + capitalizedB);
    }
}
