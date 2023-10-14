package ExemplosEncadeamento;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemplosEncadeamento {

    public static void main(String[] args) throws IOException {
        exemplo1();
    }

    private static void exemplo1() throws IOException {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int resultado = numeros.stream()
                .filter(n -> n % 2 == 0)         // Passo 1: Filtrar números pares
                .mapToInt(n -> n * 2)            // Passo 2: Dobrar o valor de cada número
                .sum();                          // Passo 3: Somar todos os números resultantes

        System.out.println("Resultado: " + resultado);
    }

    private static void exemplo2() {
        List<Integer> numeros = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        List<Integer> numerosOrdenados = numeros.stream()
                .distinct()  // Remover duplicatas
                .sorted()    // Ordenar em ordem natural
                .collect(Collectors.toList());

        System.out.println(numerosOrdenados);
    }

    private static void exemplo3() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 25),
                new Pessoa("Bob", 30),
                new Pessoa("Charlie", 22),
                new Pessoa("David", 35)
        );

        double mediaIdades = pessoas.stream()
                .mapToDouble(Pessoa::getIdade)
                .average()
                .orElse(0.0);  // Caso não haja elementos, a média é 0.0

        System.out.println("Média de idades: " + mediaIdades);
    }

    private static void exemplo4() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 25),
                new Pessoa("Bob", 30),
                new Pessoa("Charlie", 22),
                new Pessoa("David", 35)
        );

        List<String> pessoasVelhas = pessoas.stream()
                .filter(produto -> produto.getIdade() > 25)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        System.out.println("Pessoas com idade mais que 25: " + pessoasVelhas);
    }
}
