package model.vo;

public class ClienteVO extends PessoaVO{

	private Long CPF;
	private Long Id;
	
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
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
