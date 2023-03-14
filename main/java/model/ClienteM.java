package model;

import java.time.LocalDate;

public class ClienteM {
	private String cpf;
	private String nome;
	private String email;
	private double limitC;
	private LocalDate data;
	private String msg;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLimitC() {
		return limitC;
	}
	public void setLimitC(double limitC) {
		this.limitC = limitC;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ClienteM [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", limitC=" + limitC + ", data=" + data
				+ "]";
	}
	
}
