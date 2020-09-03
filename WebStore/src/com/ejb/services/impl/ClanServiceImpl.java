package com.ejb.services.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ejb.services.ClanService;
import com.jpa.entities.Clan;
import com.jpa.entities.Kartica;

@Stateless	
public class ClanServiceImpl implements ClanService {
	@PersistenceContext(name = "WebStore")
	private EntityManager em;
	@Override
	public void addClan(String ime,String prezime)
	{
		Clan c=new Clan(ime,prezime,0);
		em.persist(c);
		
	}
	@Override
	public void deleteClan(int idclana)
	{
		try {
			Clan c=em.find(Clan.class, idclana);
			em.remove(c);
			List<Kartica> svekartice = em.createQuery("SELECT k FROM Kartica k where k.id_clana="+Integer.toString(idclana), Kartica.class).getResultList();
			em.remove(svekartice.get(0));
		}
		catch(Exception e)
		{
			System.out.println("Greska priliom brisanja"+e);
		}
	}
	@Override
	public void addKarticu(int id,int idkartice)
	{
		Clan c=em.find(Clan.class, id);
		c.setIdkartice(idkartice);
	}
	@Override
	public void uplatiNovac(int id,int kolicina)
	{
		Clan c=em.find(Clan.class,id);
		c.setNovac(c.getNovac()+kolicina);
	}
	@Override
	public void Kupovina(int id,int cena)
	{
		Clan c=em.find(Clan.class, id);
		if(c.getNovac()>=cena)
		{
			c.setNovac((c.getNovac()-cena));
		}
	}
	@Override
	public List<Clan> spisakClanova()
	{
		List<Clan> sviclanovi = em.createQuery("SELECT c FROM Clan c", Clan.class).getResultList();
		return sviclanovi;
	}
	@Override
	public int vratiStanje(int id)
	{
		Clan c=em.find(Clan.class, id);
	    return c.getNovac();
	}
}
