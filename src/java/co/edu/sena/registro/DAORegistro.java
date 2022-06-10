/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.registro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 */
public class DAORegistro {

    String dBurl = "jdbc:mysql://localhost:3306/java_estumatricula?zeroDateTimeBehavior=convertToNull";
    Connection cnn;
    boolean est;

    public boolean conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection(dBurl, "root", "");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }

    public boolean saveNewUser(DTORegistro dtoRegistro) {
        try {
            est = conectar();
            if (est) {
                try (Statement st = cnn.createStatement()) {
                    st.executeUpdate("INSERT INTO usuarios (correo,pwd,nombres,apellidos,tipo_doc,docid) VALUES('" + dtoRegistro.getCorreo() + "','" + dtoRegistro.getPassword() + "','" + dtoRegistro.getNombre() + "','" + dtoRegistro.getApellidos() + "','" + dtoRegistro.getTipo_doc() + "','" + dtoRegistro.getNro_doc() + "')");
                    st.close();
                }
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
