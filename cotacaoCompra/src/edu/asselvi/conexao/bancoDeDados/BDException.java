package edu.asselvi.conexao.bancoDeDados;

import javax.swing.JOptionPane;

import edu.asselvi.conexao.bancoDeDados.EErrosBD;

public class BDException extends Exception {

	private static final long serialVersionUID = 1L;

	public BDException(EErrosBD erro, String erroMsg) {
		JOptionPane.showMessageDialog(null, EErrosBD.ABRE_CONEXAO.getMensagem() + " # " + erroMsg, null, JOptionPane.ERROR_MESSAGE, null);
	}
	
	

}
