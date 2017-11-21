package edu.asselvi.pessoa;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class PessoaTable extends JFrame {
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public static void main(String[] args) throws BDException {
		//new Conexao().informarConecBanco();
		Pessoa pessoa = new Pessoa();
		PessoaDao pessoaDao = new PessoaDao();
		
		
		pessoa.setCdPessoa(3);
		pessoa.setNmPessoa("Claudio");
		pessoa.setCdCpf(00000000000);
		pessoa.setIeFuncionario(true);
		pessoa.setIeSexo("M");
		pessoa.setDtNascimento(new Date());
		try {
			pessoaDao.insere(pessoa);
		} catch (BDException e) {
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		}
		PessoaTable pessoaTable = new PessoaTable();
		pessoaTable.criaJTable();
		pessoaTable.criaJanela();
		pessoaTable.setVisible(true);
	}
	
	private void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Funcionário");
		modelo.addColumn("Sexo");
		modelo.addColumn("Data de Nascimento");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(80);
		try {
			pesquisar(modelo);
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pesquisar(DefaultTableModel modelo) throws BDException {
		modelo.setNumRows(0);
		PessoaDao dao = new PessoaDao();

		try {
			for (Pessoa c : dao.consultaTodos()) {
				modelo.addRow(new Object[]{c.getCdPessoa(), 
						c.getNmPessoa(), 
						c.getCdCpf(), 
						c.isFuncionarioAsString(), 
						c.getIeSexo(),
						c.getDtNascimento()});
			}
		} catch (BDException e) {
			throw new BDException(EErrosBD.GERAR_TABELA, e.getMessage());
		}
	}
	
	public void criaJanela() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 320);
		setVisible(true);
		//btInserir.addActionListener(new BtInserirListener());
		//btEditar.addActionListener(new BtEditarListener());
		//btExcluir.addActionListener(new BtExcluirListener());
	}


}
