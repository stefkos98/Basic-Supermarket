package com.jpa.entities;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
 
@Entity
@Table(name = "kartica")
public class Kartica {
 
    

@TableGenerator(name = "kartica_generator", table = "generatorid", pkColumnName = "ime_generatora", valueColumnName = "vrednost_generatora", allocationSize = 1, pkColumnValue = "kartica_generator")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "kartica_generator")
    @Column(name = "id",updatable=false,nullable=false)
    private int id;
@Column(name="id_clana")
private int id_clana;
@Column(name="bodovi")
private int bodovi;
@Column(name="ukupnibodovi")
private int ukupnibodovi;
@Column(name="datumisteka")
private Date datumisteka;
@Column(name="pin")
private int pin;
@Column(name="aktivna")
private boolean aktivna;
@Column(name="pogodnosti")
private boolean pogodnosti;
public Kartica()
{
	
}
public Kartica(int id_clana,int bodovi,int ukupni,Date datumisteka,int pin,boolean aktivna,boolean pogodnosti)
{
 this.setId_clana(id_clana);
 this.setBodovi(bodovi);
 this.setUkupnibodovi(ukupni);
 this.setDatumisteka(datumisteka);
 this.setPin(pin);
 this.setAktivna(aktivna);
 this.setPogodnosti(pogodnosti);
}
public int getId() {
	return id;
}
public int getId_clana()
{
	return id_clana;
}
public int getBodovi()
{
	return bodovi;
}
public Date getDatumisteka()
{
	return datumisteka;
}
public int getPin()
{
	return pin;
}
public boolean getAktivna()
{
	return aktivna;
}

public void setId_clana(int id)
{
	this.id_clana=id;
}
public void setBodovi(int bodovi)
{
	this.bodovi=bodovi;
}
public void setDatumisteka(Date datum)
{
	this.datumisteka=datum;
}
public void setPin(int pin)
{
	this.pin=pin;
}
public void setAktivna(boolean aktivna)
{
	this.aktivna=aktivna;
}
public boolean getPogodnosti()
{
	return pogodnosti;
}
public void setPogodnosti(boolean pog)
{
	this.pogodnosti=pog;
}
public void setUkupnibodovi(int b)
{
	this.ukupnibodovi=b;
}
public int getUkupnibodovi()
{
	return ukupnibodovi;
}
}
