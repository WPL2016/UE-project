package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Contact;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Contact contact) {
		if (contact.getId() > 0) {
			// update
			String sql = "UPDATE contact SET name=?, email=?, address=?,reason=?, "
						+ "telephone=? WHERE contact_id=?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getReason(),contact.getTelephone(), contact.getId());
		} else {
			// insert
			String sql = "INSERT INTO contact (name, email, address, telephone,reason)"
						+ " VALUES (?, ?, ?, ?,?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone(),contact.getReason());
		}
		
	}

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contact ORDER by contact_id DESC";
		List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact aContact = new Contact();
	
				aContact.setId(rs.getInt("contact_id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				aContact.setAddress(rs.getString("address"));
				aContact.setTelephone(rs.getString("telephone"));
				aContact.setReason(rs.getString("reason"));
				return aContact;
			}
			
		});
		
		return listContact;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int countRecord() {
		String sql = "SELECT COUNT(*) FROM contact" ;
		return  jdbcTemplate.queryForInt(sql);
		
		}
	
	
	@Override
	public Contact get(int contactId) {
		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("contact_id"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("telephone"));
					contact.setTelephone(rs.getString("reason"));
					return contact;
				}
				
				return null;
			}
			
		});
	}

}
