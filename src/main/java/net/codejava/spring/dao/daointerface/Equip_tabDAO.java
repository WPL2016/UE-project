package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Equip_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Equip_tabDAO {
	
	public void saveOrUpdate(Equip_tab equip_tab);
	
	public void delete(String equip_num);
	
	public Equip_tab get(String equip_num);
	
	public List<Equip_tab> list();
	
	public int updateSingleColumn(Equip_tab equip_tab,String column,String value);
	
	public List<Equip_tab> getSomeEquip(String type);
	
	public List<Equip_tab> getSomeEquipWithState(String type);

	public List<Equip_tab> getSomeEquipByEnergy(String energy_type);
}
