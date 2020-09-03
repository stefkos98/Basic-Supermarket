package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "clan")
public class Clan {
@TableGenerator(name = "clan_generator", table = "generatorid", pkColumnName = "ime_generatora", valueColumnName = "vrednost_generatora", allocationSize = 1, pkColumnValue = "clan_generator")
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "clan_generator")
@Column(name = "id",updatable=false,nullable=false)
private int id;
@Column(name="ime")
private String ime;
@Column(name="prezime")
private String prezime;
@Column(name="novac")
private int novac;
@Column(name="idkartice")
private int idkartice;
public Clan()
{
	
}
public Clan(String ime,String prezime,int novac)
{
	this.setIdkartice(idkartice);
	this.setIme(ime);
	this.setPrezime(prezime);
	this.setNovac(novac);
}
public Clan(int idkartice,String ime,String prezime,int novac)
{
	this.setIdkartice(idkartice);
	this.setIme(ime);
	this.setPrezime(prezime);
	this.setNovac(novac);
}
public int getId()
{
	return this.id;
}
public void setId(int id)
{
	this.id=id;
}
public int getIdkartice()
{
	return this.idkartice;
}
public void setIdkartice(int id)
{
	this.idkartice=id;
}
public String getIme()
{
	return this.ime;
}
public void setIme(String ime)
{
	this.ime=ime;
}
public String getPrezime()
{
	return this.prezime;
}
public void setPrezime(String prezime)
{
	this.prezime=prezime;
}
public int getNovac()
{
	return this.novac;
}
public void setNovac(int p)
{
	this.novac=p;
}
}
