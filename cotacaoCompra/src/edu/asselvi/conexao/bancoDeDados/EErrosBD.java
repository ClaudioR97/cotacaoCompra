package edu.asselvi.conexao.bancoDeDados;

public enum EErrosBD {
	ABRE_CONEXAO 	("Erro ao abrir conex�o com Banco de Dados"), 
	FECHA_CONEXAO 	("Erro ao fechar conex�o com Banco de Dados"), 
	CRIA_TABELA 	("Erro ao criar tabela no Banco de Dados"), 
	DESTROI_TABELA 	("Erro ao destruir tabela no Banco de Dados"), 
	INSERE_DADO 	("Erro ao inserir dados na tabela no Banco de Dados"), 
	CONSULTA_DADO 	("Erro ao realizar consulta no banco de dados"), 
	GERAR_TABELA	("Erro ao gerar tela/tabela"), 
	ITEM_NAO_CADASTRADO("Item n�o cadastrado");
	
	private final String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	private EErrosBD(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
