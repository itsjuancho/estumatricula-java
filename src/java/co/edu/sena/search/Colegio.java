/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.search;

/**
 *
 * @author Juan Andrés Pérez
 */
public class Colegio {
    public Integer id_colegio = 0;
    public String nombre = "";
    public String direccion = "";
    public String telefono = "";
    public String municipio = "";
    public String departamento = "";
    public String email = "";
    public String tipo_ie = "";
    
    public void setIdColegio(Integer id_c){
        this.id_colegio = id_c;
    }
    
    public void setNombreColegio(String nombre){
        this.nombre = nombre;
    }
    
    public void setDireccion(String dir){
        this.direccion = dir;
    }
    
    public void setTelf(String tlf){
        this.telefono = tlf;
    }
    
    public void setMun(String mun){
        this.municipio = mun;
    }
    
    public void setDept(String depto){
        this.departamento = depto;
    }
    
    public void setEmail(String correo){
        this.email = correo;
    }
    
    public void setTipoIE(String tipo){
        this.tipo_ie = tipo;
    }
    
    public Integer getIdColegio(){
        return id_colegio;
    }
    
    public String getNombreColegio(){
        return nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public String getTlf(){
        return telefono;
    }
    
    public String getMun(){
        return municipio;
    }
    
    public String getDepto(){
        return departamento;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTipoIE(){
        return tipo_ie;
    }
}
