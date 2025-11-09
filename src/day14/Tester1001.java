package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester1001 {

    public static void main(String[] args) {
        String str = "Nithin";
        Map<Character, Long> freqMap = str.chars()  // IntStream of characters
                .mapToObj(c -> (char) c)            // Convert to Character stream
                .collect(Collectors.groupingBy(
                        c -> c,                     // group by character
                        Collectors.counting()       // count occurrences
                ));

    }
}


///User-Detail
//thread pool executor 3.4.2