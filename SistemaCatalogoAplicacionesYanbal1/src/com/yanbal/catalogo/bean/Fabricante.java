/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "FABRICANTE", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT a FROM Fabricante a"),
    @NamedQuery(name = "Fabricante.findById", query = "SELECT a FROM Fabricante a WHERE a.id = :id"),
    @NamedQuery(name = "Fabricante.findByNombre", query = "SELECT a FROM Fabricante a WHERE a.nombre = :nombre")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "ID")
    private Long id=null;
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(min = 1, max = 40)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    
    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFabricante")
    private Collection<SoftwareBase> softwareBaseCollection;

    public Fabricante() {
    }

    public Fabricante(Long id) {
        this.id = id;
    }

    public Fabricante(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<SoftwareBase> getSoftwareBaseCollection() {
        return softwareBaseCollection;
    }

    public void setSoftwareBaseCollection(Collection<SoftwareBase> softwareBaseCollection) {
        this.softwareBaseCollection = softwareBaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
