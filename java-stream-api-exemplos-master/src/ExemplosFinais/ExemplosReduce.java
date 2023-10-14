package ExemplosFinais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExemplosReduce {

    public static void main(String[] args) throws IOException {
        exemploArray();
    }

    private static void exemploArray() {
        String[] palavras = {"Olá", "Mundo", "Stream", "Java"};

        String resultado = Arrays.stream(palavras)
                .reduce("", (acumulador, palavra) -> acumulador + palavra);

        System.out.println("Concatenação: " + resultado);
    }

    private static void exemploColecao() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        int soma = numeros.stream()
                .reduce(0, (acumulador, elemento) -> acumulador + elemento);

        System.out.println("A soma é: " + soma);
    }

    private static void exemploSobDemanda() {
        long produto = Stream.generate(() -> (int) (Math.random() * 10))
                .limit(5)
                .reduce(1, (acumulador, numero) -> acumulador * numero);

        System.out.println("O produto dos números gerados é: " + produto);
    }

    private static void exemploArquivo() {
        String fileName = "C:\\Users\\luizn\\Documents\\gitRepositories\\java-stream-api-exemplos\\src\\numeros.txt";
        try {
            int soma = Files.lines(Paths.get(fileName))
                    .map(Integer::parseInt)
                    .reduce(0, (acumulador, numero) -> acumulador + numero);

            System.out.println("A soma dos números do arquivo é: " + soma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
