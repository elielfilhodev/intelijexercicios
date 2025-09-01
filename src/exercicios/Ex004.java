package exercicios;

import java.util.Scanner;

public class Ex004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num =sc.nextInt();

        if (num > 0) {
            System.out.println("O número " + num + " é positivo.");
        } else if ( num < 0) {
            System.out.println("O número " + num + " é negativo.");
        } else {
            System.out.println("O número é " + num);
        }

        sc.close();
    }
}
