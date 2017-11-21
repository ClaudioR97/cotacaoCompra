package edu.asselvi.funcionario;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;
import edu.asselvi.dao.IDefaultDao;

public class FuncionarioDao implements IDefaultDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE FUNCIONARIO (" + 
						"	cd_funcionario INTEGER NOT NULL PRIMARY KEY auto_increment," + 
						"	cd_pessoa	int(10) NOT NULL," + 
						"	ie_cargo	int(10) NOT NULL," +
						"	nr_ramal	long" + 
						");");

			st.execute( "	ALTER TABLE FUNCIONARIO " + 
						"	ADD CONSTRAINT cd_pessoa " + 
						"	FOREIGN KEY (cd_pessoa) " + 
						"	REFERENCES pessoa (cd_pessoa);");
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
			st.execute("DROP TABLE FUNCIONARIO;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

}
