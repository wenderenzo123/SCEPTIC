package model.vo;

public class ClienteVO {
	private String nome;
	private String endereco;
	private int CPF;
	private Long Id;
	
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
	
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		if(cPF>0)
		{
			this.CPF = cPF;
		}
		else {
			
		}
	}

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
