import javax.naming.ldap.ExtendedRequest;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Cliente extends Pessoa {
    
    static Scanner scanner = new Scanner(System.in);
    
    static String numeroConta;
    TipoConta tipoConta;
    UUID idCliente;
    static  double saldo;
    static double chequeEspecial;
    
    public static String geradorNumeroConta(){
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(9999) + 1;
        return String.valueOf(valor);
    }
    
    public static double atribuidorChequeEspecial() {
        double chequeEspecial;

        if (saldo > 10000) {
            chequeEspecial = 5000;
        } else if (saldo >= 5000) {
            chequeEspecial = 3000;
        } else if (saldo >= 1000) {
            chequeEspecial = 500;
        } else if (saldo >= 500) {
            chequeEspecial = 300;
        } else {
            chequeEspecial = 0;
        }
        return chequeEspecial;
    }
    
    public Cliente(String nome, String sobrenome, Endereco endereco, String cpf, String rg, TipoConta tipoConta, double saldo){
        super(nome, sobrenome, endereco, rg, cpf);
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.idCliente = UUID.randomUUID();
        this.numeroConta = geradorNumeroConta();
        this.chequeEspecial = atribuidorChequeEspecial();
    }
    
    public static Cliente criarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.next();

        System.out.println("Digite o sobrenome do cliente: ");
        String sobrenome = scanner.next();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.next();

        System.out.println("Digite o rg do cliente: ");
        String rg = scanner.next();

        System.out.println("");
        Endereco endereco = Endereco.criarEndereco();

        System.out.println("""
                Escolha o tipo da conta:
                  Digite 1 para Conta Corrente
                  Digite 2 para Conta Poupança
                  Digite 3 para Conta Investimento
                \s""");
        
        int escolhaTipoConta = scanner.nextInt();
        TipoConta tipoConta = escolhaTipoConta(escolhaTipoConta);


        System.out.println("Digite o valor do depósito inicial: ");
        double saldo = scanner.nextDouble();

        Cliente cliente = new Cliente(nome, sobrenome, endereco, cpf, rg, tipoConta, saldo);

        return cliente;
    }


    private static TipoConta escolhaTipoConta (int escolhaTipoConta) {
        TipoConta tipoConta;
        if (escolhaTipoConta == 1) return tipoConta = TipoConta.corrente;
        else if (escolhaTipoConta == 2) return tipoConta = TipoConta.poupanca;
        else return tipoConta = TipoConta.investimento;
    }

    public static String exibirCliente(Cliente cliente){
        return "*********************************************" +
                "\n ------- DADOS DO CLIENTE ----------" +
                "\n Nome: " + cliente.nome + " " + cliente.sobrenome +
                "\n RG: " + cliente.rg +
                "\n " + Endereco.exibirEndereco(cliente.endereco) +
                "\n ------- DADOS DA CONTA DO CLIENTE ----------" +
                "\n\tConta: " + cliente.tipoConta +
                "\n\tSaldo: " + cliente.saldo +
                "\n\tDisponivel no Cheque Especial: " + cliente.chequeEspecial +
                "\n\tNúmero da conta: " + cliente.numeroConta +
                "\n\tID do Cliente: " + cliente.idCliente +
                "*********************************************";
    }
}
