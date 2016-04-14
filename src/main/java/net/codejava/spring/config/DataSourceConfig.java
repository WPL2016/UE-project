package net.codejava.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.spring.dao.daoimpl.Atype_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Atype_use_inf_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.AuthorsDAOImpl;
import net.codejava.spring.dao.daoimpl.ContactDAOImpl;


import net.codejava.spring.dao.daoimpl.Ener_stat_tabDAOImpl;

import net.codejava.spring.dao.daoimpl.Equip_dyn_para_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Equip_oper_stat_tabDAOImpl;


import net.codejava.spring.dao.daoimpl.Ener_stat_tabDAOImpl;


import net.codejava.spring.dao.daoimpl.Equip_para_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Equip_pres_para_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Equip_product_relat_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Equip_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Maint_plan_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Maint_reg_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mater_pur_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mater_stock_stat_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mater_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mater_use_stock_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mou_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Mou_use_inf_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.OEE_calcuDAOImpl;
import net.codejava.spring.dao.daoimpl.Produce_plan_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Produce_prog_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Product_qual_asse_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Product_qual_stat_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Product_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.Role_AuthorsDAOImpl;
import net.codejava.spring.dao.daoimpl.RolesDAOImpl;
import net.codejava.spring.dao.daoimpl.User_RolesDAOImpl;
import net.codejava.spring.dao.daoimpl.User_role_applyDAOImpl;
import net.codejava.spring.dao.daoimpl.User_tabDAOImpl;
import net.codejava.spring.dao.daoimpl.UsersDAOImpl;
import net.codejava.spring.dao.daointerface.Atype_tabDAO;
import net.codejava.spring.dao.daointerface.Atype_use_inf_tabDAO;
import net.codejava.spring.dao.daointerface.AuthorsDAO;
import net.codejava.spring.dao.daointerface.ContactDAO;


import net.codejava.spring.dao.daointerface.Ener_stat_tabDAO;


import net.codejava.spring.dao.daointerface.Equip_dyn_para_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_oper_stat_tabDAO;


import net.codejava.spring.dao.daointerface.Ener_stat_tabDAO;



import net.codejava.spring.dao.daointerface.Equip_para_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_pres_para_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_product_relat_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.dao.daointerface.Maint_plan_tabDAO;
import net.codejava.spring.dao.daointerface.Maint_reg_tabDAO;
import net.codejava.spring.dao.daointerface.Mater_pur_tabDAO;
import net.codejava.spring.dao.daointerface.Mater_stock_stat_tabDAO;
import net.codejava.spring.dao.daointerface.Mater_tabDAO;
import net.codejava.spring.dao.daointerface.Mater_use_stock_tabDAO;
import net.codejava.spring.dao.daointerface.Mou_tabDAO;
import net.codejava.spring.dao.daointerface.Mou_use_inf_tabDAO;
import net.codejava.spring.dao.daointerface.OEE_calcuDAO;
import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
import net.codejava.spring.dao.daointerface.Product_qual_asse_tabDAO;
import net.codejava.spring.dao.daointerface.Product_qual_stat_tabDAO;
import net.codejava.spring.dao.daointerface.Product_tabDAO;
import net.codejava.spring.dao.daointerface.Role_AuthorsDAO;
import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.dao.daointerface.User_RolesDAO;
import net.codejava.spring.dao.daointerface.User_role_applyDAO;
import net.codejava.spring.dao.daointerface.User_tabDAO;
import net.codejava.spring.dao.daointerface.UsersDAO;


@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//dataSource.setUrl("jdbc:sqlserver://192.168.21.117:1433;databaseName=UEequipmanageDB");
		//dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=xukai");



	    dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=UEequipmanageDB");



		dataSource.setUsername("sa");


		dataSource.setPassword("123");


		
		return dataSource;
	}
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
	@Bean
	public Equip_tabDAO getEquip_tabDAO() {
		return new Equip_tabDAOImpl(getDataSource());
	}
	@Bean
	public Atype_tabDAO getAtype_tabDAO() {
		return new Atype_tabDAOImpl(getDataSource());
	}
	@Bean
	public Equip_oper_stat_tabDAO getEquip_oper_stat_tabDAO() {
		return new Equip_oper_stat_tabDAOImpl(getDataSource());
	}
	@Bean
	public Equip_para_tabDAO getEquip_para_tabDAO() {
		return new Equip_para_tabDAOImpl(getDataSource());
	}
	@Bean
	public Equip_product_relat_tabDAO getEquip_product_relat_tabDAO() {
		return new Equip_product_relat_tabDAOImpl(getDataSource());
	}
	@Bean
	public Maint_plan_tabDAO getMaint_plan_tabDAO() {
		return new Maint_plan_tabDAOImpl(getDataSource());
	}
	@Bean
	public Maint_reg_tabDAO getMaint_reg_tabDAO() {
		return new Maint_reg_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mater_tabDAO getMater_tabDAO() {
		return new Mater_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mou_tabDAO getMou_tabDAO() {
		return new Mou_tabDAOImpl(getDataSource());
	}
	@Bean
	public Produce_plan_tabDAO getProduce_plan_tabDAO() {
		return new Produce_plan_tabDAOImpl(getDataSource());
	}
	@Bean
	public Product_tabDAO getProduct_tabDAO() {
		return new Product_tabDAOImpl(getDataSource());
	}
	@Bean
	public User_tabDAO getUser_tabDAO() {
		return new User_tabDAOImpl(getDataSource());
	}
	@Bean
	public Atype_use_inf_tabDAO getAtype_use_inf_tabDAO() {
		return new Atype_use_inf_tabDAOImpl(getDataSource());
	}
	@Bean
	public Equip_pres_para_tabDAO getEquip_pres_para_tabDAO() {
		return new Equip_pres_para_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mou_use_inf_tabDAO getMou_use_inf_tabDAO() {
		return new Mou_use_inf_tabDAOImpl(getDataSource());
	}
	@Bean
	public Product_qual_stat_tabDAO getProduct_qual_stat_tabDAO() {
		return new Product_qual_stat_tabDAOImpl(getDataSource());
	}
	@Bean
	public Product_qual_asse_tabDAO getProduct_qual_asse_tabDAO() {
		return new Product_qual_asse_tabDAOImpl(getDataSource());
	}
	@Bean
	public Ener_stat_tabDAO getEner_stat_tabDAO() {
		return new Ener_stat_tabDAOImpl(getDataSource());
	}
	@Bean
	public Produce_prog_tabDAO getProduce_prog_tabDAO() {
		return new Produce_prog_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mater_use_stock_tabDAO getMater_use_stock_tabDAO() {
		return new Mater_use_stock_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mater_stock_stat_tabDAO getMater_stock_stat_tabDAO() {
		return new Mater_stock_stat_tabDAOImpl(getDataSource());
	}
	@Bean
	public Mater_pur_tabDAO getMater_pur_tabDAO () {
		return new Mater_pur_tabDAOImpl(getDataSource());
	}



	@Bean
	public Equip_dyn_para_tabDAO getEquip_dyn_para_tabDAO() {
		return new Equip_dyn_para_tabDAOImpl(getDataSource());

	}
    @Bean
   	public OEE_calcuDAO getOEE_calcuDAO() {
   		return new OEE_calcuDAOImpl(getDataSource());

   	} 
    @Bean
   	public UsersDAO getUsersDAO() {
   		return new UsersDAOImpl(getDataSource());

   	} 
    @Bean
   	public RolesDAO getRolesDAO() {
   		return new RolesDAOImpl(getDataSource());

   	} 
    @Bean
   	public User_RolesDAO getUser_RolesDAO() {
   		return new User_RolesDAOImpl(getDataSource());

   	} 
    @Bean
   	public AuthorsDAO getAuthorsDAO() {
   		return new AuthorsDAOImpl(getDataSource());

   	} 
    @Bean
   	public  Role_AuthorsDAO getRole_AuthorsDAO() {
   		return new  Role_AuthorsDAOImpl(getDataSource());

   	} 
    @Bean
   	public  User_role_applyDAO getUser_role_applyDAO() {
   		return new  User_role_applyDAOImpl(getDataSource());

   	} 
    
   
}
