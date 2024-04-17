import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputFormatting {
    public static void main(String[] args) throws IOException {
        String a = "Java";
        // - : align left，沒加的話是align right
        String test = String.format("%-8s", a);
        System.out.println(test);
        System.out.println(test.length());
        int b = 2165;
        String d = String.format("%03d",b);
        System.out.println(d);

        // given input N,
        // print output "2x1=2" "2x2=4" ... from 1 to 10
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 1; i<11 ;i++){
            String output = String.format("%dx%d=%d",N,i,N*i);
            System.out.println(output);
        }
        bufferedReader.close();

    }
}
