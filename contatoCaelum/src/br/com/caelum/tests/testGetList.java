package br.com.caelum.tests;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.models.Contact;
import br.com.caelum.models.ContactDAO;

public class testGetList {

	public static void main(String[] args) {
		
		ContactDAO cDao = new ContactDAO();
		
		List<Contact> c = cDao.getList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		for(Contact con : c) {
			System.out.println("Name: "+con.getName());
			System.out.println("Email: "+con.getEmail());
			System.out.println("Adress: "+con.getAdress());
			System.out.println("Date birth: "+sdf.format(con.getDateBirth().getTime()));
		}
		
	}

}
