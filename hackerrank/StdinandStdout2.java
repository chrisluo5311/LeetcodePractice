import java.util.*;
public class StdinandStdout2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        // The problem is with the input.nextInt() method;
        // it only reads the int value.
        // So when you continue reading with input.nextLine() you receive the "\n" Enter key.
        // So to skip this you have to add the input.nextLine().
        scan.nextLine();
        String s = scan.nextLine();
        System.out.println(i);
        System.out.println(d);
        System.out.println(s);
    }
}
