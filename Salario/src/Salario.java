import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o salario
        System.out.print("Digite seu salário: ");
        double salario = scanner.nextDouble();

        // Solicita a porcentagem de reajuste
        System.out.print("Digite a porcentagem do reajuste salárial: ");
        double reajuste = scanner.nextDouble();

        // Faz o reajuste baseado no salario e na porcentagem descritas acima
        double salarioreal = (reajuste / 100) * salario;

         // Somando o salário ao reajuste
        double salarioreajustado = salarioreal + salario;

        // Exibe o resultado do valor a ser reajustado
        System.out.println("O valor do reajuste é de: " + salarioreal);
        // Exibe o resultado do salário reajustado
        System.out.println("O valor do reajuste é de: " + salarioreajustado);

        scanner.close();
    }
}