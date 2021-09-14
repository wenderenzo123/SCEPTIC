package model.vo;

public class FuncionarioVO {
	private String nome;
	private String endereco;
	private int telefone;
	private Long Id;
	private String email;
	private String senha;
	private int tipo;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email==null) {
			
		}
		else {
			if(email.equals("")) {
				
			}
			else {
				this.email = email;
			}
		}
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha==null) {
			
		}
		else {
			if(senha.equals("")) {
				
			}
			else {
				this.senha = senha;
			}
		}
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		if(tipo==0 || tipo==1) {
			this.tipo = tipo;
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
