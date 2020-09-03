package com.test;
import static org.junit.Assert.*;

import java.util.List;
import com.ejb.services.impl.ClanServiceImpl;
import com.ejb.services.impl.KarticaServiceImpl;
import com.jpa.entities.Kartica;

import org.junit.After;
import org.junit.Test;

public class ServiceTest {
	@Test
    public void test()
	{
		KarticaServiceImpl karticaService=new KarticaServiceImpl();
		//Test 1-vraca sve kartice
		List<Kartica> lista=karticaService.spisakKartica();
		assertNotNull(lista);
		//Test 2-promena pina
		karticaService.promenaPina(2,2000,2468);
		boolean x=karticaService.proveraPin(2, 2468);
		assertTrue(x);
		//Test 3-dodavanje kartice
		boolean y=karticaService.addKartica(10005, 4444);
		assertTrue(y);
		
		ClanServiceImpl clanService=new ClanServiceImpl();
		//Test 4-azuriranje stanja na racunu
        int stanje=clanService.vratiStanje(2);
		clanService.uplatiNovac(2, 5000);
		int stanje2=clanService.vratiStanje(2);
		assertEquals(stanje+5000,stanje2);
		
     }
	@After
	public void vrati()
	{
		KarticaServiceImpl karticaController=new KarticaServiceImpl();
		karticaController.promenaPina(2, 2468, 2000);
		boolean x=karticaController.proveraPin(2, 2000);
		assertTrue(x);
	} 
}
