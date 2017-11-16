package edu.asselvi.pessoa;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class PessoaDao implements IPessoaDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE PESSOA (" + 
						"	cd_pessoa INTEGER NOT NULL PRIMARY KEY," + 
						"	nm_pessoa	VARCHAR(45) NOT NULL," + 
						"	cd_cpf	LONG UNIQUE," + 
						"	ie_funcionario	CHAR(1) NOT NULL," +
						"	ie_sexo	CHAR(1) NOT NULL,," +
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
		// TODO Auto-generated method stub
		return false;
	}

}
