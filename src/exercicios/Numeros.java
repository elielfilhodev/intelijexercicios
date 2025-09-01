package exercicios;

import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números deseja digitar? ");
        int qtd = sc.nextInt();

        double[] numeros = new double[qtd]; // cria o array

        //Lê os números
        for (int i = 0; i < qtd; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = sc.nextDouble();
        }

        // Inizializa variáveis auxiliares
        double soma = 0;
        double maior = numeros[0];
        double menor = numeros[0];

        // Processa os valores
        for (int i = 0; i < qtd; i++) {
            soma += numeros[i];
            if (numeros[i] > maior) maior = numeros[i];
            if (numeros[i] < menor) menor = numeros[i];
        }

        double media = soma / qtd;

        // Exibe resultados
        System.out.println("\nSoma = " + soma);
        System.out.println("Média = " + media);
        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);

        sc.close();
    }
}
