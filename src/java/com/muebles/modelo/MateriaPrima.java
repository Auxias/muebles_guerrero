/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muebles.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "materia_prima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrima.findAll", query = "SELECT m FROM MateriaPrima m"),
    @NamedQuery(name = "MateriaPrima.findByIdMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByNombreMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.nombreMateriaPrima = :nombreMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByEstadoMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.estadoMateriaPrima = :estadoMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByObservacionesMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.observacionesMateriaPrima = :observacionesMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByCategoriaMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.categoriaMateriaPrima = :categoriaMateriaPrima")})
public class MateriaPrima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;
    @Size(max = 100)
    @Column(name = "nombre_materia_prima")
    private String nombreMateriaPrima;
    @Size(max = 100)
    @Column(name = "estado_materia_prima")
    private String estadoMateriaPrima;
    @Size(max = 250)
    @Column(name = "observaciones_materia_prima")
    private String observacionesMateriaPrima;
    @Size(max = 200)
    @Column(name = "categoria_materia_prima")
    private String categoriaMateriaPrima;
    @JoinTable(name = "material", joinColumns = {
        @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima")}, inverseJoinColumns = {
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")})
    @ManyToMany
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima")
    private Collection<Compra> compraCollection;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombreMateriaPrima() {
        return nombreMateriaPrima;
    }

    public void setNombreMateriaPrima(String nombreMateriaPrima) {
        this.nombreMateriaPrima = nombreMateriaPrima;
    }

    public String getEstadoMateriaPrima() {
        return estadoMateriaPrima;
    }

    public void setEstadoMateriaPrima(String estadoMateriaPrima) {
        this.estadoMateriaPrima = estadoMateriaPrima;
    }

    public String getObservacionesMateriaPrima() {
        return observacionesMateriaPrima;
    }

    public void setObservacionesMateriaPrima(String observacionesMateriaPrima) {
        this.observacionesMateriaPrima = observacionesMateriaPrima;
    }

    public String getCategoriaMateriaPrima() {
        return categoriaMateriaPrima;
    }

    public void setCategoriaMateriaPrima(String categoriaMateriaPrima) {
        this.categoriaMateriaPrima = categoriaMateriaPrima;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.MateriaPrima[ idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}
