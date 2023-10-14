package ProblemasComuns;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Armadilhas {

    public static void main(String[] args) throws IOException {
        nullPointer();
    }

    private static void reutilizaStream() {
        List<String> strings = Arrays.asList("a", "b", "c");
        Stream<String> stream = strings.stream();
        long count = stream.count(); // Consumiu o Stream
        stream.forEach(System.out::println); // Isso causará uma exceção

    }

    private static void intermediariaSemFinais() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream x = numbers.stream().map(n -> n * 2);
        // Nenhuma operação terminal, nada será feito

        System.out.println(x);

    }

    private static void nullPointer() throws IOException {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 30),
                new Pessoa("Bob", 25),
                null,
                new Pessoa("Charlie", 35)
        );

        Map<String, Integer> mapaColetado = pessoas.stream()
                .collect(Collectors.toMap(Pessoa::getNome, Pessoa::getIdade));

        System.out.println(mapaColetado);

    }

}
