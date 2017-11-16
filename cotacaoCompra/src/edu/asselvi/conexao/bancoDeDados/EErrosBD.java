package edu.asselvi.conexao.bancoDeDados;

public enum EErrosBD {
	ABRE_CONEXAO ("Erro ao abrir conexão com Banco de Dados"), 
	FECHA_CONEXAO ("Erro ao fechar conexão com Banco de Dados"), 
	CRIA_TABELA ("Erro ao criar tabela no Banco de Dados"), 
	DESTROI_TABELA ("Erro ao destruir tabela no Banco de Dados"), 
	INSERE_DADO ("Erro ao inserir dados na tabela no Banco de Dados");
	
	private final String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	private EErrosBD(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
