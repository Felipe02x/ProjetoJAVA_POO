package aplicacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuInicial extends JFrame {

    public TelaMenuInicial() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(128, 0, 128)); // Background roxo

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Deixar o painel transparente
        getContentPane().add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JButton buttonInicio = new JButton("Início");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(buttonInicio, constraints);

        JButton buttonFuncionarios = new JButton("Funcionários");
        constraints.gridy = 1;
        panel.add(buttonFuncionarios, constraints);

        JButton buttonClientes = new JButton("Clientes");
        constraints.gridy = 2;
        panel.add(buttonClientes, constraints);

        JButton buttonVendas = new JButton("Vendas");
        constraints.gridy = 3;
        panel.add(buttonVendas, constraints);

        JButton buttonEstoque = new JButton("Estoque");
        constraints.gridy = 4;
        panel.add(buttonEstoque, constraints);

        JButton buttonSair = new JButton("Sair");
        constraints.gridy = 5;
        panel.add(buttonSair, constraints);

        // ActionListener para os botões
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonSair) {
                    System.exit(0); // Fechar a aplicação ao clicar no botão "Sair"
                } else {
                    JOptionPane.showMessageDialog(TelaMenuInicial.this, "Opção selecionada: " + ((JButton) e.getSource()).getText());
                }
            }
        };

        buttonInicio.addActionListener(buttonListener);
        buttonFuncionarios.addActionListener(buttonListener);
        buttonClientes.addActionListener(buttonListener);
        buttonVendas.addActionListener(buttonListener);
        buttonEstoque.addActionListener(buttonListener);
        buttonSair.addActionListener(buttonListener);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaMenuInicial telaMenuInicial = new TelaMenuInicial();
                telaMenuInicial.setVisible(true);
            }
        });
    }
}
