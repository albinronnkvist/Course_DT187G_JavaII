package com.albinronnkvist.basics.other;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsApi {
    public void Filter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);
    }

    public void Map() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(doubledNumbers);
    }

    public void Sort() {
        List<String> words = Arrays.asList("banana", "apple", "orange");

        List<String> sortedWords = words.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedWords);
    }

    public void Reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }

    public void Collect() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "banana");

        List<String> distinctWords = words.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctWords);
    }

    public void FindAny() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");

        Optional<String> anyWordWithA = words.stream()
                .filter(w -> w.contains("a"))
                .findAny();

        anyWordWithA.ifPresent(System.out::println);
    }

    public void Count() {
        List<String> words = Arrays.asList("apple", "banana", "orange");

        long count = words.stream()
                .filter(w -> w.contains("a"))
                .count();

        System.out.println(count);
    }

    public void ParallelStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        int max = numbers.parallelStream()
                .max(Integer::compare)
                .get();

        System.out.println(max);
    }

    public void FlatMap() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "mango"),
                Arrays.asList("grape", "melon"));

        List<String> flatList = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);
    }

    public void Peek() {
        List<String> words = Arrays.asList("apple", "banana", "orange");

        List<String> result = words.stream()
                .filter(w -> w.length() > 5)
                .peek(w -> System.out.println("Filtered word: " + w))
                .map(String::toUpperCase)
                .peek(w -> System.out.println("Mapped word: " + w))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
