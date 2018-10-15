package br.com.cast.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="testing")
public class Testing {
	
	private List<Integer> list;
	
	public Testing() {
		this.list = new ArrayList<>();
		this.loadList();
	}
	
	public void loadList() {
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);
		this.list.add(4);
		this.list.add(5);
	}
	
	public List<Integer> getList(){
		return this.list;
	}
	
}
