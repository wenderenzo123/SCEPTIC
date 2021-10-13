package model.vo;

public class EquipamentoVO {
	private Long Id;
	private String nome;
	private double peso;
	private Long numeroDeSerie;
	private double preco;
	private int quantidade;
	private FuncionarioVO responsavel;
	private LocalVO local;
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso>0) {
			this.peso = peso;
		}
		else {
			
		}
	}
	public Long getNumeroDeSerie() {
		return numeroDeSerie;
	}
	public void setNumeroDeSerie(Long numeroDeSerie) {
		if(numeroDeSerie>0) {
			this.numeroDeSerie = numeroDeSerie;
		}
		else {
			
		}
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if(preco>0 && preco!=0) {
			this.preco = preco;
		}
		else {
			
		}
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade>0 || quantidade==0) {
			this.quantidade = quantidade;
		}
		else {
			
		}
	}
	public FuncionarioVO getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(FuncionarioVO responsavel) {
		if(responsavel==null) {
			System.out.println("Nulo");
		}
		else {
				this.responsavel = responsavel;
		}
	}
	public LocalVO getLocal() {
		return local;
	}
	public void setLocal(LocalVO local) {
		if(local==null) {
			System.out.println("Nulo");
		}
		else {
				this.local = local;
		}
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
}
