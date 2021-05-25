/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND.Clases;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Axcell Espinal
 */
public class Conectar {
         
   Connection n;

    public Connection conexion(String usuario, String password){
        try {
            //1. conexion
            Connection cn = //recuerden poner el usuario y clave de su host
            DriverManager.getConnection("jdbc:mysql://localhost:3306/Reuniones", usuario, password);
            
            n = cn;
            System.out.println("se ha concectado exitosamente");

        }
        catch(SQLException Q){
            JOptionPane.showMessageDialog
        (null, "Revise los datos de conexion con MY SQL (usuario o contraseña), sino asegurese de que la base de datos existe");
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos");
            e.printStackTrace();
        }
        return n;
    }
}
