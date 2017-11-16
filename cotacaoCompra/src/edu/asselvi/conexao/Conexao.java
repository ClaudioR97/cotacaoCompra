package edu.asselvi.conexao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class Conexao {
	private static Connection conn = null;
	private static String usuario = "";
	private static String baseDeDados = "";
	private static String senha = "";

	public static Connection getConexao() throws BDException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConexaoBean conexaoBean = new ConexaoBean(baseDeDados, usuario, senha);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + conexaoBean.getDataBase() + "?useSSL=true",
																			conexaoBean.getUsuario(),
																			conexaoBean.getSenha());
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!!!", null, JOptionPane.INFORMATION_MESSAGE, null);
			conn.close();
			System.out.println(conexaoBean.toString());
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, EErrosBD.ABRE_CONEXAO.getMensagem() + e.getMessage(), null, JOptionPane.ERROR_MESSAGE, null);
			throw new BDException(EErrosBD.ABRE_CONEXAO, e.getMessage());
		}
	}

	public static void closeConexao() throws BDException {
		try {
			if (conn != null)
				conn.close();

			conn = null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.FECHA_CONEXAO, e.getMessage());
		}

	}
	
	public void informarConecBanco() {
		JFrame janela = new JFrame("Conexão");
		JPanel painel = new JPanel();
		JButton botaoOk = new JButton("OK");
		JTextField bd = new JTextField(15);
		JTextField user = new JTextField(15);
		JPasswordField password = new JPasswordField(15);
		
		painel.add(new JLabel("Base de Dados"));
		painel.add(bd);
		
		painel.add(new JLabel("Usuário"));
		painel.add(user);
		
		painel.add(new JLabel("Senha"));
		painel.add(password);
		
		painel.add(botaoOk);
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setSize(230, 230);
		janela.setVisible(true);
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				baseDeDados = bd.getText();
				usuario = user.getText();
				senha = password.getText();
				try {
					getConexao();
					System.exit(0);
				} catch (BDException e1) {
					System.exit(0);
				}
			}
		});
	}
}
