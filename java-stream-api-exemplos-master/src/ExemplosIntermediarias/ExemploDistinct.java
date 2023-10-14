package ExemplosIntermediarias;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploDistinct {

    public static void main(String[] args) throws IOException {
        exemploDistinctObjeto();
    }

    private static void exemploDistinctArray() {
        String[] cores = {"vermelho", "verde", "azul", "verde", "azul", "vermelho", "amarelo"};

        String[] coresDistintas = Arrays.stream(cores)
                .distinct()
                .toArray(String[]::new);

        System.out.println(Arrays.toString(coresDistintas));
    }

    private static void exemploDistinctColecao() {
        List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 2, 3, 4, 4, 5);

        List<Integer> numerosDistintos = numeros.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(numerosDistintos);
    }

    private static void exemploDistinctSobDemanda() {
        Random random = new Random();

        Stream<Integer> numerosUnicos = Stream.generate(() -> random.nextInt(21))
                .distinct()
                .limit(10);

        numerosUnicos.forEach(System.out::println);
    }

    private static void exemploDistinctArquivo() throws IOException {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";

        Stream<String> linhas = Files.lines(Paths.get(fileName));

        linhas.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .forEach(System.out::println);

        linhas.close();
    }

    private static void exemploDistinctObjeto() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Alice", 25));
        pessoas.add(new Pessoa("Bob", 17));
        pessoas.add(new Pessoa("Alice", 25)); // duplicado
        pessoas.add(new Pessoa("Alice", 25)); // duplicado
        pessoas.add(new Pessoa("David", 16));

        List<Pessoa> pessoasDistintas = pessoas.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Pessoas distintas:");
        pessoasDistintas.forEach(System.out::println);

    }


}
