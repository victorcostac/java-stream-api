package ExemplosFinais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ExemplosFind {

    public static void main(String[] args) throws IOException {
        findAny();
    }

    private static void exemploArray() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        Optional<String> firstNameStartingWithA = Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .findFirst();

        if (firstNameStartingWithA.isPresent()) {
            System.out.println("Primeiro nome começando com 'A': " + firstNameStartingWithA.get());
        } else {
            System.out.println("Nenhum nome encontrado.");
        }
    }

    private static void exemploColecao() {
        List<Integer> numbers = Arrays.asList(5, 8, 12, 15, 7);

        Optional<Integer> firstNumberGreaterThan10 = numbers.stream()
                .filter(num -> num > 10)
                .findFirst();

        if (firstNumberGreaterThan10.isPresent()) {
            System.out.println("Primeiro número maior que 10: " + firstNumberGreaterThan10.get());
        } else {
            System.out.println("Nenhum número encontrado.");
        }
    }

    private static void exemploSobDemanda() {
        Stream<Integer> evenNumbers = Stream.iterate(2, n -> n + 2);

        Optional<Integer> firstNumberGreaterThan20 = evenNumbers
                .filter(num -> num > 20)
                .findFirst();

        if (firstNumberGreaterThan20.isPresent()) {
            System.out.println("Primeiro número maior que 20: " + firstNumberGreaterThan20.get());
        } else {
            System.out.println("Nenhum número encontrado.");
        }
    }

    private static void exemploArquivo() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";
        try {
            Optional<String> firstLineWithJava = Files.lines(Paths.get(fileName))
                    .filter(line -> line.contains("Java"))
                    .findFirst();

            if (firstLineWithJava.isPresent()) {
                System.out.println("Primeira linha com a palavra 'Java': " + firstLineWithJava.get());
            } else {
                System.out.println("Nenhuma linha encontrada com a palavra 'Java'.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findAny() {
        List<Integer> numbers = Arrays.asList(5, 8, 12, 15, 7);
        Optional<Integer> any = numbers.parallelStream() // Stream paralelo
                .findAny();

        System.out.println(any.get());
    }
}
