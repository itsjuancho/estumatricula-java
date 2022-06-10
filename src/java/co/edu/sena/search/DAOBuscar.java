/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class DAOBuscar {

    String dBurl = "jdbc:mysql://localhost:3306/java_estumatricula?zeroDateTimeBehavior=convertToNull";
    Connection cnn;
    boolean e;

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

    public List<DTOBuscar> getColegios() {
        int count = 0;
        DTOBuscar p = new DTOBuscar();
        DTOBuscar[] vp = new DTOBuscar[100];
        List<DTOBuscar> lp = new ArrayList<DTOBuscar>();
        try {
            e = conectar();
            if (e) {
                try (Statement st = cnn.createStatement()) {
                    ResultSet rs1 = st.executeQuery("SELECT * FROM colegios");
                    rs1.beforeFirst();
                    while (rs1.next()) {
                        vp[count] = new DTOBuscar();
                        vp[count].setId_colegio(rs1.getInt("id_colegio"));
                        vp[count].setNombre(rs1.getString("NOMBRE"));
                        vp[count].setTipo_ie(rs1.getString("tipo_ie"));
                        vp[count].setEmail(rs1.getString("email"));
                        vp[count].setMunicipio(rs1.getString("municipio_id"));
                        lp.add(vp[count]);
                        count++;
                    }
                    st.close();
                    return lp;
                }
            } else {
                return lp;
            }
        } catch (Exception e) {

        }
        return null;
    }
}
