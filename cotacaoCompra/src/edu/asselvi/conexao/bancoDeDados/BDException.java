package edu.asselvi.conexao.bancoDeDados;

import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class BDException extends Exception {

	private static final long serialVersionUID = 1L;

	public BDException(EErrosBD erro, String erroMsg) {
		System.out.println(erro.getMensagem() + "#" + erroMsg);
	}
	
	

}
