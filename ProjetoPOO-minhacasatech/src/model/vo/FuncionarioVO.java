package model.vo;

public class FuncionarioVO {
	private String nome;
	private String endereco;
	private int telefone;
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
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		if(telefone>0) {
			this.telefone = telefone;
		}
		else {
			
		}
	}
	
}
