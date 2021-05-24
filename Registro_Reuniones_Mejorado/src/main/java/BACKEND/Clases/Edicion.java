/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND.Clases;

import java.util.Date;
import BACKEND.Interfaces.Editar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Axcell Espinal
 */
public class Edicion implements Editar{
    Conectar Con = new Conectar();
    Connection cn = Con.conexion("root", "");

    @Override
    public void guardar(Reuniones r) {        
         try {
            PreparedStatement pst 
            = cn.prepareStatement("INSERT INTO eventos (Id, eventName,eventDate,startTime,endTime,eventPlace,eventDetails) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, null);
            pst.setString(2, r.getNombre());
            pst.setString(3, r.getFecha());
            pst.setString(4, r.getHoraI());
            pst.setString(5, r.getHoraF());
            pst.setString(6, r.getLugar());
            pst.setString(7, r.getDetalles());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            cn.close();
        } 
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos");
        }
        
        System.out.println("se ha guardado el registro");
    }

    @Override
    public void actualizar(Reuniones r) {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE eventos SET eventName ='" + r.getNombre()
                    + "',eventDate='" + r.getFecha()
                    + "',startTime='" + r.getHoraI()
                    + "',endTime='" + r.getHoraF()
                    + "',eventPlace='" + r.getLugar()
                    + "',eventDetails='" + r.getDetalles()
                    + "'WHERE Id ='" + r.getID() + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "datos modificados");
            
            cn.close();
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("se ha actualizado el registro");
    }

    @Override
    public void eliminar(Reuniones r) {
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM eventos WHERE Id='" + r.getID() + "'");
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "datos eliminados");
        }
        catch (Exception e) {
        }       
    }
    
}