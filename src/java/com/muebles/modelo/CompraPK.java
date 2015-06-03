/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muebles.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
public class CompraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proveedor")
    private int idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_prima")
    private int idMateriaPrima;

    public CompraPK() {
    }

    public CompraPK(int idProveedor, int idMateriaPrima) {
        this.idProveedor = idProveedor;
        this.idMateriaPrima = idMateriaPrima;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProveedor;
        hash += (int) idMateriaPrima;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        if (this.idMateriaPrima != other.idMateriaPrima) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.CompraPK[ idProveedor=" + idProveedor + ", idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}
