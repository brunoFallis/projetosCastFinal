package br.com.caelum.tests;

import java.util.Calendar;

import br.com.caelum.models.Contact;
import br.com.caelum.models.ContactDAO;

public class testAddContact {

	public static void main(String[] args) {

		Contact c = new Contact();

		c.setName("Test");
		c.setEmail("test.test@test.com");
		c.setAdress("Avenue Test, Nº 123, test-ts");
		c.setDateBirth(Calendar.getInstance());

		ContactDAO cDao = new ContactDAO();

		cDao.addContact(c);

	}

}
