package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;

    public TelaLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.GREEN);

        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel labelUsuario = new JLabel("Usuário:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelUsuario, constraints);

        textFieldUsuario = new JTextField(20);
        constraints.gridx = 1;
        panel.add(textFieldUsuario, constraints);

        JLabel labelSenha = new JLabel("Senha:");
        constraints.gridy = 1;
        panel.add(labelSenha, constraints);

        passwordFieldSenha = new JPasswordField(20);
        constraints.gridy = 2;
        panel.add(passwordFieldSenha, constraints);

        JButton buttonLogin = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String senha = new String(passwordFieldSenha.getPassword());

                if (validarLogin(usuario, senha)) {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login válido!");
                    // Direcione para o menu inicial aqui
                    dispose(); // Fechar a tela de login após o login bem-sucedido
                } else {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login inválido! Tente novamente.");
                    textFieldUsuario.setText("");
                    passwordFieldSenha.setText("");
                }
            }
        });
        panel.add(buttonLogin, constraints);

        pack();
        setLocationRelativeTo(null);
    }

    private boolean validarLogin(String usuario, String senha) {
        // Lógica para validar o login
        // Aqui você pode realizar as verificações necessárias, como consultar um banco de dados, etc.
        // Neste exemplo, estou verificando se o usuário é "admin" e a senha é "12345".
        return usuario.equals("admin") && senha.equals("12345");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        });
    }
}
