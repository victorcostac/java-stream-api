package ExemplosFinais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExemplosForEach {

    public static void main(String[] args) throws IOException {
        exemploObjeto();
    }

    private static void exemploArray() {
        String[] nomes = {"Alice", "Bob", "Charlie"};

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }

        for (String nome: nomes) {
            System.out.println(nome);
        }

        // Usando forEach para imprimir os nomes
        Arrays.stream(nomes).forEach(nome -> System.out.println(nome));

        // Usando forEach para simplificado
        Arrays.stream(nomes).forEach(System.out::println);

    }

    private static void exemploColecao() {
        List<String> listaNomes = new ArrayList<>();
        listaNomes.add("Alice");
        listaNomes.add("Bob");
        listaNomes.add("Charlie");

        for (int i = 0; i < listaNomes.size(); i++) {
            System.out.println(listaNomes.get(i));
        }

        for (String nome: listaNomes) {
            System.out.println(nome);
        }

        // Usando forEach para imprimir os nomes
        listaNomes.stream().forEach(nome -> System.out.println(nome));

        // Usando forEach para simplificado
        listaNomes.forEach(System.out::println);

    }

    private static void exemploSobDemanda() {
        // Criando um fluxo de números inteiros de 1 a 5 e usando forEach para imprimir cada número
        Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5);
        numeros.forEach(numero -> System.out.println(numero));
    }

    private static void exemploArquivo() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";
        try {
            // Lendo linhas de um arquivo e usando forEach para imprimir cada linha
            Files.lines(Paths.get(fileName))
                    .forEach(linha -> System.out.println(linha));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exemploObjeto() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 30),
                new Pessoa("Bob", 25),
                new Pessoa("Charlie", 35)
        );

    }
}
