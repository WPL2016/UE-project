package net.codejava.spring.dao.daointerface;

import java.util.Date;
import java.util.List;

import net.codejava.spring.model.OEEData;

public  interface OEE_calcuDAO {
      List<OEEData> getOEEDataByQuery(String starttime,String endtime,String summarytype,String equip_num);
	

}
