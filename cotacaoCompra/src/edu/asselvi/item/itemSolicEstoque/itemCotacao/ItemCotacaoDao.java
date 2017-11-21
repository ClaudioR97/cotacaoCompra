package edu.asselvi.item.itemSolicEstoque.itemCotacao;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;
import edu.asselvi.dao.IDefaultDao;

public class ItemCotacaoDao implements IDefaultDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE ITEM_COTACAO (" + 
						"	cd_item_cotacao INTEGER NOT NULL PRIMARY KEY auto_increment," + 
						"	cd_item_estoque INTEGER NOT NULL," + 
						"	cd_fornecedor INTEGER," + 
						"	qt_item_cotacao	INTEGER" + 
						");");
			
			st.execute( "	ALTER TABLE ITEM_SOLIC_ESTOQUE " + 
						"	ADD CONSTRAINT cd_item_estoque " + 
						"	FOREIGN KEY (cd_item_estoque) " + 
						"	REFERENCES item_solic_estoque (cd_item_estoque);");
			
			st.execute( "	ALTER TABLE ITEM_COTACAO " + 
						"	ADD CONSTRAINT cd_fornecedor " + 
						"	FOREIGN KEY (cd_fornecedor) " + 
						"	REFERENCES fornecedor (cd_fornecedor);");
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
