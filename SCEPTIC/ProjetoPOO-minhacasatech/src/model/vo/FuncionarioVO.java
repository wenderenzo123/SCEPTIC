package model.vo;

public class FuncionarioVO extends PessoaVO{
	
	private Long Id;
	private String email;
	private String senha;
	private int tipo;

	public FuncionarioVO() {
		super();
	}
	public FuncionarioVO(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
	}
	public FuncionarioVO(String nome, String endereco, String telefone, String email,String senha,int tipo) {
		super(nome, endereco, telefone);
		setEmail(email);
		setSenha(senha);
		setTipo(tipo);
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
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
