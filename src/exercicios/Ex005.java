package exercicios;

import java.util.Scanner;

public class Ex005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mostra o menu
        System.out.println("====MENU====");
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("Escolha uma opção: ");
        int opcao = sc.nextInt();

        // Pede os números
        System.out.print("Digite o primeiro número: ");
        double n1 = sc.nextDouble();

        System.out.print("Digite outro número: ");
        double n2 = sc.nextDouble();

        // Estrutura switch para tratar as opções
        switch (opcao) {
            case 1:
                // Somar
                System.out.println("Resultado da soma: " + (n1 + n2));
                break;

            case 2:
                // Subtrair
                System.out.println("Resultado da subtração: " + (n1 - n2));
                break;

            case 3:
                // Multiplicar
                System.out.println("Resultado da multiplicação: " + (n1 * n2));
                break;

            case 4:
                // Divisão
                if (n2 != 0) {
                    System.out.println("Resultado da divisão: " + n1 / n2);
                } else {
                    System.out.println("Erro: não é possível dividir por zero!");
                }
                break;

            default:
                System.out.println("Opção inválida!");
        }

        sc.close();
    }
}
