package model.vo;

public class ClienteVO {
	private String nome;
	private String endereco;
	private String CPF;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome==null) {
			
		}
		else {
			if(nome.equals("")) {
				
			}
			else {
				this.nome = nome;
			}
		}
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco==null) {
			
		}
		else {
			if(endereco.equals("")) {
				
			}
			else {
				this.endereco = endereco;
			}
		}
		
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		if(CPF==null) {
			
		}
		else {
			if(CPF.equals("")) {
				
			}
			else {
				this.CPF = CPF;
			}
		}
	}
	
	
	
}
