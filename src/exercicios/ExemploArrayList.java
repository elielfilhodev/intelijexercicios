package exercicios;

import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args) {
        // Criando um ArrayList de Strings
        ArrayList<String> nomes = new ArrayList<>();

        // Adicionando elementos
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("João");

        // Acessando elementos pelo índice
        System.out.println("Primeiro nome: " + nomes.get(0));

        // Tamanho da lista
        System.out.println("Total de nomes: " + nomes.size());

        // Percorrendo com for-each
        System.out.println("\nLista de nomes:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        // Removendo um elemento
        nomes.remove("Carlos");

        System.out.println("\nApós remocão:");

        System.out.println(nomes);
    }
}
