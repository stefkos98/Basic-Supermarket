package com.jpa.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
 
@Entity
@Table(name = "proizvod")
public class Proizvod {
 
    

	@TableGenerator(name = "proizvod_generator", table = "generatorid", pkColumnName = "ime_generatora", valueColumnName = "vrednost_generatora", allocationSize = 1, pkColumnValue = "proizvod_generator")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "proizvod_generator")
    @Column(name = "id",updatable=false,nullable=false)

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column*/
private int id;
 
    @Column(name = "naziv")
    private String naziv;
 
    @Column(name = "kompanija")
    private String kompanija;
 
   @Column(name = "specpogodnosti")
    private boolean specpogodnosti;
   
   
    @Column(name = "cena")
    private int cena;
   
       
    @Column(name = "kolicina")
    private int kolicina;
   
    
 
    public Proizvod() {
 
    }
 
    public Proizvod(String naziv,boolean specpogodnosti,String kompanija,int cena,int kolicina) {
        this.naziv=naziv;
        this.specpogodnosti=specpogodnosti;
        this.kompanija=kompanija;
        this.cena=cena;
        this.kolicina=kolicina;
    }
 
    public int getId() {
        return id;
    }
 
    
    
    
  
    public String getNaziv() {
        return naziv;
    }
 
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
 
    public String getKompanija() {
        return kompanija;
    }
 
    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }
 
    public int getCena() {
        return this.cena;
    } 
    public void setCena(int cena) {
        this.cena = cena;
    }
    
    
    
    public int getKolicina() {
        return this.kolicina;
    } 
    
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    public boolean getSpecpogodnosti() {
        return this.specpogodnosti;
    } 
    
    public void setSpecpogodnosti(boolean specpogodnosti) {
        this.specpogodnosti = specpogodnosti;
    }
    
    
     @Override
     public String toString() {
	
	        return naziv + ";"+ ";" + id+";"+cena+";"+kolicina;
	
	    }
}

