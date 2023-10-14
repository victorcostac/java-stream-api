package ExemplosIntermediarias;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploSorted {

    public static void main(String[] args) {

    }

    private static void exemploArray() {
        String[] nomes = {"Maria", "João", "Ana", "Pedro"};
        Arrays.stream(nomes)
                .sorted()
                .forEach(System.out::println);
    }

    private static void exemploColecao() {
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 3);
        List<Integer> numerosOrdenados = numeros.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(numerosOrdenados);
    }

    private static void exemploSobDemanda() {
        Random random = new Random();
        Stream<Integer> numerosUnicos = Stream.generate(() -> random.nextInt(21))
                .limit(10);

        numerosUnicos.sorted().forEach(System.out::println);
    }

    private static void exemploFile() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\nomes.txt";
        Path caminhoArquivo = Paths.get(fileName);
        try {
            Files.lines(caminhoArquivo)
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void exemploObjeto() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 30),
                new Pessoa("Bob", 25),
                new Pessoa("Carol", 35)
        );

        List<Pessoa> pessoasOrdenadasPorIdade = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .collect(Collectors.toList());

        System.out.println(pessoasOrdenadasPorIdade);
    }


}

