package streamAPI_test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamAPITests {
    public static void main(String[] args) {
        // Stream creations
        String[] arr = new String[]{"a", "b", "c", "d"};
        Stream<String> arrStream1 = Arrays.stream(arr);
        Stream<String> arrStream2 = Stream.of(arr);

//        Stream<String> stream = list.stream();
    }
}
