package lessons.lesson_12.stream_api.streams;

import java.util.List;

public class Main {
    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 13, 19, 24, 33, 42);
        List<String> words = List.of("macbook", "pen", "bottle", "backpack", "charger");
        List<Integer> nums = List.of(98, 15, 2, 87, 45, 120);
        List<String> names = List.of("Johny", "Sarah", "John", "Elizabeth", "Kate");
        List<String> input = List.of("pineapple", "orange", "apple", "banana", "apple", "pear");
        List<String> fruits = List.of("kiwi", "watermelon", "mango", "plum");
        List<String> names2 = List.of("Tom", "Jerry", "Spike", "Tyke", "Butch");
        List<String> sentences = List.of("Learning Java takes time", "Practice makes perfect", "Keep coding daily");
        List<lessons.lesson_12.stream_api.streams.Main.Product> products = List.of(
                new lessons.lesson_12.stream_api.streams.Main.Product("Laptop", "Electronics", 2500),
                new lessons.lesson_12.stream_api.streams.Main.Product("Headphones", "Electronics", 400),
                new lessons.lesson_12.stream_api.streams.Main.Product("Strawberry", "Fruits", 3.5),
                new lessons.lesson_12.stream_api.streams.Main.Product("Orange", "Fruits", 2.8),
                new lessons.lesson_12.stream_api.streams.Main.Product("T-shirt", "Clothes", 25),
                new lessons.lesson_12.stream_api.streams.Main.Product("Jacket", "Clothes", 75)
        );

        System.out.print("Even numbers: ");
        Streams.evenNumbers(numbers);
        System.out.println();

        System.out.print("Words longer than 5 letters: ");
        Streams.countLine(words);

        System.out.println("Min and Max:");
        Streams.minAndMax(nums);

        System.out.print("Average name length: ");
        Streams.countAvgLine(names);

        System.out.print("Sorted unique input: ");
        Streams.sortAndDeleteDuplicate(input);

        System.out.print("List to map: ");
        Streams.listToMap(fruits);

        System.out.print("Grouped names: ");
        Streams.groupNames(names2);

        System.out.print("Names separated by commas: ");
        Streams.separateByCommas(names2);

        System.out.print("All sentences in one line: ");
        Streams.eachWord(sentences);

        System.out.print("Most expensive product by category: ");
        Streams.searchTheRichestProduct(products);
    }
}
