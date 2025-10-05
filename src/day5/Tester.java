package day5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Long> map =
                Stream.of(words).collect(Collectors.groupingBy(
                        key -> key,
                        Collectors.counting()
                ));

        PriorityQueue<Map.Entry<String, Long>> priorityQueue =
        map.entrySet().stream().collect(Collectors.toCollection(()->new PriorityQueue<Map.Entry<String, Long>>((a, b) -> (a.getValue() == b.getValue()) ?
                a.getKey().compareTo(b.getKey())
                : b.getValue().intValue() - a.getValue().intValue())));


        List<String> strings = new ArrayList<>();
        while (!priorityQueue.isEmpty() && k>0) {
            strings.add(priorityQueue.poll().getKey());
            k--;
        }
        return strings;
    }

    public static void main(String[] args) {
        String input = "I love leet code. I love leet code. I love";
        input = input.toLowerCase();
        String[] inputArray = input.split(" ");
        inputArray = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "a", "a"};

        new Tester().topKFrequent(inputArray, 3);
    }
}
