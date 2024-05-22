import java.util.Scanner;

public class Endereco {

    static Scanner scanner = new Scanner(System.in);
    static String cep;
    static String rua;
    static String numero;
    static String bairro;
    static String cidade;
    static String estado;
    static String pais;

    public Endereco(String s, String cep, String rua, String numero,String cidade, String bairro, String estado){
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public static Endereco criarEndereco(){

        System.out.println("Digitar o CEP: ");
        String cep = scanner.next();

        System.out.println("Digita a rua: ");
        String rua = scanner.next();

        System.out.println("Digite o número: ");
        String numero = scanner.next();

        System.out.println("Digite o bairro: ");
        String bairro = scanner.next();

        System.out.println("Digite a cidade: ");
        String cidade = scanner.next();

        System.out.println("Digite o estado: ");
        String estado = scanner.next();

        System.out.println("Digite o país: ");
        String pais = scanner.next();

        Endereco endereco = new Endereco(cep, rua, numero, cidade, bairro, estado, pais);

        return endereco;
    }

    public static String exibirEndereco(Endereco endereco){
        return " ------- DADOS DO ENDEREÇO ---------- " +
                "\n\tCEP: " + cep +
                "\n\tRua: " + rua +
                "\n\tNúmero: " + numero +
                "\n\tBairro: " + bairro +
                "\n\tCidade: " + cidade +
                "\n\tPaís: " + pais;
    }

}
