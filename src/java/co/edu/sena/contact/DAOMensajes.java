/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juancho
 */
public class DAOMensajes {

    String dBurl = "jdbc:mysql://localhost:3306/java_estumatricula?zeroDateTimeBehavior=convertToNull";
    Connection cnn;
    boolean status;

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

    public boolean saveNewMessage(DTOMensajes dtoMensajes) {
        try {
            status = conectar();
            if (status) {
                try (Statement st = cnn.createStatement()) {
                    st.executeUpdate("INSERT INTO mensajes (correo,nombre,asunto,telefono,mensaje) VALUES('" + dtoMensajes.getCorreo() + "','" + dtoMensajes.getNombres() + "','" + dtoMensajes.getAsunto() + "','" + dtoMensajes.getTelefono() + "','" + dtoMensajes.getMensaje() + "')");
                    st.close();
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
