package aplicacao;
public class Cliente {
// cria a classe cliente e encapsula
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Cliente(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    
    public static void cadastrarCliente(String nome, String cpf, String dataNascimento) {
        Cliente cliente = new Cliente(nome, cpf, dataNascimento);

        System.out.println("Cliente cadastrado: " + cliente);
    }

    // Outros métodos e getters/setters da classe Cliente
    // ...
}
