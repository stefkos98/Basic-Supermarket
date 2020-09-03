package com.gui.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.KupovinaService;


@ManagedBean
public class KupovinaController  {
    
     private String idclana="";
     private String idproizvoda="";
     private String kolicina="";
     private String kartica="";
     private String bodovi="";
	@EJB
	private KupovinaService service;
	public  String getIdclana() {
		return idclana;
	    }
        public  String getIdproizvoda() {
		return idproizvoda;
	    }
        
        public void setIdclana(String idclana) {
		this.idclana=idclana;
        }
       
        public void setIdproizvoda(String idproizvoda) {
		this.idproizvoda=idproizvoda;
        }
        public String getKolicina() {
		return this.kolicina;
	    }
        
        public void setKolicina(String kolicina) {
		this.kolicina=kolicina;
        }
        public String getKartica()
        {
        	return kartica;
        }
        public String getBodovi()
        {
        	return bodovi;
        }
        public void setKartica(String kartica)
        {
        	this.kartica=kartica;
        }
        public void setBodovi(String bodovi)
        {
        	this.bodovi=bodovi;
        }
        
        
               
       public void dodajKupovinu(String idclana, String idproizvoda,String kolicina,String koristikarticu,String koristibodove){
		service.izvrsiKupovinu(Integer.parseInt(idclana),Integer.parseInt(idproizvoda),Integer.parseInt(kolicina),Boolean.parseBoolean(koristikarticu),Boolean.parseBoolean(koristibodove));
	}
        
        
    
}

