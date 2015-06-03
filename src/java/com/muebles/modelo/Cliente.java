/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muebles.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCedulaCliente", query = "SELECT c FROM Cliente c WHERE c.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByApellidoCliente", query = "SELECT c FROM Cliente c WHERE c.apellidoCliente = :apellidoCliente"),
    @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Cliente.findByGeneroCliente", query = "SELECT c FROM Cliente c WHERE c.generoCliente = :generoCliente"),
    @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Cliente.findByFechaDeNacimientoCliente", query = "SELECT c FROM Cliente c WHERE c.fechaDeNacimientoCliente = :fechaDeNacimientoCliente")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "cedula_cliente")
    private Integer cedulaCliente;
    @Size(max = 100)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Size(max = 100)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Size(max = 20)
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    @Size(max = 10)
    @Column(name = "genero_cliente")
    private String generoCliente;
    @Size(max = 20)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Size(max = 100)
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "fecha_de_nacimiento_cliente")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimientoCliente;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Factura> facturaCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Date getFechaDeNacimientoCliente() {
        return fechaDeNacimientoCliente;
    }

    public void setFechaDeNacimientoCliente(Date fechaDeNacimientoCliente) {
        this.fechaDeNacimientoCliente = fechaDeNacimientoCliente;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
