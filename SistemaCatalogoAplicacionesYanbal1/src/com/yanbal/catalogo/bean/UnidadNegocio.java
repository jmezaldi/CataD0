/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "UNIDAD_NEGOCIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadNegocio.findAll", query = "SELECT p FROM UnidadNegocio p"),
    @NamedQuery(name = "UnidadNegocio.findById", query = "SELECT p FROM UnidadNegocio p WHERE p.id = :id"),
    @NamedQuery(name = "UnidadNegocio.findByNombre", query = "SELECT p FROM UnidadNegocio p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "UnidadNegocio.findByCod", query = "SELECT p FROM UnidadNegocio p WHERE p.codigo = :codigo")})
public class UnidadNegocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;

    public UnidadNegocio() {
    }

    public UnidadNegocio(Long id) {
        this.id = id;
    }

    public UnidadNegocio(Long id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof UnidadNegocio)) {
            return false;
        }
        UnidadNegocio other = (UnidadNegocio) object;
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