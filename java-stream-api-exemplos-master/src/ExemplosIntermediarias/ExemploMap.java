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

public class ExemploMap {

    public static void main(String[] args) throws IOException {
        exemploMapFile();
    }

    private static void exemploMapArray() {
        String[] nomes = {"Alice", "Bob", "Carol", "David"};
        Arrays.stream(nomes).forEach(System.out::println);
        // Usando Stream.of para criar um Stream a partir do Array e aplicando map para transformar os nomes em maiúsculas.
        Stream<String> nomesMaiusculos = Arrays.stream(nomes)
                .map(nome -> nome.toUpperCase());

        // Imprimindo os nomes em maiúsculas.
        nomesMaiusculos.forEach(System.out::println);
    }

    private static void exemploMapColecao() {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        System.out.println(numeros);
        // Usando map para dobrar cada número na lista.
        List<Integer> numerosDobrados = numeros.stream()
                .map(numero -> numero * 2)
                .collect(Collectors.toList());

        // Imprimindo a lista com números dobrados.
        System.out.println(numerosDobrados);
    }

    private static void exemploMapFile() throws IOException {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";
        // Lendo as linhas de um arquivo e aplicando map para transformar em maiúsculas.
        Stream<String> linhasMaiusculas = Files.lines(Paths.get(fileName))
                .map(linha -> linha.toUpperCase());

        // Imprimindo as linhas em maiúsculas.
        linhasMaiusculas.forEach(System.out::println);
    }

    private static void exemploMapSobDemanda() {
        // Gerando números inteiros de 1 a 5 e aplicando map para dobrar cada número.
        Stream<Integer> numerosDobrados = Stream.iterate(1, n -> n + 1)
                .limit(5)
                .map(numero -> numero * 2);

        // Imprimindo os números dobrados.
        numerosDobrados.forEach(System.out::println);
    }


    private static void objetoExemplo() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Alice", 25));
        pessoas.add(new Pessoa("Bob", 17));
        pessoas.add(new Pessoa("Carol", 30));
        pessoas.add(new Pessoa("David", 16));
        pessoas.add(new Pessoa("André", 26));

        List<Integer> idades = pessoas.stream()
                .map(p -> p.getIdade())
                .collect(Collectors.toList());

        System.out.println("Pessoas idade:");
        idades.forEach(System.out::println);

        List<String> nomes = pessoas.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());

        System.out.println("Pessoas nomes:");
        nomes.forEach(System.out::println);

    }
}
