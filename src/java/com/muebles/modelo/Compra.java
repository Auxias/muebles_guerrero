/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muebles.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdProveedor", query = "SELECT c FROM Compra c WHERE c.compraPK.idProveedor = :idProveedor"),
    @NamedQuery(name = "Compra.findByIdMateriaPrima", query = "SELECT c FROM Compra c WHERE c.compraPK.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "Compra.findByCantidad", query = "SELECT c FROM Compra c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Compra.findByFechaCompra", query = "SELECT c FROM Compra c WHERE c.fechaCompra = :fechaCompra")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraPK compraPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MateriaPrima materiaPrima;

    public Compra() {
    }

    public Compra(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Compra(int idProveedor, int idMateriaPrima) {
        this.compraPK = new CompraPK(idProveedor, idMateriaPrima);
    }

    public CompraPK getCompraPK() {
        return compraPK;
    }

    public void setCompraPK(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraPK != null ? compraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraPK == null && other.compraPK != null) || (this.compraPK != null && !this.compraPK.equals(other.compraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.Compra[ compraPK=" + compraPK + " ]";
    }
    
}
