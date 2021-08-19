package model.vo;

public class EquipamentoVO {
	private String nome;
	private double peso;
	private int numeroDeSerie;
	private double preco;
	private int quantidade;
	
	private String Responsavel;
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
	public int getNumeroDeSerie() {
		return numeroDeSerie;
	}
	public void setNumeroDeSerie(int numeroDeSerie) {
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
	public String getResponsavel() {
		return Responsavel;
	}
	public void setResponsavel(String responsavel) {
		if(responsavel==null) {
			
		}
		else {
			if(responsavel.equals("")) {
				
			}
			else {
				Responsavel = responsavel;
			}
		}
	}
	
}
