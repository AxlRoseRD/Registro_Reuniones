/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND.Jframess;

import BACKEND.Clases.Conectar;
import FRONTEND.Imagenes.Imagen;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axcell Espinal
 */
public class Buscador extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Conectar Con = new Conectar();
    Connection cn = Con.conexion();
    Statement st;

    /**
     * Creates new form Buscador
     */
    public Buscador() {
        initComponents();

        Imagen F = new Imagen();
        F.getAll("meet.png", 0, -15, 810, 455);
        F.cargarImagen(jPanel1);

        crearTabla();
    }

    private void crearTabla() {
        //este comando impide que se pueda editar la tabla
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //este comando agrega las columnas a la tabla
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora de inicio");
        modelo.addColumn("Hora final");
        modelo.addColumn("Lugar");
        modelo.addColumn("notas/detalles");
        jTable1.setModel(modelo);
    }

    private String indice(int index) {
        String retornar = "";

        switch (index) {
            case 0:
                retornar = "eventName";
                break;
                
            case 1:
                retornar = "eventDate";
                break;
                
            case 2:
                retornar = "startTime";
                break;
                
            case 3:
                retornar = "endTime";
                break;
                
            case 4:
                retornar = "eventPlace";
                break;               
        }
        return retornar;
    }

    private void buscador(String texto, String filtro) {
        try {

            //crear la sentencia SQL
            String busqueda = "%" + texto + "%";
            String SQL = "select * from eventos where " + filtro + " like" + '"' + busqueda + '"';
            System.out.println("se creo la sentencia");
            System.out.println(SQL);

            //Ejecutar la sentencia
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            System.out.println("se ejecuto la sentencia");

            //Ordenar los valores
            int incremento = 1;
            String[] fila = new String[7];
            while (rs.next()) {
                System.out.println(incremento);
                
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("eventName");
                fila[2] = rs.getString("eventDate");
                fila[3] = rs.getString("startTime");
                fila[4] = rs.getString("endTime");
                fila[5] = rs.getString("eventPlace");
                fila[6] = rs.getString("eventDetails");

                incremento++;

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.err.println("" + e.getMessage());
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
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        filtro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Reunion");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        volver.setText("Salir");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Fecha", "Hora de inicio", "Hora final", "Lugar" }));

        jLabel1.setText("Filtrar por:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(buscar)
                        .addGap(18, 18, 18)
                        .addComponent(volver)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(volver))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        MainMenu MM = new MainMenu();
        MM.show();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        buscador(jTextField1.getText(), indice(filtro.getSelectedIndex()));
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
