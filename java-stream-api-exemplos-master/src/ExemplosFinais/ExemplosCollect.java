package ExemplosFinais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosCollect {

    public static void main(String[] args) throws IOException {
        exemploEstatiticas();
    }

    private static void exemploArray() {
        String[] palavras = {"Java", "é", "uma", "linguagem", "poderosa"};

        String[] arrayColetado = Arrays.stream(palavras)
                .collect(Collectors.toList()) // Coleta em uma lista
                .toArray(new String[0]);

        System.out.println(Arrays.toString(arrayColetado)); // Saída: [Java, é, uma, linguagem, poderosa]

    }

    private static void exemploColecao() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> listaColetada = numeros.stream().collect(Collectors.toList());

        System.out.println(listaColetada); // Saída: [1, 2, 3, 4, 5]

    }

    private static void exemploSobDemanda() {
        Stream<Integer> numerosAleatorios = Stream.generate(() -> new Random().nextInt(100))
                .limit(10); // Gera 10 números aleatórios

        List<Integer> listaColetada = numerosAleatorios.collect(Collectors.toList());

        System.out.println(listaColetada); // Saída: [73, 42, 15, 89, 2, 74, 26, 69, 55, 81]

    }

    private static void exemploArquivo() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\exemplo.txt";
        try (Stream<String> linhas = Files.lines(Paths.get(fileName))) {
            List<String> listaColetada = linhas.collect(Collectors.toList());
            listaColetada.forEach(System.out::println);
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

        Map<String, Integer> mapaColetado = pessoas.stream()
                .collect(Collectors.toMap(Pessoa::getNome, Pessoa::getIdade));

//        System.out.println(mapaColetado.get("Alice"));

        System.out.println(mapaColetado);

    }

    private static void exemploJoin() {
        List<String> palavras = Arrays.asList("Java", "é", "uma", "linguagem", "poderosa");

        String textoColetado = palavras.stream()
                .collect(Collectors.joining(", "));

        System.out.println(textoColetado); // Saída: Java, é, uma, linguagem, poderosa
    }


    private static void exemploGroupBy() {
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie", "Amy", "Bob", "Alice");

        Map<Character, List<String>> nomesAgrupados = nomes.stream()
                .collect(Collectors.groupingBy(nome -> nome.charAt(0)));  // Agrupar por inicial

        System.out.println(nomesAgrupados);
    }

    private static void exemploEstatiticas() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        IntSummaryStatistics estatisticas = numeros.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Soma: " + estatisticas.getSum());
        System.out.println("Média: " + estatisticas.getAverage());
        System.out.println("Mínimo: " + estatisticas.getMin());
        System.out.println("Máximo: " + estatisticas.getMax());
        System.out.println("Quantidade: " + estatisticas.getCount());

    }


}
