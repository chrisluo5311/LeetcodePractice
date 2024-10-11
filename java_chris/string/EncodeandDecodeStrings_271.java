package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeandDecodeStrings_271 {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append("π");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        String[] decodedString = s.split("π",-1);
        return new ArrayList<>(Arrays.asList(decodedString).subList(0,decodedString.length - 1));
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("");
        String encodeStr = encode(input);
        List<String> res = decode(encodeStr);
    }
}
