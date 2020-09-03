package com.ejb.services;

import java.io.IOException;

public interface KupovinaService {
	public Void izvrsiKupovinu(int idclana, int idproizvoda,int kolicina,boolean koristikarticu,boolean koristibodove);	
	public String sendGET(String kartica,String bodovi) throws IOException;

}
