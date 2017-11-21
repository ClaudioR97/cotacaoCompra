package edu.asselvi.item.itemSolicEstoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;
import edu.asselvi.dao.IDefaultDao;
import edu.asselvi.item.ItemDao;

public class ItemSolicEstoqueDao implements IDefaultDao {
	
	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE ITEM_SOLIC_ESTOQUE (" + 
						"	cd_item_estoque INTEGER NOT NULL PRIMARY KEY auto_increment," + 
						"	cd_item INTEGER NOT NULL," + 
						"	cd_fornecedor INTEGER NOT NULL," + 
						"	qt_item	LONG NOT NULL" + 
						");");
			
			st.execute( "	ALTER TABLE ITEM_SOLIC_ESTOQUE " + 
						"	ADD CONSTRAINT cd_item " + 
						"	FOREIGN KEY (cd_item) " + 
						"	REFERENCES item (cd_item);");
			
			st.execute( "	ALTER TABLE ITEM_SOLIC_ESTOQUE " + 
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
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE ITEM_SOLIC_ESTOQUE;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public boolean insereItemEstoqueSolic(ItemSolicEstoque itemEstoq) throws BDException {
		Connection conexao = Conexao.getConexao();
		ItemDao itemDao = new ItemDao();
		try {
			if (itemDao.consulta(itemEstoq.getCdItem()) != null
					&& itemDao.consulta(itemEstoq.getCdItem()).getCdItem() != 0) {
				PreparedStatement pst = conexao.prepareStatement("INSERT INTO ITEM_SOLIC_ESTOQUE" +
						"(cd_item, cd_fornecedor, qt_item) VALUES (?, ?, ?)");
				pst.setInt(1, itemEstoq.getCdItem());
				pst.setInt(2, itemEstoq.getCdFornecedor());
				pst.setLong(3, itemEstoq.getQtItem());
				return pst.executeUpdate() > 0;
			}
			throw new BDException(EErrosBD.ITEM_NAO_CADASTRADO, "Item ainda não cadastrado");
		} catch (Exception e) {
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}

	}
}
