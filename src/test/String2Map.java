package test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class String2Map {
    public static void main(String[] args) {
        String a = "hello";
//        Map<Integer, String> collect = Arrays.stream(split).collect(Collectors.toMap(k -> a.lastIndexOf(k), v -> v));
//        IntStream.range(0,a.length()).collect(Collectors.toMap(key-> key, v-> v));
        Map<Integer, Character> collect = Stream.iterate(0, i -> i + 1).limit(a.length()).collect(Collectors.toMap(key -> key, v -> a.charAt(v)));
        collect.forEach((key,value)-> System.out.println(key + ": " + value));
        Map<Integer, Character> collect1 = IntStream.range(0, a.length()).mapToObj(Integer::valueOf).collect(Collectors.toMap(k -> k, v -> a.charAt(v)));
        collect1.forEach((key,value)-> System.out.println(key + ": " + value));
    }
}
