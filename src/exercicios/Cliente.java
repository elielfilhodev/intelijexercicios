package exercicios;

public class Cliente {
    private String nome;
    private String email; // usaremos como "chave" única
    private int idade;

    public Cliente(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email.toLowerCase().trim();
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getIdade() { return idade; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email.toLowerCase().trim(); }
    public void setIdade(int idade) { this.idade = idade; }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
