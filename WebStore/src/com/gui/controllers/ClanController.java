package com.gui.controllers;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.ClanService;
import com.jpa.entities.Clan;
@ManagedBean
public class ClanController {
	@EJB
	private ClanService service;
	private String idclana="";
	private static int iid = 0;
	private String pin="";
	private static String idkartice="";
	private String staripin="";
	private String stanje="";
	private String stanje2="";
	private String ime="";
	private String prezime="";
	public String addClan(String ime,String prezime)
	{
		service.addClan(ime, prezime);
		 return "clanovi.xhtml?faces-redirect=true";
	}
	public String deleteClan(String idclana)
	{
		service.deleteClan(Integer.parseInt(idclana));
		 return "clanovi.xhtml?faces-redirect=true";

	}
	public int vratiStanje(String id)
	{
		return service.vratiStanje(Integer.parseInt(id));
	}
	public List<Clan> spisakClanova()
	{
		return service.spisakClanova();
	}

	public void uplatiNovac(String idclana,String pin)
	{
		service.uplatiNovac(Integer.parseInt(idclana),Integer.parseInt(pin));
	}
	public String getIme()
	{
		return ime;
	}
	public void setIme(String ime)
	{
		this.ime=ime;
	}
	public String getPrezime()
	{
		return prezime;
	}
	public void setPrezime(String prezime)
	{
		this.prezime=prezime;
	}
	 public String getIdclana()
		{
			return idclana;
		}
		public String getPin()
		{
			return pin;
		}
		public void setIdclana(String id_clana)
		{
			this.idclana=id_clana;
		}
		public void setPin(String pin)
		{
			this.pin=pin;
		}
		public String getIdkartice()
		{
			return idkartice;
		}
		public void setIdkartice(String idkartiice)
		{
			idkartice=idkartiice;
		}
		public String getStaripin()
		{
			return staripin;
		}
		public void setStaripin(String staripin)
		{
			this.staripin=staripin;
		}
		public String getStanje()
		{
			return stanje;
		}
		public void setStanje(String stanje)
		{
			this.stanje=stanje;
		}
		public String getStanje2()
		{
			return stanje2;
		}
		public void setStanje2(String stanje)
		{
			this.stanje2=stanje;
		}
		public int getIId() {
			return iid;
		}
		public void setIId(int id) {
			iid = id;
		}
}
