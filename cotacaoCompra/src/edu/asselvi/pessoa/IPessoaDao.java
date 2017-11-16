package edu.asselvi.pessoa;

import edu.asselvi.conexao.bancoDeDados.BDException;

public interface IPessoaDao {
	public abstract boolean criaTabela() throws BDException;
	public abstract boolean destroiTabela() throws BDException;
}
