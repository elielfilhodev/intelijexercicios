package exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Listar nomes");
            System.out.println("3 - Buscar nome");
            System.out.println("4 - Remover nome");
            System.out.println("5 - Atualizar nome");
            System.out.println("6 - Limpar lista");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            // valida opção
            if (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número de 1 a 7.");
                sc.nextLine(); // limpa lixo
                continue;
            }
            int opcao = sc.nextInt();
            sc.nextLine(); // consome \n

            switch (opcao) {
                case 1:
                    // TODO: Ler um nome e adicionar em `nomes`
                    // Dica: nomes.add(nome);
                    System.out.print("Digite o nome para adicionar: ");
                    String nomeAdd = sc.nextLine().trim();
                    // (Opcional) evitar duplicados:
                    // if (!nomes.contains(nomeAdd)) { ... }
                    if (nomeAdd.isEmpty()) {
                        System.out.println("Nome vazio não é permitido.");
                    } else if (nomes.contains(nomeAdd)) {
                        System.out.println("Nome já existe na lista.");
                    } else {
                        nomes.add(nomeAdd);
                        System.out.println("Nome adicionado!");
                    }
                    break;

                case 2:
                    // TODO: Listar todos os nomes com índice
                    if (nomes.isEmpty()) {
                        System.out.println("Lista vazia.");
                    } else {
                        System.out.println("Nomes cadastrados:");
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println(i + " -> " + nomes.get(i));
                        }
                    }
                    break;

                case 3:
                    // TODO: Buscar nome (exibir se existe e o índice)
                    System.out.print("Digite o nome para buscar: ");
                    String busca = sc.nextLine().trim();
                    int idx = nomes.indexOf(busca);
                    if (idx >= 0) {
                        System.out.println("Encontrado: índice " + idx);
                    } else {
                        System.out.println("Nome não encontrado.");
                    }
                    break;

                case 4:
                    // TODO: Remover por índice OU por texto
                    System.out.println("Remover por: 1) índice  2) texto");
                    String modo = sc.nextLine().trim();
                    if (modo.equals("1")) {
                        if (nomes.isEmpty()) {
                            System.out.println("Lista vazia.");
                            break;
                        }
                        System.out.print("Digite o índice: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Índice inválido.");
                            sc.nextLine();
                            break;
                        }
                        int i = sc.nextInt();
                        sc.nextLine();
                        if (i < 0 || i >= nomes.size()) {
                            System.out.println("Fora do intervalo.");
                        } else {
                            String removido = nomes.remove(i);
                            System.out.println("Removido: " + removido);
                        }
                    } else if (modo.equals("2")) {
                        System.out.print("Digite o nome para remover: ");
                        String alvo = sc.nextLine().trim();
                        boolean ok = nomes.remove(alvo);
                        System.out.println(ok ? "Removido com sucesso." : "Nome não encontrado.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    // TODO: Atualizar nome na posição X
                    if (nomes.isEmpty()) {
                        System.out.println("Lista vazia.");
                        break;
                    }
                    System.out.print("Digite o índice a atualizar: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Índice inválido.");
                        sc.nextLine();
                        break;
                    }
                    int pos = sc.nextInt();
                    sc.nextLine();
                    if (pos < 0 || pos >= nomes.size()) {
                        System.out.println("Fora do intervalo.");
                        break;
                    }
                    System.out.print("Novo nome: ");
                    String novo = sc.nextLine().trim();
                    if (novo.isEmpty()) {
                        System.out.println("Nome vazio não é permitido.");
                        break;
                    }
                    nomes.set(pos, novo);
                    System.out.println("Atualizado com sucesso!");
                    break;

                case 6:
                    // TODO: Limpar lista (confirmar antes)
                    if (nomes.isEmpty()) {
                        System.out.println("Lista já está vazia.");
                        break;
                    }
                    System.out.print("Tem certeza que deseja limpar tudo? (s/n): ");
                    String conf = sc.nextLine().trim().toLowerCase();
                    if (conf.equals("s")) {
                        nomes.clear();
                        System.out.println("Lista limpa.");
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando... Até logo!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 7.");
            }
        }
    }
}
