/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto1pr3.Dao.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Entity
@Table(name="pais")
public class PaisModelo implements Serializable {

 @Id
 @SequenceGenerator(name="sec_Pais", sequenceName="sec_pais", allocationSize = 1 )
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_Pais")
 @Column(name="id")
 private Integer id;
  
 @Column (name="nombre")
 private String nombre_pais;
 
 @Column (name="abreviatura")
 private String abreviatura;
 
 @Column (name="idioma")
 private String idioma;
 
 @Column (name="moneda")
 private String moneda;
 
 @Column (name="religion")
 private String religion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
 
     @Override
    public String toString() {
        return "{" + "id=" + id + ", nombre=" + nombre_pais + ", abreviatura=" + abreviatura + ", idioma=" + idioma + ", moneda=" + moneda + ", religion=" + religion + '}';
    }

    
}
