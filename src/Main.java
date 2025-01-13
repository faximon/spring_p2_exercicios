import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        exerc1();
//        exerc2();
//        exerc3();
//        exerc4();
        exerc5();
        exerc6();
        exerc7();

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

    public static void exerc3() {
        System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
        System.out.println(obterPrimeiroEUltimoNome("Maria   ")); // Saída: "Maria"

    }

    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        String[] nomes = nomeCompleto.trim().split("\\s+");
        if (nomes.length == 1) {
            return nomes[0];
        }
        return nomes[0] + " " + nomes[nomes.length -1];
    }

    public static void exerc4() {
        System.out.println(ehPalindromo("subi no onibus"));
        System.out.println(ehPalindromo("Java"));
    }

    public static boolean ehPalindromo(String palavra) {
        String semEspacos = palavra.replace(" ", "").toLowerCase();
        return new StringBuilder(semEspacos).reverse().toString().equalsIgnoreCase(semEspacos);
    }

    public static void exerc5() {
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converterEmails(emails));
// Saída: ["teste@exemplo.com", "exemplo@java.com", "usuario@teste.com"]
    }

    public static List<String> converterEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.trim().toLowerCase())
                .toList();
    }

    public static void exerc6() {
        System.out.println("Fevereiro: " + Mes.FEVEREIRO.getNumeroDeDias() + " dias"); //28 dias
        System.out.println("Julho: " + Mes.JULHO.getNumeroDeDias() + " dias"); //31 dias
    }

    public static void exerc7() {
        System.out.println(Moeda.DOLAR.converterPara(100));
        System.out.println(Moeda.EURO.converterPara(100));
    }
}

