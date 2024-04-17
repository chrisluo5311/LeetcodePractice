import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

//([A-Z])(.+)
//[AZ[a-z](a-z)
//batcatpat(nat
public class CheckRegexPattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            //Write your code
            try{
                Pattern pat = Pattern.compile(pattern);
            } catch (PatternSyntaxException e){
                System.out.println("Invalid");
                testCases--;
                continue;
            }
            System.out.println("Valid");
            testCases--;
        }
    }
}
