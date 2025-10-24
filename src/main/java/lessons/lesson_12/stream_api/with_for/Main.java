package lessons.lesson_12.stream_api.with_for;

import java.util.List;

public class Main {
    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(7, 12, 19, 24, 33, 42);
        List<String> words = List.of("notebook", "pen", "bottle", "backpack", "charger");
        List<Integer> nums = List.of(99, 15, 2, 87, 45, 120);
        List<String> names = List.of("Michael", "Sarah", "John", "Elizabeth", "Kate");
        List<String> input = List.of("banana", "orange", "apple", "banana", "apple", "pear");
        List<String> fruits = List.of("kiwi", "watermelon", "mango", "plum");
        List<String> names2 = List.of("Tom", "Jerry", "Spike", "Tyke", "Butch");
        List<String> sentences = List.of("Learning Java takes time", "Practice makes perfect", "Keep coding daily");
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 2500),
                new Product("Headphones", "Electronics", 400),
                new Product("Strawberry", "Fruits", 3.5),
                new Product("Orange", "Fruits", 2.8),
                new Product("T-shirt", "Clothes", 25),
                new Product("Jacket", "Clothes", 75)
        );

        System.out.print("Even numbers: ");
        Functionality.evenNumbers(numbers);
        System.out.println();

        System.out.print("Words longer than 5 letters: ");
        Functionality.countLine(words);

        System.out.println("Min and Max:");
        Functionality.minAndMax(nums);

        System.out.print("Average name length: ");
        Functionality.countAvgLine(names);

        System.out.print("Sorted unique input: ");
        Functionality.sortAndDeleteDuplicate(input);

        System.out.print("List to map: ");
        Functionality.listToMap(fruits);

        System.out.print("Grouped names: ");
        Functionality.groupNames(names2);

        System.out.print("Names separated by commas: ");
        Functionality.separateByCommas(names2);

        System.out.print("All sentences in one line: ");
        Functionality.eachWord(sentences);

        System.out.print("Most expensive product by category: ");
        Functionality.searchTheRichestProduct(products);
    }
}
