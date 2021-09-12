package model.dao;

import java.util.List;

import model.vo.LocalVO;

public class teste {
	public static void main(String[] args) {
	BaseDAO dao= new BaseDAO();
	//System.out.println(dao.getConnection());
	LocalDAO dao2 = new LocalDAO();
	
	LocalVO vo = new LocalVO();
	
	vo.setNome("Adalberto House");
	vo.setCompartimento("Escrivanhinha");
	vo.setId(new Long (4));
	
	LocalVO vo2 = new LocalVO();
	
	vo2.setNome("Casa do mario");
	vo2.setCompartimento("Terceiro cofre");
	vo2.setId(new Long (7));
	
	dao2.alterar_local(vo);
	
	dao2.alterar_local(vo2);
	
	dao2.remover_local(vo2);
	List<LocalVO> list= dao2.listar_local();
	for (LocalVO vo_0: list) {
		System.out.println(vo_0.getNome());
	}
	
}
}
