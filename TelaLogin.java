package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;

    public TelaLogin() {
        // Configurações da janela
        setTitle("Tela de Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(153, 0, 255)); // Define o fundo roxo

        // Criação dos componentes
        JLabel lblUsuario = new JLabel("Usuário:");
        JLabel lblSenha = new JLabel("Senha:");
        txtUsuario = new JTextField(10);
        txtSenha = new JPasswordField(10);
        JButton btnLogin = new JButton("Login");
        

        // Configuração do layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Altera para BoxLayout na direção vertical
        add(lblUsuario);
        txtUsuario.setForeground(new Color(153, 0, 255)); // Configura a cor roxa do campo de usuário
        add(txtUsuario);
        add(lblSenha);
        txtSenha.setForeground(new Color(153, 0, 255)); // Configura a cor roxa do campo de senha
        add(txtSenha);
        add(btnLogin);

        // Evento de clique no botão de login
        //btnLogin.addActionListener(e -> btnLoginAc());

        

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (validarLogin(usuario, senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    TelaMenuInicial telaMenuInicial = new TelaMenuInicial();
                    telaMenuInicial.setVisible(true);
                } else {
                    int resposta = JOptionPane.showConfirmDialog(null, "Usuário não encontrado. Deseja realizar o cadastro?");
                    if (resposta == JOptionPane.YES_OPTION) {
                        realizarCadastro(usuario, senha);
                        Funcionario funcionario = new Funcionario(); 
                        funcionario.setVisible(true);
                    }
                }
            }
        });
    }
    

    // Método para validar o login consultando o banco de dados
    private boolean validarLogin(String usuario, String senha) {
        String url = "jdbc:mysql://localhost:3306/projetopoo";
        String username = "root";
        String password = "Felipe12@";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // Retorna true se houver uma linha correspondente no resultado da consulta
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Em caso de erro, retorna false
        }
    }

    // Método para realizar o cadastro de um novo usuário
    private void realizarCadastro(String usuario, String senha) {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
    
                new TelaLogin().setVisible(true);
            }
        });
    }
}



   








       
