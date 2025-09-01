package exercicios;

import java.util.Scanner;

public class Ex006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();

        if (idade >= 18) {
            System.out.println(nome + ", você é de maior!");
        } else {
            System.out.println(nome + ", você é de menor!");
        }

        sc.close();
    }
}
