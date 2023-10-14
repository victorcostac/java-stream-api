package ExemplosIntermediarias;

import ExemplosFinais.Pessoa;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploFlatMap {

    public static void main(String[] args) throws IOException {
        exemploMapColecao();
    }

    private static void exemplo1() {
        List<List<Integer>> listaDeListas = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> numeros = listaDeListas.stream()
                .flatMap(lista -> lista.stream())
                .collect(Collectors.toList());

        System.out.println(listaDeListas);
        System.out.println(numeros);
    }

    private static void exemploMapColecao() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("João", 20, Arrays.asList("111-111-1111", "222-222-2222")),
                new Pessoa("Maria",20, Arrays.asList("333-333-3333")),
                new Pessoa("Pedro",20, Arrays.asList("444-444-4444", "555-555-5555"))
        );

        List<String> numerosDeTelefone = pessoas.stream()
                .flatMap(pessoa -> pessoa.getTelefones().stream())
                .collect(Collectors.toList());
        System.out.println(numerosDeTelefone);
    }
}
