package lessons.lesson_12.stream_api.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void evenNumbers(List<Integer> numbers) {
        List<Integer> newNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println(newNumbers);
    }

    public static void countLine(List<String> words) {
        long count = words.stream()
                .filter(w -> w.length() > 5)
                .count();
        System.out.println(count);
    }

    public static void minAndMax(List<Integer> nums) {
        Optional<Integer> min = nums.stream()
                .min(Comparator.naturalOrder());

        Optional<Integer> max = nums.stream()
                .max(Comparator.naturalOrder());

        System.out.println("Min: " + min + "\nMax:" + max);
    }

    public static void countAvgLine(List<String> names) {
        OptionalDouble count = names.stream()
                .mapToInt(String::length)
                .average();

        System.out.println(count);
    }

    public static void sortAndDeleteDuplicate(List<String> input) {
        List<String> newInput = input.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(newInput);
    }

    public static void listToMap(List<String> fruits) {
        Map<String, Integer> newFruits = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        fruit -> fruit.length()
                ));
        System.out.println(newFruits);
    }

    public static void groupNames(List<String> names) {
        Map<Character, List<String>> groupedNames = names.stream()
                .collect(Collectors.groupingBy(s -> s.toUpperCase().charAt(0)));
        System.out.println(groupedNames);
    }

    public static void separateByCommas(List<String> names) {
        String allNames = names.stream()
                .map(s -> s + ", ")
                .toString();
        System.out.println(allNames);
    }

    public static void eachWord(List<String> sentence) {
        List<String> words = sentence.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();
        System.out.println(words);
    }

    public static void searchTheRichestProduct(List<Main.Product> products) {
        Map<String, Main.Product> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Main.Product::category,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Main.Product::price)),
                                Optional::get
                        )
                ));
        System.out.println(mostExpensiveByCategory);
    }
}
