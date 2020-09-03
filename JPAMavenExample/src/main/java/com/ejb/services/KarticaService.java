package com.ejb.services;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jpa.entities.Kartica;
public interface KarticaService {
	public boolean addKartica(int id_clana,int pin);
    public void deleteKartica(int id);
    public void promenaPina(int id,int staripin,int pin);
    public boolean proveraPin(int id,int pin);
    public boolean proveraAktivnosti(int id);
    public void produzidatum(int id,Date datum);
    public List<Kartica> spisakKartica();
    public void azuriranjeBodova(int id,int bodovi);
    public void promenaPogodnosti(int id,boolean i);
    public int vratiStanje(int id);
    public int vratiStanje2(int id);
    public void promenaKartice(int idclana);

}
