package com.gui.controllers;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.KarticaService;
import com.jpa.entities.Kartica;
@ManagedBean
public class KarticaController {
	private String idclana="";
	private static int iid = 0;
	private String pin="";
	private static String idkartice="";
	private String staripin="";
	private String stanje="";
	private String stanje2="";
	@EJB
	private KarticaService service;
	public void brisiKarticu(String id)
	    {
		  service.deleteKartica(Integer.parseInt(id));
		}
	    
	public String addKartica(String id_clana,String pin)
	{
		if(service.addKartica(Integer.parseInt(id_clana),Integer.parseInt(pin))==true)
		 return "kartice.xhtml?faces-redirect=true";
		else return " ";
	}
    public void promenaPina(String id,String staripin,String pin)
    {
    	service.promenaPina(Integer.parseInt(id),Integer.parseInt(staripin),Integer.parseInt(pin));
    }
    public boolean proveraPin(int id,int pin)
    {
    	return(service.proveraPin(id, pin));
    }
    public boolean proveraAktivnosti(int id)
    {
    	return(service.proveraAktivnosti(id));
    }
    @SuppressWarnings("deprecation")
	public void produzidatum(String id)
    {
    	Date d=new Date();
    	d.setYear(d.getYear()+1);
    	service.produzidatum(Integer.parseInt(id), d);
    }
    public List<Kartica> spisakKartica()
    {
    	List<Kartica> s=service.spisakKartica();
    	return s;
    }
    public void azuriranjeBodova(int id,int bodovi)
    {
    	service.azuriranjeBodova(id, bodovi);
    }   
    public String vratiStanje()
    {
    	stanje=Integer.toString(service.vratiStanje(iid));
    	return stanje;
    }
    public String vratiStanje2()
    {
    	stanje2=Integer.toString(service.vratiStanje2(iid));
    	return stanje2;
    }
    public void promenaKartice(String idclana)
    {
    	service.promenaKartice(Integer.parseInt(idclana));
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
	public void setIdkartice(String idkaartice)
	{
		idkartice=idkaartice;
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
		return stanje;
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
