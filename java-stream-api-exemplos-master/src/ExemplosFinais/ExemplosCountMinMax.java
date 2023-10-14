package ExemplosFinais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExemplosCountMinMax {

    public static void main(String[] args) throws IOException {
        exemploCountSobDemanda();
    }

    private static void exemploMinArray() {
        int[] numeros = {5, 2, 9, 1, 7};

        OptionalInt menorNumero = IntStream.of(numeros).min();

        if (menorNumero.isPresent()) {
            System.out.println("O menor número é: " + menorNumero.getAsInt());
        } else {
            System.out.println("O array está vazio.");
        }
    }

    private static void exemploMinColecao() {
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 7);

        Optional<Integer> menorNumero = numeros.stream()
                .min(Integer::compareTo);

        if (menorNumero.isPresent()) {
            System.out.println("O menor número é: " + menorNumero.get());
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    private static void exemploMinSobDemanda() {
        Stream<Integer> numeros = Stream.iterate(1, n -> n + 1);

        Optional<Integer> menorNumero = numeros
                .limit(10) // Limita a sequência aos primeiros 10 números
                .min(Integer::compareTo);

        if (menorNumero.isPresent()) {
            System.out.println("O menor número na sequência é: " + menorNumero.get());
        } else {
            System.out.println("A sequência está vazia.");
        }
    }

    private static void exemploMinArquivo() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\numeros.txt";
        try (Stream<String> linhas = Files.lines(Paths.get(fileName))) {
            Optional<Integer> menorNumero = linhas
                    .flatMap(line -> Stream.of(line.split(",")))
                    .map(Integer::parseInt)
                    .min(Integer::compareTo);

            if (menorNumero.isPresent()) {
                System.out.println("O menor número no arquivo é: " + menorNumero.get());
            } else {
                System.out.println("O arquivo está vazio.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exemploCountArquivo() throws IOException {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";
        Path filePath = Path.of(fileName);

        long count = Files.lines(filePath)
                .filter(line -> line.contains("Java"))
                .count();

        System.out.println("Quantidade de linhas com a palavra 'Java': " + count);
    }

    private static void exemploCountArray() {
        String[] palavras = {"Amor", "Alegria", "Casa", "Abacaxi", "Futebol"};

        long count = Arrays.stream(palavras)
                .filter(palavra -> palavra.startsWith("A"))
                .count();

        System.out.println("Quantidade de palavras que começam com 'A': " + count);
    }

    private static void exemploCountColecao() {
        List<Integer> numeros = Arrays.asList(1, 2, 6, 8, 3, 9, 7);

        long count = numeros.stream()
                .filter(numero -> numero > 5)
                .count();

        System.out.println("Quantidade de números maiores que 5: " + count);

    }

    private static void exemploCountSobDemanda() {
        long count = IntStream.rangeClosed(1, 10).count();

        System.out.println("Quantidade de números no stream é: " + count);
    }
}
