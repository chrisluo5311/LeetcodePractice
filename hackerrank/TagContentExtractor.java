import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {
        String[] inputLines = {
                "<h1>Nayeem loves counseling</h1>",
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                "<Amee>safat codes like a ninja</amee>",
                "<SA premium>Imtiaz has a secret crush</SA premium>"
        };

        List<String> extractedContents = extractContents(inputLines);

        for (String content : extractedContents) {
            System.out.println(content);
        }
    }

    private static List<String> extractContents(String[] lines) {
        List<String> results = new ArrayList<>();
        Pattern tagPattern = Pattern.compile("<(.+)>([^<]*)</\\1>");

        for (String line : lines) {
            Matcher matcher = tagPattern.matcher(line);
            boolean found = false;

            while (matcher.find()) {
                //System.out.println("group(): "+ matcher.group());//<h1>Nayeem loves counseling</h1>
                //System.out.println("group(1): "+matcher.group(1));//h1
                //System.out.println("group(2): "+matcher.group(2));//Nayeem loves counseling
                String content = matcher.group(2).trim();
                if (!content.isEmpty()) {
                    results.add(content);
                    found = true;
                }
            }

            if (!found) {
                results.add("None");
            }
        }

        return results;
    }
}
