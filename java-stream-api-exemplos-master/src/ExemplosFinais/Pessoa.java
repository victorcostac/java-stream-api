package ExemplosFinais;

import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private List<String> telefones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public Pessoa(String nome, int idade, List<String> telefones) {
        this.nome = nome;
        this.idade = idade;
        this.telefones = telefones;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
    }

}
