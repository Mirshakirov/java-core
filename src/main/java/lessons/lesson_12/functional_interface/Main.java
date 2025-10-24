package lessons.lesson_12.functional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Predicate<String> startsWithA = s -> s != null && s.startsWith("A");
        System.out.println(startsWithA.test("Apple"));
        System.out.println(startsWithA.test("Banana"));

        Function<String, Integer> wordLength = String::length;
        System.out.println("Length of 'Functional': " + wordLength.apply("Functional"));

        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random 1: " + randomSupplier.get());
        System.out.println("Random 2: " + randomSupplier.get());

        Consumer<String> printReversed = s -> System.out.println(new StringBuilder(s).reverse());
        printReversed.accept("Hello World");

        BiFunction<Integer, Integer, Double> average = (a, b) -> (a + b) / 2.0;
        System.out.println("Average: " + average.apply(5, 9));

        Function<String, String> trim = String::trim;
        Function<String, String> capitalize = s -> s.toUpperCase(Locale.ROOT);
        Function<String, String> cleanAndCapitalize = trim.andThen(capitalize);
        System.out.println(cleanAndCapitalize.apply("   java developer  "));

        Predicate<Integer> customCheck = buildPredicate();
        System.out.println(customCheck.test(-10));
        System.out.println(customCheck.test(7));

        UnaryOperator<String> shout = s -> s + "!!!";
        System.out.println(shout.apply("Amazing"));

        List<Integer> numbers = List.of(10, 15, 20, 25, 30);
        List<Integer> oddNumbers = filter(numbers, n -> n % 2 != 0);
        System.out.println("Odd numbers: " + oddNumbers);

        List<String> animals = List.of("lion", "tiger", "cat", "elephant");
        List<Integer> nameLengths = map(animals, String::length);
        System.out.println("Animal name lengths: " + nameLengths);

        forEach(animals, a -> System.out.println("Animal: " + a));

        List<String> randomIds = generate(() -> UUID.randomUUID().toString().substring(0, 8), 4);
        System.out.println("Generated IDs: " + randomIds);
    }

    private static Predicate<Integer> buildPredicate() {
        Consumer<Integer> show = x -> System.out.println("Checked number: " + x);
        Consumer<Integer> showSquare = x -> System.out.println("Square: " + (x * x));
        Consumer<Integer> combined = show.andThen(showSquare);
        combined.accept(4);

        Predicate<Integer> isNegative = n -> n < 0;
        Predicate<Integer> isDivisibleBy3 = n -> n % 3 == 0;
        return isNegative.or(isDivisibleBy3);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) result.add(item);
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T item : list) consumer.accept(item);
    }

    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(supplier.get());
        }
        return result;
    }
}
