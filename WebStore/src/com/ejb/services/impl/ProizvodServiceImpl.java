package com.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.ProizvodService;
import com.jpa.entities.Proizvod;


@Stateless
public class ProizvodServiceImpl implements ProizvodService {
	@PersistenceContext(name = "WebStore")
	private EntityManager em;
@Override
public void addProizvod(String naziv, boolean spec, String kompanija, int cena, int kolicina) {
    try{
    	Proizvod p1 = new Proizvod(naziv,spec,kompanija,cena,kolicina);
        em.persist(p1);
        } catch(Exception ex) {
	
	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	
	}  
    
  }
        
@Override
public void deleteProizvod(int id) {
try{
      
    Proizvod p1 =em.find(Proizvod.class, id);
    em.remove(p1);
       
        } catch(Exception ex) {
	
	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	
	}  
    
  }
     
@Override
public void updateProizvod(int id,int cena) {
try{
    Proizvod p1=em.find(Proizvod.class, id);
    p1.setCena(cena);
        } catch(Exception ex) {
	
	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	
	}  
    
  }
 @Override
 public void updateKolicina(int id,int novakol)
 {
	 try{
		    Proizvod p1=em.find(Proizvod.class, id);
		    p1.setKolicina(novakol);
		} 
	 catch(Exception ex) {
			
			System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
			
		        }
 }


        
}
   
	


