import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

    public static void main(String[] args) {
        List<Integer> inputNumbers = List.of(2, 5, 4, 2, 3, 8);

        List<Integer> evenNumbers2 = inputNumbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers2);
    }
}