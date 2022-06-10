/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.login;

import java.sql.SQLException;

/**
 *
 *
 */
public class CTRLogin {
    DAOLogin daoLogin = new DAOLogin();
    
    public DTOLogin getCustomer(String pwd, String correo) throws SQLException {
        return daoLogin.getUser(pwd,correo);
    } 
}
