package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Equip_dyn_record;

public interface Equip_dyn_para_tabDAO {

	public List<Equip_dyn_record> getLastDynPara(String equip_num);

}
