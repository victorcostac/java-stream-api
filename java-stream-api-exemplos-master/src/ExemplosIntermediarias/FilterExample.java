package ExemplosIntermediarias;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExample {

    public static void main(String[] args) {
        objetoExemplo();
    }

    private static void filterExampleArray() {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Números: " + Arrays.toString(numbers));

        // Filtrar números ímpares do array
        int[] oddNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .toArray();

        System.out.println("Números ímpares: " + Arrays.toString(oddNumbers));
    }

    private static void filterExampleCollection() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("Números: " + numbers);

        // Filtrar números pares da lista
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + evenNumbers);
    }

    private static void filterExampleFile() throws IOException {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";

        // Filtrar linhas que contenham a palavra "Java" no arquivo
        List<String> javaLines = Files.lines(Paths.get(fileName))
                .filter(line -> line.contains("Java"))
                .collect(Collectors.toList());

        System.out.println("Linhas com a palavra 'Java':");
        javaLines.forEach(System.out::println);
    }

    private static void filterExample() {
        // Gerar uma sequência infinita de números naturais
        Stream<Integer> naturalNumbers = Stream.iterate(1, n -> n + 1)
                .limit(50);

        // Filtrar os números pares
        List<Integer> firstTenEvenNumbers = naturalNumbers
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Os primeiros 10 números pares: " + firstTenEvenNumbers);
    }

    private static void objetoExemplo() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Alice", 25));
        pessoas.add(new Pessoa("Bob", 17));
        pessoas.add(new Pessoa("Carol", 30));
        pessoas.add(new Pessoa("David", 16));
        pessoas.add(new Pessoa("André", 26));

        // Filtrar pessoas com idade superior a 18 anos
        List<Pessoa> maioresDeIdade = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .collect(Collectors.toList());

        System.out.println("Pessoas maiores de idade:");
        maioresDeIdade.forEach(System.out::println);

        // Filtrar pessoas que começam com 'A'
        List<Pessoa> pessoassComA = pessoas.stream()
                .filter(p -> p.getNome().startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Pessoas que começam com 'A':");
        pessoassComA.forEach(System.out::println);

    }
}
