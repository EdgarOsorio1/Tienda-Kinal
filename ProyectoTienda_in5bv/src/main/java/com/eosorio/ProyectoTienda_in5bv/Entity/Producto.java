package com.eosorio.ProyectoTienda_in5bv.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombreProd")
    private String nombreProd;

    @Column(name = "descripcionProd")
    private String descripcionProd;

    @Column(name = "precioProd")
    private Double precioProd;

    @Column(name = "existencia")
    private Integer existencia;

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProd() { return nombreProd; }
    public void setNombreProd(String nombreProd) { this.nombreProd = nombreProd; }

    public String getDescripcionProd() { return descripcionProd; }
    public void setDescripcionProd(String descripcionProd) { this.descripcionProd = descripcionProd; }

    public Double getPrecioProd() { return precioProd; }
    public void setPrecioProd(Double precioProd) { this.precioProd = precioProd; }

    public Integer getExistencia() { return existencia; }
    public void setExistencia(Integer existencia) { this.existencia = existencia; }
}