package edu.asselvi.pessoa;

import java.util.Date;

public class Pessoa {
	private int cdPessoa;
	private String nmPessoa;
	private long cdCpf;
	private boolean ieFuncionario;
	private String ieSexo;
	private Date dtNascimento;

	public Pessoa(int cdPessoa, String nmPessoa, long cdCpf, boolean ieFuncionario, String ieSexo, Date dtNascimento) {
		super();
		this.cdPessoa = cdPessoa;
		this.nmPessoa = nmPessoa;
		this.cdCpf = cdCpf;
		this.ieFuncionario = ieFuncionario;
		this.ieSexo = ieSexo;
		this.dtNascimento = dtNascimento;
	}

	public Pessoa() {
		setCdPessoa(0);
		setNmPessoa("");
		setCdCpf(0L);
		setIeFuncionario(false);
		setIeSexo("");
		setDtNascimento(new Date());
	}

	public int getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public long getCdCpf() {
		return cdCpf;
	}

	public void setCdCpf(long cdCpf) {
		this.cdCpf = cdCpf;
	}

	public boolean isIeFuncionario() {
		return ieFuncionario;
	}
	
	public String isFuncionarioAsString() {
		return isIeFuncionario() ? "S" : "N";
	}

	public void setIeFuncionario(boolean ieFuncionario) {
		this.ieFuncionario = ieFuncionario;
	}

	public String getIeSexo() {
		return ieSexo;
	}

	public void setIeSexo(String ieSexo) {
		this.ieSexo = ieSexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [getCdPessoa()=" + getCdPessoa() + ", getNmPessoa()=" + getNmPessoa() + ", getCdCpf()="
				+ getCdCpf() + ", isIeFuncionario()=" + isIeFuncionario() + ", getIeSexo()=" + getIeSexo()
				+ ", getDtNascimento()=" + getDtNascimento() + "]";
	}

}
