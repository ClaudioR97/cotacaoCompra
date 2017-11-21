package edu.asselvi.funcionario;

public enum EFuncionarioCargo {
	GERENTE(1),
	COMPRADOR(2);
	
	private final int cargo;

	public int getMensagem() {
		return cargo;
	}

	private EFuncionarioCargo(int cargo) {
		this.cargo = cargo;
	}
}
