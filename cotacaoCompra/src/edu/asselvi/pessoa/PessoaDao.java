package edu.asselvi.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;
import edu.asselvi.dao.IDefaultDao;

public class PessoaDao implements IDefaultDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE PESSOA (" + 
						"	cd_pessoa INTEGER NOT NULL PRIMARY KEY auto_increment," + 
						"	nm_pessoa	VARCHAR(45) NOT NULL," + 
						"	cd_cpf	LONG," + 
						"	ie_funcionario	CHAR(1) NOT NULL," +
						"	ie_sexo	CHAR(1) NOT NULL," +
						"	dt_nascimento	DATE NOT NULL" +
						");");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE PESSOA;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public boolean insere(Pessoa pessoa) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO pessoa "
															+ "(	cd_pessoa, "
															+ "		nm_pessoa, "
															+ "		cd_cpf, "
															+ "		ie_funcionario, "
															+ "		ie_sexo, "
															+ "		dt_nascimento)" 
															+ "VALUES (?, ?, ?, ?, ?, ?)");
			pst.setInt(1, pessoa.getCdPessoa());
			pst.setString(2, pessoa.getNmPessoa());
			pst.setLong(3, pessoa.getCdCpf());
			pst.setString(4, pessoa.isIeFuncionario() ? "S" : "N");
			pst.setString(5, pessoa.getIeSexo());
			pst.setDate(6, new java.sql.Date(pessoa.getDtNascimento().getTime()));
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}

	}
	
	public List<Pessoa> consultaTodos() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Pessoa;");
			while(rs.next()) {
				pessoas.add(new Pessoa(rs.getInt("cd_pessoa"),
						rs.getString("nm_pessoa"),
						rs.getLong("cd_cpf"),
						"S".equals(rs.getString("ie_funcionario").charAt(0)),
						rs.getString("ie_sexo"),
						rs.getDate("dt_nascimento")
						));
			}
			return pessoas; 
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

}
