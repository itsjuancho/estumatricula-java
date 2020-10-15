/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.registro;

/**
 *
 * @author David Esteban Jimenez
 */
public class Registro {
    public String nombre = "";
    public String apellidos = "";
    public String tipo_doc = "";
    public String nro_doc = "";
    public String correo = "";
    public String password = "";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipo_doc;
    }

    public void setTipoDoc(String tipodoc) {
        switch(tipodoc){
            case "CC": this.tipo_doc = "Cédula de Ciudadanía"; break;
            case "PEP": this.tipo_doc = "Permiso Especial de Permanencia"; break;
            case "NIT": this.tipo_doc = "Número de Identificación Tributaria"; break;
            case "Pasaporte": this.tipo_doc = tipodoc; break;
            default: this.tipo_doc = "Documento Nacional de Identidad"; break;
        }
    }

    public String getNroDoc() {
        return nro_doc;
    }

    public void setNroDoc(String docid) {
        this.nro_doc = docid;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
