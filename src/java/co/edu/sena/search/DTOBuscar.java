/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.search;

/**
 *
 * @author Juancho
 */
public class DTOBuscar {
    public Integer id_colegio = 0;
    public String nombre = "";
    public String direccion = "";
    public String telefono = "";
    public String municipio = "";
    public String departamento = "";
    public String email = "";
    public String tipo_ie = "";

    public Integer getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(Integer id_colegio) {
        this.id_colegio = id_colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo_ie() {
        return tipo_ie;
    }

    public void setTipo_ie(String tipo_ie) {
        this.tipo_ie = tipo_ie;
    }
}
