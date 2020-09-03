package com.gui.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.ProizvodService;


@ManagedBean
public class ProizvodController  {
    
     private String kolicina="";
     private String kompanija="";
     private String naziv="";
     private String cena=""; 
    private String acena=""; 
    private String aid=""; 
    private String spec="";
    private String bcena="";
    private String bid="";
    private String cid="";
 
	@EJB
	private ProizvodService service;
        
        
        public  String getKolicina() {
		return kolicina;
	    }
        public void setKolicina(String kolicina) {
		this.kolicina=kolicina;
        }
        
        public  String getAcena() {
		return acena;
	    }
        public void setAcena(String acena) {
		this.acena=acena;
        }
        public  String getBcena() {
    		return bcena;
    	}
        public void setBcena(String bcena) {
    	    this.bcena=bcena;
        }
        public  String getSpec() {
    		return spec;
    	}
        public void setSpec(String spec) {
    		this.spec=spec;
        }       
        public  String getKompanija() {
		return kompanija;
	    }
        public void setKompanija(String kompanija) {
		this.kompanija=kompanija;
        }          
        public  String getNaziv() {
		return naziv;
	    }
        public void setNaziv(String naziv) {
		this.naziv=naziv;
        }
        public  String getAid() {
		return aid;
	    }
        public void setAid(String aid) {
		this.aid=aid;
	    }
                
        public  String getBid() {
		return bid;
	    }
        public void setBid(String bid) {
		this.bid=bid;
	    }
        public  String getCid() {
    		return cid;
    	}
        public void setCid(String cid) {
    		this.cid=cid;
    	}
        public  String getCena() {
		return cena;
	    }
        public void setCena(String cena) {
		this.cena=cena;
	    }
   
       public void brisiProizvod(String id){
		service.deleteProizvod(Integer.parseInt(id));
	   }

   	   public void dodajProizvod(String naziv, String spec, String kompanija, String cena, String kolicina) {
		service.addProizvod(naziv,Boolean.parseBoolean(spec),kompanija,Integer.parseInt(cena),Integer.parseInt(kolicina));
	   } 
       public void azurirajProizvod(String id, String cena) {
		service.updateProizvod(Integer.parseInt(id),Integer.parseInt(cena));
	   }
       public void azurirajKolicinu(String id,String kolicina) {
        service.updateKolicina(Integer.parseInt(id),Integer.parseInt(kolicina));
       }
}

