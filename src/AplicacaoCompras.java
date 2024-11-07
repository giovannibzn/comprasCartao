import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AplicacaoCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limiteCartao = scanner.nextDouble();
        double saldoCartao = limiteCartao;

        List<Compra> compras = new ArrayList<>();

        while (true) {
            System.out.println("Digite a descrição da compra: ");
            scanner.nextLine();
            String descricao = scanner.nextLine();

            System.out.println("Digite o valor da compra: ");
            double valorCompra = scanner.nextDouble();

            if (valorCompra <= saldoCartao) {
                compras.add(new Compra(descricao, valorCompra));
                saldoCartao -= valorCompra;
                System.out.println("Compra realizada, seu limite agora é de R$  " + saldoCartao);
            } else {
                System.out.println("Saldo insulficiente! Seu limite é de R$ " + saldoCartao);
            }

            System.out.println("Digite 0 para sair ou 1 para continuar: ");
            int opcao = scanner.nextInt();
            if (opcao == 0){
                break;
            }
        }

        compras.sort(Comparator.comparingDouble(Compra::getValor).reversed());

        System.out.println("*********************************");
        System.out.println("\nCOMPRAS REALIZADAS:");
        for (Compra compra: compras){
            System.out.println(compra);
        }
        System.out.println("\nSaldo do cartão: R$ " + saldoCartao);
        System.out.println("\n*********************************");

        scanner.close();
    }
}