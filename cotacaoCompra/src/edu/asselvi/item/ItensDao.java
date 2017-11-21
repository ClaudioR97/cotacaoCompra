package edu.asselvi.item;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class ItensDao implements IItemDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE ITEM (" + 
						"	cd_item INTEGER NOT NULL PRIMARY KEY," + 
						"	ds_item	VARCHAR(45) NOT NULL," + 
						"	qt_item	LONG" + 
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
			st.execute("DROP TABLE ITEM;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

}
