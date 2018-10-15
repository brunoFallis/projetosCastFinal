package br.com.caelum.tests;

import java.text.SimpleDateFormat;

import br.com.caelum.models.Contact;
import br.com.caelum.models.ContactDAO;

public class testSearchById {

	public static void main(String[] args) {
		
		ContactDAO cDao = new ContactDAO();
		
		Contact con = cDao.searchById(1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Name: "+con.getName());
		System.out.println("Email: "+con.getEmail());
		System.out.println("Adress: "+con.getAdress());
		System.out.println("Date birth: "+sdf.format(con.getDateBirth().getTime()));

	}

}
