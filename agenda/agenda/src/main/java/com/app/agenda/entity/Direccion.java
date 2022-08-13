package com.app.agenda.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable{

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddireccion")
    private Integer iddireccion;

    @Column(name = "descripcion")
    private Integer descripcion;

    @Column(name = "contacto_idcontacto")
    private Integer contactoIdcontacto;

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Integer getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Integer descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getContactoIdcontacto() {
        return contactoIdcontacto;
    }

    public void setContactoIdcontacto(Integer contactoIdcontacto) {
        this.contactoIdcontacto = contactoIdcontacto;
    }
}
