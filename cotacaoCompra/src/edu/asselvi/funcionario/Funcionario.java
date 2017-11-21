package edu.asselvi.funcionario;

import java.util.Date;

import edu.asselvi.pessoa.Pessoa;

public class Funcionario extends Pessoa {
	private int cdFuncionario;
	private int ieCargo;
	private long nrRamal;

	public Funcionario() {
		super();
	}

	public Funcionario(int cdPessoa, String nmPessoa, long cdCpf, boolean ieFuncionario, String ieSexo,
			Date dtNascimento, int cdFuncionario, int ieCargo, long nrRamal) {
		super(cdPessoa, nmPessoa, cdCpf, ieFuncionario, ieSexo, dtNascimento);
		this.cdFuncionario = cdFuncionario;
		this.ieCargo = ieCargo;
		this.nrRamal = nrRamal;
	}

	public int getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(int cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public int getIeCargo() {
		return ieCargo;
	}

	public void setIeCargo(int ieCargo) {
		this.ieCargo = ieCargo;
	}

	public long getNrRamal() {
		return nrRamal;
	}

	public void setNrRamal(long nrRamal) {
		this.nrRamal = nrRamal;
	}

	@Override
	public String toString() {
		return "Funcionario " + getCdFuncionario() + " " +  getNmPessoa() 
			+ "\nCargo =" + getIeCargo()
			+ "\n Ramal =" + getNrRamal() + "]";
	}
	
	

}
