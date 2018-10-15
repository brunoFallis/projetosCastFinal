package br.com.cast.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.models.Contact;

public class ContactDAO {

	public List<Contact> listContacts() {

		String sql = "SELECT ID, NAME, EMAIL, ADRESS, DATEBIRTH, PASS FROM CONTACTS.CONTACT";

		try (Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement ps = conn.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			List<Contact> contacts = new ArrayList<>();

			while (rs.next()) {
				Contact c = new Contact();
				
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setAdress(rs.getString("adress"));
				c.setDateBirth(rs.getString("datebirth"));
				c.setPass(rs.getString("pass"));
				
				contacts.add(c);
			}

			return contacts;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void deleteContact(Integer id) {
		
		String sql = "DELETE FROM CONTACTS.CONTACT WHERE ID = ?";
	
		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void insertContact(Contact c) {
		String sql = "INSERT INTO CONTACTS.CONTACT (NAME,EMAIL,ADRESS,DATEBIRTH,PASS) VALUES (?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getAdress());
			ps.setString(4, c.getDateBirth());
			ps.setString(5, c.getPass());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void updateContact(Contact c) {
		String sql = "UPDATE CONTACTS.CONTACT "
				   + "SET NAME = ?, EMAIL = ?, ADRESS = ?, DATEBIRTH = ?, PASS = ? "
				   + "WHERE ID = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getAdress());
			ps.setString(4, c.getDateBirth());
			ps.setString(5, c.getPass());
			
			ps.setInt(6, c.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Contact searchById(Integer id) {
		
		String sql = "SELECT NAME, EMAIL, ADRESS, DATEBIRTH, PASS FROM CONTACTS.CONTACT WHERE ID = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			Contact c = new Contact();
			
			if (rs.next()) {
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setAdress(rs.getString("adress"));
				c.setDateBirth(rs.getString("datebirth"));
				c.setPass(rs.getString("pass"));
			}

			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public Contact loginContact(String user, String pass) {
		String sql = "SELECT NAME, EMAIL, ADRESS, DATEBIRTH, PASS FROM CONTACTS.CONTACT WHERE NAME = ? AND PASS = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			Contact contact = new Contact();
			
			if (rs.next()) {
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAdress(rs.getString("adress"));
				contact.setDateBirth(rs.getString("datebirth"));
				contact.setPass(rs.getString("pass"));
				return contact;
			}

			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
