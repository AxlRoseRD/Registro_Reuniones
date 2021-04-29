package Paquete;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Axcell Espinal
 */
public class Info extends javax.swing.JDialog {

    /**
     * Creates new form Info
     */
    public Info(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        dialogoImagen();
    }
    public void dialogoImagen()//metodo para cargar la imagen del fondo del menu principal
    {
        System.out.println("imagen de dialogo activada");
       JLabel marcoImagen = new JLabel(new ImageIcon("src/main/java/Imagenes/PiedraTextura2.jpg"));
       marcoImagen.setBounds(0, 0, 400, 500);
       fondoDialogo.add(marcoImagen);   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoDialogo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion del software");
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        fondoDialogo.setBackground(new java.awt.Color(153, 255, 153));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Proyecto final de programacion I hecho por:\n\nAxcell espinal nuñez 2019-8358\nPamela Villar Muñoz 2019-8358\nAndrews Fernandez calderon 2019-7565\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout fondoDialogoLayout = new javax.swing.GroupLayout(fondoDialogo);
        fondoDialogo.setLayout(fondoDialogoLayout);
        fondoDialogoLayout.setHorizontalGroup(
            fondoDialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoDialogoLayout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(48, 48, 48))
            .addGroup(fondoDialogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        fondoDialogoLayout.setVerticalGroup(
            fondoDialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoDialogoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoDialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoDialogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
