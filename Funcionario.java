package aplicacao;
public class Funcionario {
//cria a classe funcionario e encapsula
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Funcionario(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Método  para cadastrar o funcionário
    public static void cadastrarFuncionario(String nome, String cpf, String dataNascimento) {
        Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento);

        System.out.println("Funcionário cadastrado: " + funcionario);
    }

}
