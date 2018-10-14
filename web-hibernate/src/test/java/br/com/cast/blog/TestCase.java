package br.com.cast.blog;

import java.util.Date;

import br.com.cast.entidade.Imagem;
import br.com.cast.entidade.Post;
import br.com.cast.persistencia.PostDao;

public class TestCase extends junit.framework.TestCase {
	
	
	
	public void testInserirPost() {
		
		Post post = new Post();
		
		post.setTexto("Teste bla bla");
		post.setData(new Date());
		
		
		Imagem img1 = new Imagem();
		img1.setArquivo("casa.jpg");
		post.addImagem(img1);
		
		Imagem img2 = new Imagem();
		img2.setArquivo("garota.jpg");
		post.addImagem(img2);
		
		Imagem img3 = new Imagem();
		img3.setArquivo("sol.jpg");		
		post.addImagem(img3);
		
		PostDao dao = new PostDao();		
		dao.inserir(post);
		
		assertTrue(post.getId() != null);
	}

}
