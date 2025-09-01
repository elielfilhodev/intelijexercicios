package exercicios;

import java.util.Scanner;

public class Ex003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a nota do aluno: ");
        double nota = sc.nextDouble();

        if (nota >= 6) {
            System.out.println("Aprovado!! com a nota " + nota);
        } else {
            System.out.println("Reprovado!! com a nota " + nota);
        }

        sc.close();
    }
}
