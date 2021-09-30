package model.vo;

public class ClienteVO extends PessoaVO{

	private int CPF;
	private Long Id;
	
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
