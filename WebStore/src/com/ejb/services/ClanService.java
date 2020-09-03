package com.ejb.services;

import java.util.Date;
import java.util.List;

import com.jpa.entities.Clan;
import com.jpa.entities.Kartica;

public interface ClanService {
public void addClan(String ime,String prezime);
public void deleteClan(int id);
public void addKarticu(int id,int idkartice);
public void uplatiNovac(int id,int kolicina);
public void Kupovina(int id,int cena);
public List<Clan> spisakClanova();
public int vratiStanje(int id);
}
