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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByCedulaEmpleado", query = "SELECT e FROM Empleado e WHERE e.cedulaEmpleado = :cedulaEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByApellidoEmpleado", query = "SELECT e FROM Empleado e WHERE e.apellidoEmpleado = :apellidoEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccionEmpleado", query = "SELECT e FROM Empleado e WHERE e.direccionEmpleado = :direccionEmpleado"),
    @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Empleado.findByEstadoCivilEmpleado", query = "SELECT e FROM Empleado e WHERE e.estadoCivilEmpleado = :estadoCivilEmpleado"),
    @NamedQuery(name = "Empleado.findByGeneroEmpleado", query = "SELECT e FROM Empleado e WHERE e.generoEmpleado = :generoEmpleado"),
    @NamedQuery(name = "Empleado.findByEmailEmpleado", query = "SELECT e FROM Empleado e WHERE e.emailEmpleado = :emailEmpleado"),
    @NamedQuery(name = "Empleado.findByFechaDeNacimientoEmp", query = "SELECT e FROM Empleado e WHERE e.fechaDeNacimientoEmp = :fechaDeNacimientoEmp"),
    @NamedQuery(name = "Empleado.findByExperienciaLaboralEmp", query = "SELECT e FROM Empleado e WHERE e.experienciaLaboralEmp = :experienciaLaboralEmp"),
    @NamedQuery(name = "Empleado.findByHorarioEmpleado", query = "SELECT e FROM Empleado e WHERE e.horarioEmpleado = :horarioEmpleado")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "cedula_empleado")
    private Integer cedulaEmpleado;
    @Size(max = 100)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Size(max = 100)
    @Column(name = "apellido_empleado")
    private String apellidoEmpleado;
    @Size(max = 250)
    @Column(name = "direccion_empleado")
    private String direccionEmpleado;
    @Size(max = 20)
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @Size(max = 20)
    @Column(name = "estado_civil_empleado")
    private String estadoCivilEmpleado;
    @Size(max = 10)
    @Column(name = "genero_empleado")
    private String generoEmpleado;
    @Size(max = 30)
    @Column(name = "email_empleado")
    private String emailEmpleado;
    @Column(name = "fecha_de_nacimiento_emp")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimientoEmp;
    @Size(max = 250)
    @Column(name = "experiencia_laboral_emp")
    private String experienciaLaboralEmp;
    @Size(max = 25)
    @Column(name = "horario_empleado")
    private String horarioEmpleado;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Factura> facturaCollection;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEstadoCivilEmpleado() {
        return estadoCivilEmpleado;
    }

    public void setEstadoCivilEmpleado(String estadoCivilEmpleado) {
        this.estadoCivilEmpleado = estadoCivilEmpleado;
    }

    public String getGeneroEmpleado() {
        return generoEmpleado;
    }

    public void setGeneroEmpleado(String generoEmpleado) {
        this.generoEmpleado = generoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public Date getFechaDeNacimientoEmp() {
        return fechaDeNacimientoEmp;
    }

    public void setFechaDeNacimientoEmp(Date fechaDeNacimientoEmp) {
        this.fechaDeNacimientoEmp = fechaDeNacimientoEmp;
    }

    public String getExperienciaLaboralEmp() {
        return experienciaLaboralEmp;
    }

    public void setExperienciaLaboralEmp(String experienciaLaboralEmp) {
        this.experienciaLaboralEmp = experienciaLaboralEmp;
    }

    public String getHorarioEmpleado() {
        return horarioEmpleado;
    }

    public void setHorarioEmpleado(String horarioEmpleado) {
        this.horarioEmpleado = horarioEmpleado;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muebles.modelo.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
