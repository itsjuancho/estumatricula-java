/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    String dBurl = "jdbc:mysql://localhost:3306/java_estumatricula?zeroDateTimeBehavior=convertToNull";
    Connection cnn;
    
    public boolean conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection(dBurl,"root","");
            return true;   
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
    
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
