package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.AuthorsDAO;
import net.codejava.spring.model.Authors;


public class AuthorsDAOImpl implements AuthorsDAO{

private JdbcTemplate jdbcTemplate;
	
	public AuthorsDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Authors> list() {
		String sql = "SELECT * FROM authors";
		List<Authors> listAuthors = jdbcTemplate.query(sql, new RowMapper<Authors>() {

			@Override
			public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
				Authors aAuthor = new Authors();
	
				aAuthor.setAuthor_id(rs.getInt("author_id"));
				aAuthor.setAuthor_name(rs.getString("author_name"));
				aAuthor.setAuthor_describe(rs.getString("author_describe"));
				return aAuthor;
			}
			
		});
		
		return listAuthors;
	}
	
	@Override
	public List<Authors> list(int role_id) {
		String sql = "SELECT * FROM authors as a,role_authors as b where b.role_id="+role_id+" and a.author_id=b.author_id";
		List<Authors> listAuthors = jdbcTemplate.query(sql, new RowMapper<Authors>() {

			@Override
			public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
				Authors aAuthor = new Authors();
	
				aAuthor.setAuthor_id(rs.getInt("author_id"));
				aAuthor.setAuthor_name(rs.getString("author_name"));
				aAuthor.setAuthor_describe(rs.getString("author_describe"));
				return aAuthor;
			}
			
		});
		
		return listAuthors;
	}
	
	@Override
	public List<Authors> listWithout(int role_id) {
		String sql = "SELECT DISTINCT* FROM authors where  author_id not in (select author_id from role_authors where role_id='"+role_id+"')";
		List<Authors> listAuthors = jdbcTemplate.query(sql, new RowMapper<Authors>() {

			@Override
			public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
				Authors aAuthor = new Authors();
	
				aAuthor.setAuthor_id(rs.getInt("author_id"));
				aAuthor.setAuthor_name(rs.getString("author_name"));
				aAuthor.setAuthor_describe(rs.getString("author_describe"));
				return aAuthor;
			}
			
		});
		
		return listAuthors;
	}
	
	
	
}
