/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Axcell Espinal
 */
public class Conectar {

    Connection n;

    public void Conectar() {
        conexion();
    }

    public Connection conexion() {
        try {
            //1. conexion
            Connection cn
            = //recuerden poner el usuario y clave de su host
            DriverManager.getConnection("jdbc:mysql://localhost:3306/Reuniones", "root", "Axcell2015");
    
            n = cn;
            System.out.println("se ha concectado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se conecto");
            e.printStackTrace();
        }
        
        return n;
    }
}
