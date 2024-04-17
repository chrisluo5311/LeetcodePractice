import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMathcing {

    public static void main(String[] args) {
        String str = "He is a very very good boy, isn't he?";
        String hidden1 = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
        String hidden2 = " ";
        //[A-Za-z !,?._'@]+
        String[] result = hidden1.trim().split("[^A-Za-z]+");

        System.out.println("分開的模樣："+Arrays.toString(result));
        List<String> finalReulst = new ArrayList<String>();
        for (String s : result) {
            if(!s.isEmpty()){
                finalReulst.add(s);
            }
        }
        System.out.println(finalReulst.size());
        for (String s : result) {
            System.out.println(s);
        }

    }
}
