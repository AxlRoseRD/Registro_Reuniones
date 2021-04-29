/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Paquete.Reunionesr;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axcell Espinal
 */
public class Tabla extends javax.swing.JFrame {
    
    Conectar conx = new Conectar();
    Connection cnt = conx.conexion();

    /**
     * Creates new form Tabla
     */
    public Tabla() {
        initComponents();
        tablaImagen();
        Conectar cn = new Conectar();
        conx.Conectar();
        mostrarD();
    }
    
    public void tablaImagen()//metodo para cargar la imagen del fondo del menu principal
    {
        System.out.println("imagen de dialogo tabla activada");
        JLabel marcoImagen = new JLabel(new ImageIcon("src/main/java/Imagenes/meet.png"));
        marcoImagen.setBounds(0, -90, 780, 480);
        jPanel1.add(marcoImagen);
    }
    
    void mostrarD() {
        
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora de inicio");
        modelo.addColumn("Hora final");
        modelo.addColumn("Lugar");
        modelo.addColumn("notas/detalles");
        jtReuniones.setModel(modelo);
        
        String[] datos = new String[7];
        try {
            Statement st = cnt.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM eventos");
            while (rs.next()) {
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                
                modelo.addRow(datos);
            }
            
            jtReuniones.setModel(modelo);
        } catch (Exception e) {
        }
    }
    
    private void guardar(Reunionesr r) {//si estos campos estan vacios no permitira guardar
        if (Rnombre.getText() == ""
                && Rfecha.getText() == ""
                && RhoraI.getText() == ""
                && RhoraF.getText() == ""
                && Rlugar.getText() == "") {
            
            JOptionPane.showMessageDialog(null, "Datos invalidos, no deje los campos vacios");
        } else {//si no se dejaron los campos vacios pues se guardan los datos
            try {
                Conectar con = new Conectar();
                PreparedStatement pst
                        = cnt.prepareStatement("INSERT INTO eventos (Id, eventName,eventDate,startTime,endTime,eventPlace,eventDetails) VALUES(?,?,?,?,?,?,?)");
                pst.setString(1, null);
                pst.setString(2, r.getNombre());
                pst.setString(3, r.getFecha());
                pst.setString(4, r.getHoraI());
                pst.setString(5, r.getHoraF());
                pst.setString(6, r.getLugar());
                pst.setString(7, r.getDetalles());
                pst.executeUpdate();
                mostrarD();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar datos");
            }
        }
        Rnombre.setText("");
        Rfecha.setText("");
        RhoraI.setText("");
        RhoraF.setText("");
        Rlugar.setText("");
        Rnotas.setText("");
    }

    private void editar() {        
        try {
            PreparedStatement pst = cnt.prepareStatement("UPDATE eventos SET eventName ='" + Rnombre.getText()
                    + "',eventDate='" + Rfecha.getText()
                    + "',startTime='" + RhoraI.getText()
                    + "',endTime='" + RhoraF.getText()
                    + "',eventPlace='" + Rlugar.getText()
                    + "',eventDetails='" + Rnotas.getText()
                    + "'WHERE Id ='" + Rid.getText() + "'");
            
            pst.executeUpdate();
            mostrarD();
            JOptionPane.showMessageDialog(null, "datos modificados");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminar() {
        int fila = jtReuniones.getSelectedRow();
        String id = "";
        id = jtReuniones.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement pst = cnt.prepareStatement("DELETE FROM eventos WHERE Id='" + id + "'");
            pst.executeUpdate();
            mostrarD();
            JOptionPane.showMessageDialog(null, "datos eliminados");
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReuniones = new javax.swing.JTable();
        Rnombre = new javax.swing.JTextField();
        Rfecha = new javax.swing.JTextField();
        RhoraF = new javax.swing.JTextField();
        RhoraI = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        horaf = new javax.swing.JLabel();
        horaI = new javax.swing.JLabel();
        notas = new javax.swing.JLabel();
        lugar = new javax.swing.JLabel();
        Rlugar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Rnotas = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        IDR = new javax.swing.JLabel();
        Rid = new javax.swing.JTextField();
        Limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de reuniones");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtReuniones.setBackground(new java.awt.Color(255, 204, 204));
        jtReuniones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtReuniones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtReunionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtReuniones);

        nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombre.setText("Nombre");

        fecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fecha.setText("Fecha");

        horaf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        horaf.setText("Hora final");

        horaI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        horaI.setText("Hora de inicio");

        notas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        notas.setText("Notas/detalles");

        lugar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lugar.setText("Lugar");

        Rnotas.setColumns(20);
        Rnotas.setRows(5);
        jScrollPane2.setViewportView(Rnotas);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        IDR.setText("ID");

        Rid.setEditable(false);

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rnombre)
                            .addComponent(fecha)
                            .addComponent(Rfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RhoraF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RhoraI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(horaf)
                            .addComponent(horaI))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lugar)
                            .addComponent(Rlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDR)
                            .addComponent(Rid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Limpiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notas))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nombre)
                                .addComponent(horaI)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RhoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha)
                            .addComponent(horaf)
                            .addComponent(IDR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RhoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(notas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(guardar)
                    .addComponent(eliminar)
                    .addComponent(Limpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Reunionesr reunion = new Reunionesr();
        
        reunion.setNombre(Rnombre.getText());
        reunion.setFecha(Rfecha.getText());
        reunion.setHoraI(RhoraI.getText());
        reunion.setHoraF(RhoraF.getText());
        reunion.setLugar(Rlugar.getText());
        reunion.setDetalles(Rnotas.getText());
        
        guardar(reunion);
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_eliminarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void jtReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtReunionesMouseClicked
        int fila = jtReuniones.getSelectedRow();
        if (fila >= 0) {
            Rid.setText(jtReuniones.getValueAt(fila, 0).toString());
            Rnombre.setText(jtReuniones.getValueAt(fila, 1).toString());
            Rfecha.setText(jtReuniones.getValueAt(fila, 2).toString());
            RhoraI.setText(jtReuniones.getValueAt(fila, 3).toString());
            RhoraF.setText(jtReuniones.getValueAt(fila, 4).toString());
            Rlugar.setText(jtReuniones.getValueAt(fila, 5).toString());
            Rnotas.setText(jtReuniones.getValueAt(fila, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "no selecciono fila");
        }
    }//GEN-LAST:event_jtReunionesMouseClicked

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        Rid.setText("");
        Rnombre.setText("");
        Rfecha.setText("");
        RhoraI.setText("");
        RhoraF.setText("");
        Rlugar.setText("");
        Rnotas.setText("");
        
    }//GEN-LAST:event_LimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDR;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextField Rfecha;
    private javax.swing.JTextField RhoraF;
    private javax.swing.JTextField RhoraI;
    private javax.swing.JTextField Rid;
    private javax.swing.JTextField Rlugar;
    private javax.swing.JTextField Rnombre;
    private javax.swing.JTextArea Rnotas;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel horaI;
    private javax.swing.JLabel horaf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtReuniones;
    private javax.swing.JLabel lugar;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel notas;
    // End of variables declaration//GEN-END:variables
}