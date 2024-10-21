import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//@FunctionalInterface //добавьте аннотацию
//interface Summator {
//    int sum(int n1, int n2);
//}

public class Practicum {

    public static void main(String[] args) {
        // сохраните лямбду в переменную
        // лямбда должна складывать два целых числа
        BiFunction<Integer, Integer, Integer> summator = (n1, n2)  -> n1 + n2;
        // допишите код, использующий лямбду
        System.out.println("Сумма 23 и 65 равна " + summator.apply(23, 65));

        Predicate<Integer> isEven = num -> num % 2 == 0;

        if (isEven.test(12346)) {
            System.out.println("Число чётное");
        } else {
            System.out.println("Число нечётное");
        }

        Consumer<Double> outputDoubleConsumer =
                num -> System.out.println(String.format("Передано число %.2f", num));

        outputDoubleConsumer.accept(1234.5678);
    }
}