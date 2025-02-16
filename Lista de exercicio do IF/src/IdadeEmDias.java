import java.util.Scanner;

public class IdadeEmDias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos anos você tem?: ");
        int anos = scanner.nextInt();

        System.out.print("Meses?: ");
        int meses = scanner.nextInt();

        System.out.print("Dias?: ");
        int dias = scanner.nextInt();

        // Validação dos valores
        if (anos < 0 || meses < 0 || meses > 12 || dias < 0 || dias > 30) {
            System.out.println("Erro: Certifique-se de digitar valores válidos.");
            scanner.close();
            return;
        }

        int idadeEmDias = (anos * 365) + (meses * 30) + dias;

        System.out.println("Sua idade completa é: " + anos + " anos, " + meses + " meses e " + dias + " dias.");
        System.out.println("Sua idade em dias é: " + idadeEmDias + " dias.");

        scanner.close();
    }
}