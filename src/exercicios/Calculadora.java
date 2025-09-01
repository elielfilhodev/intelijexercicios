package exercicios;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            // trata entrada inválida para a opção
            if (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Use números de 1 a 5.");
                sc.nextLine(); // limpa o lixo
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
                continue;
            }
            int opcao = sc.nextInt();
            sc.nextLine(); // consome o \n que sobrou do nextInt

            if (opcao == 5) {
                System.out.println("Encerrando Calculadora... Até logo!");
                break; // agora sai do loop
            }

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida! Use números de 1 a 5.");
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
                continue;
            }

            // Só pede números quando a opção é 1..4
            System.out.print("Digite o primeiro número: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Valor inválido. Digite um número: ");
                sc.nextLine();
            }
            double n1 = sc.nextDouble();

            System.out.print("Digite o segundo número: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Valor inválido. Digite um número: ");
                sc.nextLine();
            }
            double n2 = sc.nextDouble();
            sc.nextLine(); // consome \n

            switch (opcao) {
                case 1:
                    System.out.println("Resultado: " + n1 + " + " + n2 + " = " + (n1 + n2));
                    break;
                case 2:
                    System.out.println("Resultado: " + n1 + " - " + n2 + " = " + (n1 - n2));
                    break;
                case 3:
                    System.out.println("Resultado: " + n1 + " * " + n2 + " = " + (n1 * n2));
                    break;
                case 4:
                    if (n2 != 0) {
                        System.out.println("Resultado: " + n1 + " / " + n2 + " = " + (n1 / n2));
                    } else {
                        System.out.println("Erro: não é possível dividir por zero!");
                    }
                    break;
            }

            System.out.println("\nPressione Enter para continuar...");
            sc.nextLine(); // pausa
        }

        sc.close();
    }
}
