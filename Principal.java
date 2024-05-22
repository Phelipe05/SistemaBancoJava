import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Cliente cliente = null;

        do {
            System.out.println("""
                    ------ MENU -----
                    1. Criar cliente
                    2. Exibir cliente
                    
                    Escolha uma opção:
                    \s""");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cliente = Cliente.criarCliente();
                    break;
                case 2:
                    System.out.println(Cliente.exibirCliente(cliente));
                    break;
            }
        } while (opcao != 0);
    }
}
