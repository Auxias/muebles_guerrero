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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByCedulaPro", query = "SELECT p FROM Proveedor p WHERE p.cedulaPro = :cedulaPro"),
    @NamedQuery(name = "Proveedor.findByNombrePro", query = "SELECT p FROM Proveedor p WHERE p.nombrePro = :nombrePro"),
    @NamedQuery(name = "Proveedor.findByApellidoPro", query = "SELECT p FROM Proveedor p WHERE p.apellidoPro = :apellidoPro"),
    @NamedQuery(name = "Proveedor.findByDireccionPro", query = "SELECT p FROM Proveedor p WHERE p.direccionPro = :direccionPro"),
    @NamedQuery(name = "Proveedor.findByEmailPro", query = "SELECT p FROM Proveedor p WHERE p.emailPro = :emailPro"),
    @NamedQuery(name = "Proveedor.findByTelefonoPro", query = "SELECT p FROM Proveedor p WHERE p.telefonoPro = :telefonoPro"),
    @NamedQuery(name = "Proveedor.findByEstadoPro", query = "SELECT p FROM Proveedor p WHERE p.estadoPro = :estadoPro"),
    @NamedQuery(name = "Proveedor.findByObservacionesPro", query = "SELECT p FROM Proveedor p WHERE p.observacionesPro = :observacionesPro")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "cedula_pro")
    private Integer cedulaPro;
    @Size(max = 100)
    @Column(name = "nombre_pro")
    private String nombrePro;
    @Size(max = 100)
    @Column(name = "apellido_pro")
    private String apellidoPro;
    @Size(max = 200)
    @Column(name = "direccion_pro")
    private String direccionPro;
    @Size(max = 30)
    @Column(name = "email_pro")
    private String emailPro;
    @Size(max = 20)
    @Column(name = "telefono_pro")
    private String telefonoPro;
    @Size(max = 10)
    @Column(name = "estado_pro")
    private String estadoPro;
    @Size(max = 250)
    @Column(name = "observaciones_pro")
    private String observacionesPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private Collection<Compra> compraCollection;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getCedulaPro() {
        return cedulaPro;
    }

    public void setCedulaPro(Integer cedulaPro) {
        this.cedulaPro = cedulaPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getApellidoPro() {
        return apellidoPro;
    }

    public void setApellidoPro(String apellidoPro) {
        this.apellidoPro = apellidoPro;
    }

    public String getDireccionPro() {
        return direccionPro;
    }

    public void setDireccionPro(String direccionPro) {
        this.direccionPro = direccionPro;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public void setEmailPro(String emailPro) {
        this.emailPro = emailPro;
    }

    public String getTelefonoPro() {
        return telefonoPro;
    }

    public void setTelefonoPro(String telefonoPro) {
        this.telefonoPro = telefonoPro;
    }

    public String getEstadoPro() {
        return estadoPro;
    }

    public void setEstadoPro(String estadoPro) {
        this.estadoPro = estadoPro;
    }

    public String getObservacionesPro() {
        return observacionesPro;
    }

    public void setObservacionesPro(String observacionesPro) {
        this.observacionesPro = observacionesPro;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
