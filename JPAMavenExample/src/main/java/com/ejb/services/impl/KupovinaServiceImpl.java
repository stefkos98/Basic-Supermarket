package com.ejb.services.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.ejb.services.KupovinaService;
import com.jpa.entities.Clan;
import com.jpa.entities.Kartica;
import com.jpa.entities.Proizvod;


@Stateless
public class KupovinaServiceImpl implements KupovinaService {
	/*@PersistenceContext(name = "WebStore")
	private EntityManager em; */
	private EntityManager em;
public KupovinaServiceImpl()
{
	EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("WebStore");
    em = emf.createEntityManager();
}
	
	@Override
	public Void izvrsiKupovinu(int idclana, int idproizvoda,int kolicina,boolean koristikarticu,boolean koristibodove)
	{
		try {
		Clan c=em.find(Clan.class, idclana);
		Proizvod p=em.find(Proizvod.class,idproizvoda);
		int stanje=c.getNovac();
		int idkartice=c.getIdkartice();
		int ukupnacena;
		if(p.getKolicina()>=kolicina)
		{
			int doker=Integer.parseInt(this.sendGET(Boolean.toString(koristikarticu),Boolean.toString(koristibodove)));
			if(doker>=3)
			{
			 Kartica k=em.find(Kartica.class,idkartice);
			 Date d=k.getDatumisteka();
			 Date m=new Date();
			 if(m.getTime()>d.getTime())
			 {
				 k.setAktivna(false);
				 System.out.println("Vasa kartica je istekla");
			 }
			 else
			 {
			  if(p.getSpecpogodnosti()==true && k.getPogodnosti()==true)
			  {
				ukupnacena=(p.getCena()-10)*kolicina;
			  }
			  else
				ukupnacena=p.getCena()*kolicina;
			  if(doker==4)
			  {
				if(k.getBodovi()>=ukupnacena)
				{
					k.setBodovi(k.getBodovi()-ukupnacena);
					k.setUkupnibodovi(k.getUkupnibodovi()+ukupnacena/100);	
					if(k.getUkupnibodovi()>1000) k.setPogodnosti(true);
					p.setKolicina(p.getKolicina()-kolicina);
					return null;
				}
			  }
			 
			  if(stanje>=ukupnacena)
			  {
			  c.setNovac(stanje-ukupnacena);
			  k.setBodovi(k.getBodovi()+ukupnacena/100);
			  k.setUkupnibodovi(k.getUkupnibodovi()+ukupnacena/100);
			  if(k.getUkupnibodovi()>1000 && k.getPogodnosti()==false) k.setPogodnosti(true);
			  p.setKolicina(p.getKolicina()-kolicina);
		      }
			 }
			}
			else 
			{
				ukupnacena=p.getCena()*kolicina;
				if(stanje>=ukupnacena)
				 {
				  c.setNovac(stanje-ukupnacena);
				  p.setKolicina(p.getKolicina()-kolicina);
			     }
				else
					System.out.println("Nemate dovoljno novca na racunu");
			}
		}
		else
		{
			System.out.println("Nema dovoljno kolicine na lageru");
		}
		return null;
		}
		catch(IOException i)
		{
			System.out.println("Greska pri povezivanju sa dockerom"+i);
			return null;
		}
	}
// pozivanje dockera za ispitivanje kupovine
	private static final String USER_AGENT = "Mozilla/5.0";

	@Override
	public String sendGET(String kartica,String bodovi) throws IOException {
		URL obj = new URL("http://localhost/?kartica="+kartica+"&bodovi="+bodovi);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result

			System.out.println(response.toString());	
			return response.toString();

		} else {
			String res="5";
			System.out.println("GET request not worked");
			return res;
		}

	}
}        
   
   
	


