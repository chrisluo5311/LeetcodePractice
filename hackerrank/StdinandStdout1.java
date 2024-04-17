import java.util.*;
public class StdinandStdout1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        while(scn.hasNext()){
            int a = scn.nextInt();
            System.out.println(a);
        }
        scn.close();
    }
}
