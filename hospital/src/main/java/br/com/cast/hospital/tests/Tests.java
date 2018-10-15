package br.com.cast.hospital.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.hospital.entities.Image;
import br.com.cast.hospital.entities.PostDAO;
import br.com.cast.hospital.persistence.ImageDAO;

public class Tests {

	public static void main(String[] args) throws IOException {
		
		String dirUpload = "C:\\images\\";
		
		ImageDAO iDao =  new ImageDAO();
		
		List<Integer> images = new ArrayList<>();
		
		for(Image i : iDao.listImage(3)) {
			File file = new File(dirUpload + i.getPath());
			FileInputStream in = new FileInputStream(file);
			byte[] bytes = new byte[(int)file.length()];
			images.add(in.read(bytes));
		}
		
	}

}
