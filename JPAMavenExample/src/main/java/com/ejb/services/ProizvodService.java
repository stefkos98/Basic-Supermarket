package com.ejb.services;



public interface ProizvodService {

	public void addProizvod(String naziv, boolean spec, String kompanija, int cena, int kolicina);
        public void deleteProizvod(int id);
        public void updateProizvod(int id, int cena);
        public void updateKolicina(int id,int novakol);

        
       
	
}
