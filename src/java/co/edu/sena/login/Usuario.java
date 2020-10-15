/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.login;

/**
 *
 * @author Tatiana Duque
 */
public class Usuario {
    public String correo = "tatianaduque06@misena.edu.co";
    public String password = "tatiana12345";
    public String nombres = "Tatiana";
    public String apellidos = "Duque";
    public String dni = "1005652896";
    
    public String getNombre(){
        return nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public String getEmail(){
        return correo;
    }
    
    public String getPw(){
        return password;
    }
    
    public String getDni(){
        return dni;
    }
    
}
