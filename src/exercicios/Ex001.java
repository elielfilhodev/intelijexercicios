package exercicios;

import java.util.Scanner;

public class Ex001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        double n1 = sc.nextDouble();

        System.out.print("Digite outro número: ");
        double n2 = sc.nextDouble();

        double soma = n1 + n2;

        System.out.println(n1 + " + " + n2 + " = " + soma);

        sc.close();
    }
}
