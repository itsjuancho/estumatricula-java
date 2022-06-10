/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.login;

import co.edu.sena.login.DTOLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juancho
 */
public class DAOLogin {
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
    
    public DTOLogin getUser(String pwd, String correo) throws SQLException {
        try{
            conectar();
            DTOLogin dtoLogin = new DTOLogin();
            try (
                Statement st = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                ResultSet rs = st.executeQuery("SELECT id_user,CONCAT(nombres, ' ',apellidos) as 'nombre',nivel_rol,correo,pwd FROM usuarios WHERE correo = '" + correo +"' AND pwd = '"+ pwd +"'");
                rs.last();
                dtoLogin.setId_user(rs.getInt("id"));
                dtoLogin.setNombres(rs.getString("nombre"));
                dtoLogin.setNivel_rol(rs.getInt("nivel_rol"));
                dtoLogin.setCorreo(rs.getString("correo"));
                dtoLogin.setPassword(rs.getString("pwd"));
                st.close();
            }
            return dtoLogin;
        }catch(Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }
}
