package exercicios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CadastroClientes {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static final ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU CLIENTES =====");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente por email");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("6 - Limpar todos");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");

            int op = lerIntLinha();
            switch (op) {
                case 1 -> adicionarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> atualizarCliente();
                case 5 -> removerCliente();
                case 6 -> limparTodos();
                case 7 -> { System.out.println("Encerrando..."); return; }
                default -> System.out.println("Opção inválida. Use 1..7.");
            }
        }
    }

    // ========= Operações =========
    private static void adicionarCliente() {
        System.out.print("Nome: ");
        String nome = lerLinhaNaoVazia();

        System.out.print("Email: ");
        String email = lerLinhaNaoVazia().toLowerCase();

        if (getByEmail(email) != null) {
            System.out.println("Já existe um cliente com esse email.");
            return;
        }

        System.out.print("Idade: ");
        int idade = lerIntLinhaPositivo();

        clientes.add(new Cliente(nome, email, idade));
        System.out.println("Cliente adicionado!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n-- Lista de Clientes --");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " -> " + clientes.get(i));
        }
    }

    private static void buscarCliente() {
        System.out.print("Email para busca: ");
        String email = lerLinhaNaoVazia().toLowerCase();
        Cliente c = getByEmail(email);
        System.out.println(c == null ? "Não encontrado." : c.toString());
    }

    private static void atualizarCliente() {
        System.out.print("Email do cliente a atualizar: ");
        String email = lerLinhaNaoVazia().toLowerCase();
        Cliente c = getByEmail(email);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Novo nome (" + c.getNome() + "): ");
        String novoNome = sc.nextLine().trim();
        if (!novoNome.isEmpty()) c.setNome(novoNome);

        System.out.print("Novo email (" + c.getEmail() + "): ");
        String novoEmail = sc.nextLine().trim().toLowerCase();
        if (!novoEmail.isEmpty() && !novoEmail.equals(c.getEmail())) {
            if (getByEmail(novoEmail) != null) {
                System.out.println("Já existe outro cliente com esse email.");
                return;
            }
            c.setEmail(novoEmail);
        }

        System.out.print("Nova idade (" + c.getIdade() + "): ");
        String idadeStr = sc.nextLine().trim();
        if (!idadeStr.isEmpty()) {
            try {
                int novaIdade = Integer.parseInt(idadeStr);
                if (novaIdade < 0) throw new NumberFormatException();
                c.setIdade(novaIdade);
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Mantida a anterior.");
            }
        }

        System.out.println("Atualizado com sucesso!");
    }

    private static void removerCliente() {
        System.out.print("Remover por: 1) email  2) índice : ");
        int modo = lerIntLinha();

        if (modo == 1) {
            System.out.print("Email: ");
            String email = lerLinhaNaoVazia().toLowerCase();
            Cliente c = getByEmail(email);
            if (c == null) {
                System.out.println("Cliente não encontrado.");
            } else {
                clientes.remove(c);
                System.out.println("Removido: " + c);
            }
        } else if (modo == 2) {
            if (clientes.isEmpty()) { System.out.println("Lista vazia."); return; }
            System.out.print("Índice: ");
            int idx = lerIntLinha();
            if (idx < 0 || idx >= clientes.size()) {
                System.out.println("Fora do intervalo.");
            } else {
                System.out.println("Removido: " + clientes.remove(idx));
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void limparTodos() {
        if (clientes.isEmpty()) { System.out.println("Lista já está vazia."); return; }
        System.out.print("Confirmar limpar TODOS (s/n): ");
        String conf = sc.nextLine().trim().toLowerCase();
        if (conf.equals("s")) {
            clientes.clear();
            System.out.println("Todos os clientes foram removidos.");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    // ========= Utilidades =========
    private static Cliente getByEmail(String email) {
        String alvo = email.toLowerCase().trim();
        for (Cliente c : clientes) {
            if (c.getEmail().equals(alvo)) return c;
        }
        return null;
    }

    private static String lerLinhaNaoVazia() {
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Vazio não é permitido. Digite novamente: ");
        }
    }

    private static int lerIntLinha() {
        while (true) {
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.print("Número inválido. Digite novamente: "); }
        }
    }

    private static int lerIntLinhaPositivo() {
        while (true) {
            int n = lerIntLinha();
            if (n >= 0) return n;
            System.out.print("Número deve ser >= 0. Tente de novo: ");
        }
    }
}
