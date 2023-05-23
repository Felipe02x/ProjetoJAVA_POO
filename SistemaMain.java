package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaMain extends JFrame {

    private Cliente cliente;
    private Produto produto;
    private Funcionario funcionario;
    private Venda venda;

    private JTextField nomeClienteTextField;
    private JTextField cpfClienteTextField;
    private JTextField dataNascimentoClienteTextField;

    private JTextField nomeFuncionarioTextField;
    private JTextField cpfFuncionarioTextField;
    private JTextField dataNascimentoFuncionarioTextField;

    private JTextField nomeProdutoTextField;
    private JTextField codigoProdutoTextField;
    private JTextField precoProdutoTextField;

    private JTextField idVendaTextField;
    private JTextField dataVendaTextField;
    private JTextField valorUnitarioVendaTextField;

    public SistemaMain() {
        // Configurações da janela principal
        setTitle("Sistema de Cadastro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para as telas
        JPanel telaPanel = new JPanel(new CardLayout());

        // Tela de cadastro de clientes
        JPanel clientePanel = criarTelaCliente();
        telaPanel.add(clientePanel, "cliente");

        // Tela de cadastro de funcionários
        JPanel funcionarioPanel = criarTelaFuncionario();
        telaPanel.add(funcionarioPanel, "funcionario");

        // Tela de cadastro de produtos
        JPanel produtoPanel = criarTelaProduto();
        telaPanel.add(produtoPanel, "produto");

        // Tela de cadastro de vendas
        JPanel vendaPanel = criarTelaVenda();
        telaPanel.add(vendaPanel, "venda");

        // Adiciona o painel de telas à janela principal
        add(telaPanel, BorderLayout.CENTER);

        // Botão para avançar para a próxima tela
        JButton proximoButton = new JButton("Próximo");
        add(proximoButton, BorderLayout.SOUTH);

        // Evento do botão "Próximo"
        proximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) telaPanel.getLayout();
                if (cardLayout != null) {
                    cardLayout.next(telaPanel);
                }
            }
        });
    }

    private JPanel criarTelaCliente() {
        JPanel clientePanel = new JPanel(new GridLayout(4, 2));

        JLabel nomeClienteLabel = new JLabel("Nome:");
        nomeClienteTextField = new JTextField();
        clientePanel.add(nomeClienteLabel);
        clientePanel.add(nomeClienteTextField);

        JLabel cpfClienteLabel = new JLabel("CPF:");
        cpfClienteTextField = new JTextField();
        clientePanel.add(cpfClienteLabel);
        clientePanel.add(cpfClienteTextField);

        JLabel dataNascimentoClienteLabel = new JLabel("Data de Nascimento:");
        dataNascimentoClienteTextField = new JTextField();
        clientePanel.add(dataNascimentoClienteLabel);
        clientePanel.add(dataNascimentoClienteTextField);

        return clientePanel;
    }

    private JPanel criarTelaFuncionario() {
        JPanel funcionarioPanel = new JPanel(new GridLayout(4, 2));

        JLabel nomeFuncionarioLabel = new JLabel("Nome:");
        nomeFuncionarioTextField = new JTextField();
        funcionarioPanel.add(nomeFuncionarioLabel);
        funcionarioPanel.add(nomeFuncionarioTextField);

        JLabel cpfFuncionarioLabel = new JLabel("CPF:");
        cpfFuncionarioTextField = new JTextField();
        funcionarioPanel.add(cpfFuncionarioLabel);
        funcionarioPanel.add(cpfFuncionarioTextField);

        JLabel dataNascimentoFuncionarioLabel = new JLabel("Data de Nascimento:");
        dataNascimentoFuncionarioTextField = new JTextField();
        funcionarioPanel.add(dataNascimentoFuncionarioLabel);
        funcionarioPanel.add(dataNascimentoFuncionarioTextField);

        return funcionarioPanel;
    }

    private JPanel criarTelaProduto() {
        JPanel produtoPanel = new JPanel(new GridLayout(4, 2));

        JLabel nomeProdutoLabel = new JLabel("Nome:");
        nomeProdutoTextField = new JTextField();
        produtoPanel.add(nomeProdutoLabel);
        produtoPanel.add(nomeProdutoTextField);

        JLabel codigoProdutoLabel = new JLabel("Código:");
        codigoProdutoTextField = new JTextField();
        produtoPanel.add(codigoProdutoLabel);
        produtoPanel.add(codigoProdutoTextField);

        JLabel precoProdutoLabel = new JLabel("Preço:");
        precoProdutoTextField = new JTextField();
        produtoPanel.add(precoProdutoLabel);
        produtoPanel.add(precoProdutoTextField);

        return produtoPanel;
    }

    private JPanel criarTelaVenda() {
        JPanel vendaPanel = new JPanel(new GridLayout(4, 2));

        JLabel idVendaLabel = new JLabel("ID:");
        idVendaTextField = new JTextField();
        vendaPanel.add(idVendaLabel);
        vendaPanel.add(idVendaTextField);

        JLabel dataVendaLabel = new JLabel("Data:");
        dataVendaTextField = new JTextField();
        vendaPanel.add(dataVendaLabel);
        vendaPanel.add(dataVendaTextField);

        JLabel valorUnitarioVendaLabel = new JLabel("Valor Unitário:");
        valorUnitarioVendaTextField = new JTextField();
        vendaPanel.add(valorUnitarioVendaLabel);
        vendaPanel.add(valorUnitarioVendaTextField);

        return vendaPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaMain sistema = new SistemaMain();
                sistema.setVisible(true);
            }
        });
    }
}
