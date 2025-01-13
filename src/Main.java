import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        exerc1();
        exerc2();

    }

    public static void exerc1() {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        List<Integer> output = input.stream()
                .map(str -> {
                    try {
                        return Optional.of(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                        return Optional.<Integer>empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println(output);
    }

    public static void exerc2() {
        System.out.println(processaNumero(Optional.of(5))); // Saída: Optional[25]
        System.out.println(processaNumero(Optional.of(-3))); // Saída: Optional.empty
        System.out.println(processaNumero(Optional.empty())); // Saída: Optional.empty

    }

    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        return numero.filter(n -> n > 0).map(n -> n * n);
    }
}