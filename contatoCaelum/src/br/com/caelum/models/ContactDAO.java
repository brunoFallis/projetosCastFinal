package br.com.caelum.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.exceptions.DAOException;
import br.com.caelum.persistence.ConnectionFactory;

public class ContactDAO {

	private Connection conn;
	
	public ContactDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void addContact(Contact contact) {
		
		String sql = "INSERT INTO CONTATOS.CONTATO "
				   + "(name, email, adress, dateBirth) "
				   + "VALUES(?,?,?,?)";
		
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getAdress());
			ps.setDate(4, new Date(contact.getDateBirth().getTimeInMillis()));
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	public List<Contact> getList(){
		
		String sql = "SELECT NAME, EMAIL, ADRESS, DATEBIRTH "
				   + "FROM CONTATOS.CONTATO";
		
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			
			ResultSet rs = ps.executeQuery();
			
			List<Contact> contacts = new ArrayList<>();
			
			while(rs.next()) {
				Contact c = new Contact();
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setAdress(rs.getString("adress"));

				Calendar dateBirth = Calendar.getInstance();
				dateBirth.setTime(rs.getDate("datebirth"));
				c.setDateBirth(dateBirth);
				
				contacts.add(c);
			}
			return contacts;
			
		}catch(SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
	public Contact searchById(Integer id) {
		
		String sql = "SELECT NAME, EMAIL, ADRESS, DATEBIRTH " + 
			         "FROM CONTATOS.CONTATO "
			       + "WHERE ID = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Contact c = new Contact();
			
			if(rs.next()) {
				c.setName(rs.getString(1));
				c.setEmail(rs.getString(2));
				c.setAdress(rs.getString(3));
				
				Calendar dateBirth = Calendar.getInstance();
				dateBirth.setTime(rs.getDate(4));
				c.setDateBirth(dateBirth);
			}
			
			return c;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
}
