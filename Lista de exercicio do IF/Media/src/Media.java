import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite tres numeros, primeiro: ");
        double primeiro = scanner.nextInt();

        System.out.print("Digite o segundo: ");
        double segundo = scanner.nextInt();

        System.out.print("Digite o terceiro: ");
        double terceiro = scanner.nextInt();

        System.out.print("Digite outros tres numeros, primeiro: ");
        double quarto = scanner.nextInt();

        System.out.print("Digite o segundo: ");
        double quinto = scanner.nextInt();

        System.out.print("Digite o terceiro: ");
        int sexto = scanner.nextInt();



        double resultadoSoma = primeiro + segundo + terceiro;
        double resultadoDivisao = resultadoSoma / 3;
        
        double resultadosegundaSoma = quarto + quinto + sexto;
        double resultadosegundaDivisao = resultadosegundaSoma / 3;

        double somamedias = resultadoDivisao + resultadosegundaDivisao;


        double resultadosomafinal = resultadoDivisao + resultadosegundaDivisao;
        double resultadodivisaofinal = resultadosomafinal / 2;


        System.out.println("Aritimética dos 3 primeiros numeros: " + resultadoDivisao);
        System.out.println("Aritimética dos 3 segundos numeros: " + resultadosegundaDivisao);
        System.out.println("Soma das duas aritiméticas: " + somamedias);
        System.out.println("Aritimética das aritiméticas: " + resultadodivisaofinal);
        

        scanner.close();
    }
}