package edu.asselvi.item;

import edu.asselvi.conexao.bancoDeDados.BDException;

public interface IItemDao {
	public abstract boolean criaTabela() throws BDException;
	public abstract boolean destroiTabela() throws BDException;
}
