public class Pessoa {

    String nome;
    String sobrenome;

    Endereco endereco;
    String cpf;
    String rg;

    public Pessoa(String nome, String sobrenome, Endereco endereco, String cpf, String rg){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
    }
}
