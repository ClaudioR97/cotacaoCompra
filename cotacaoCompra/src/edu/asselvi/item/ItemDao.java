package edu.asselvi.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.asselvi.conexao.Conexao;
import edu.asselvi.conexao.bancoDeDados.BDException;
import edu.asselvi.conexao.bancoDeDados.EErrosBD;
import edu.asselvi.dao.IDefaultDao;

public class ItemDao implements IDefaultDao {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute( "CREATE TABLE ITEM (" + 
						"	cd_item INTEGER NOT NULL PRIMARY KEY auto_increment," + 
						"	ds_item	VARCHAR(45) NOT NULL" + 
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
	
	public boolean insereItem(Item item) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("INSERT INTO item" +
					"(cd_item, ds_item) VALUES (?, ?)");
			pst.setInt(1, item.getCdItem());
			pst.setString(2, item.getDsItem());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	
	 public Item consulta(int codigo) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM Pessoa " +
					"WHERE Codigo = ?;");
			pst.setInt(1, codigo);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Item(codigo,
								  rs.getString("ds_item")
								 ) : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

}
