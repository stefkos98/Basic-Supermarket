package com.ejb.services.impl;

import com.ejb.services.KarticaService;
import com.jpa.entities.Clan;
import com.jpa.entities.Kartica;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless	
public class KarticaServiceImpl implements KarticaService {
@PersistenceContext(name = "WebStore")
	private EntityManager em;
@Override
public boolean addKartica(int id_clana,int pin)
{
	try {
	List<Kartica> svekartice = em.createQuery("SELECT k FROM Kartica k where k.id_clana="+Integer.toString(id_clana), Kartica.class).getResultList();
    if(svekartice.isEmpty())
    {
    Date d=new Date();
    Date d2=new Date(d.getTime()+1000*1000);
	Kartica k1=new Kartica(id_clana,0,0,d2,pin,true,false);
	em.persist(k1);
	Clan c=em.find(Clan.class,id_clana);
	c.setIdkartice(k1.getId());
    }
    else
    	System.out.println("Dati korisnik je vec clan");
    return true;
	}	
	catch(Exception ex) {
		
		System.out.println("Greska prilikom rada sa bazom: cao \n" + ex.getMessage());
		return false;
	}
}
@Override
public void deleteKartica(int id)
{
	try 
	{
    Kartica k1 =em.find(Kartica.class, id);
    em.remove(k1);
    } 
	catch(Exception ex) {
	
	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	
	}  
}
@Override
public List<Kartica> spisakKartica() {

	List<Kartica> sveKartice = em.createQuery("SELECT k FROM Kartica k", Kartica.class).getResultList();
	return sveKartice;
}
@Override
public void promenaPina(int id,int staripin,int pin)
{
	try {
         Kartica k1 =em.find(Kartica.class, id);
         if(k1.getPin()==staripin)
        	 k1.setPin(pin);
        } catch(Exception ex) {
	
	System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
	
	}  	
}
@Override
public boolean proveraPin(int id,int pin)
{	
        Kartica k1 =em.find(Kartica.class, id);
        if(k1.getPin()==pin) return true;
        else return false;
}
@Override
public boolean proveraAktivnosti(int id)
{
	Kartica k1 =em.find(Kartica.class, id);
	boolean x=k1.getAktivna();    
	return(x);
}
@Override
public void produzidatum(int id,Date datum)
{
	Kartica k1 =em.find(Kartica.class, id);
    k1.setDatumisteka(datum);
    k1.setAktivna(true);
}
@Override
public void azuriranjeBodova(int id,int bodovi)
{
	try {
		Kartica k1=em.find(Kartica.class, id);
		k1.setBodovi(k1.getBodovi()+bodovi);
		if(bodovi>0)
			k1.setUkupnibodovi(k1.getUkupnibodovi()+bodovi);
	}
	catch(Exception e)
	{
		System.out.println("Greska pri azuriranju bodova"+e.toString());
	}
	
}
@Override
public void promenaPogodnosti(int id,boolean i)
{
	try {
		Kartica k1=em.find(Kartica.class,id);
		k1.setPogodnosti(i); 
	}
	catch(Exception e)
	{
		System.out.println("Greska pri promeni pogodnosti"+e.toString());
	}
}
@Override
public int vratiStanje(int id)
{
	Kartica k1=em.find(Kartica.class, id);
	return(k1.getBodovi());
}
@Override
public int vratiStanje2(int id)
{
	Kartica k1=em.find(Kartica.class, id);
	return(k1.getUkupnibodovi());
}
@Override
public void promenaKartice(int idclana)
{
  Clan c=em.find(Clan.class, idclana);
  if(c.getNovac()>=500)
  {
  List<Kartica> svekartice = em.createQuery("SELECT k FROM Kartica k where k.id_clana="+Integer.toString(idclana), Kartica.class).getResultList();
  Kartica k=svekartice.get(0);
  Kartica k1=new Kartica(idclana,k.getBodovi(),k.getUkupnibodovi(),k.getDatumisteka(),k.getPin(),k.getAktivna(),k.getPogodnosti());
  em.remove(svekartice.get(0));   // gasenje stare kartice
  em.persist(k1);                // aktivacija nove kartice
  c.setIdkartice(k1.getId());    // promena idkartice kod clana
  c.setNovac(c.getNovac()-500); // Placanje penala zbog promene kartice
  }
  else
  {
	  System.out.println("Nemate dovoljno novca za promenu kartice");
  }

}
}
