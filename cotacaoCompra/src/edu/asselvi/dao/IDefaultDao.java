package edu.asselvi.dao;

import edu.asselvi.conexao.bancoDeDados.BDException;

public interface IDefaultDao {
	public abstract boolean criaTabela() throws BDException;
	public abstract boolean destroiTabela() throws BDException;
}
