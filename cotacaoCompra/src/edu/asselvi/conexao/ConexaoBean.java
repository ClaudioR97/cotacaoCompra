package edu.asselvi.conexao;

public class ConexaoBean {
	private String dataBase;
	private String usuario;
	private String senha;

	public ConexaoBean(String baseDeDados, String usuario, String senha) {
		setDataBase(baseDeDados);
		setUsuario(usuario);
		setSenha(senha);
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	@Override
	public String toString() {
		return "Conectado à base "
				+ getDataBase() 
				+ " com o usuário "
				+ getUsuario();
	}

}
