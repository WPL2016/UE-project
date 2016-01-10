package net.codejava.spring.dao.daoimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.spring.dao.daointerface.Role_AuthorsDAO;
import net.codejava.spring.model.Role_Authors;


public class Role_AuthorsDAOImpl implements Role_AuthorsDAO {

	 private JdbcTemplate jdbcTemplate;
		
		public Role_AuthorsDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}

		
		@Override
		public void save(Role_Authors role_authors) {
	    
				// insert
				String sql = "INSERT INTO role_authors (author_id,role_id)"
							+ " VALUES (?, ?)";
				jdbcTemplate.update(sql, role_authors.getAuthor_id(),role_authors.getRole_id());
			
			
		}
			

		@Override
		public void delete(String role_id) {
			String sql = "DELETE FROM role_authors WHERE role_id=?";
			jdbcTemplate.update(sql, role_id);
		}

}
