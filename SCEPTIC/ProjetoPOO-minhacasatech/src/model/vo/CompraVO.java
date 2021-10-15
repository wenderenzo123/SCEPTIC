package model.vo;

public class CompraVO {
  private EquipamentoVO equipamento;
  private ClienteVO cliente;
  private String dataCompra;
  
  public EquipamentoVO getEquipamento() {
    return equipamento;
  }
  public String getDataCompra() {
    return dataCompra;
  }
  public void setDataCompra(String dataCompra) {
    if(dataCompra==null) {
			System.out.println("Nulo");
		}
		else {
				this.dataCompra = dataCompra;
		}
  }
  public ClienteVO getCliente() {
    return cliente;
  }
  public void setCliente(ClienteVO cliente) {
    if(cliente==null) {
			System.out.println("Nulo");
		}
		else {
				this.cliente = cliente;
		}
  }
  public void setEquipamento(EquipamentoVO equipamento) {
    if(equipamento==null) {
			System.out.println("Nulo");
		}
		else {
				this.equipamento = equipamento;
		}
  }
}
