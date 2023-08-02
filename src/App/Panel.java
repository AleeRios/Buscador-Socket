
package App;

import java.net.*;
import java.io.*;
import javax.swing.*;
        
public final class Panel extends JFrame {
    ObjectOutputStream salida;
    Socket s1;
    ServerSocket ss;
    
    public Panel(){
        initComponents();
        actualizar();
    }
    
    public void actualizar(){
        try{
            ss = new ServerSocket(2020);
        }catch(IOException e){}
    }
    
    public void aceptar(){
        try{
            s1 = ss.accept();
            JOptionPane.showMessageDialog(null, "Cliente conectado");
        }catch(IOException e){}
    }
    
    public void enviarFlujo(){
        try{
            salida = new ObjectOutputStream(s1.getOutputStream());
            String ruta = txtRuta.getText();
            String nom = txtN.getText();
            String [] aux = {ruta, nom};
            if(ruta.equals(""))
                JOptionPane.showMessageDialog(null, "Inserte una ruta o nombre");
            else{
                salida.writeObject(aux);
                salida.flush();
                salida.close();
            }    
        }catch(IOException e){}
    }
    
    public void limpiar(){
        txtRuta.setText("");
        txtN.setText("");
    }
    
    public void salir(){
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBus = new javax.swing.JButton();
        txtR = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnSa = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        lbN = new javax.swing.JLabel();
        txtN = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBus.setText("Buscar");
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });

        txtR.setText("Ruta: ");

        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });

        btnSa.setText("Salir");
        btnSa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaActionPerformed(evt);
            }
        });

        btnL.setText("Limpiar");
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        lbN.setText("Nombre: ");

        btnConectar.setText("Aceptar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbN)
                            .addComponent(txtR))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtN)
                            .addComponent(txtRuta)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnL)
                        .addGap(18, 18, 18)
                        .addComponent(btnConectar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtR)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbN)
                    .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSa)
                    .addComponent(btnL)
                    .addComponent(btnBus)
                    .addComponent(btnConectar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusActionPerformed
        //conectar();
        enviarFlujo();  
    }//GEN-LAST:event_btnBusActionPerformed

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        
    }//GEN-LAST:event_txtRutaActionPerformed

    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLActionPerformed

    private void btnSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaActionPerformed
        salir();
    }//GEN-LAST:event_btnSaActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        System.out.println("Esperando un nuevo cliente");
        aceptar();
        System.out.println("Cliente aceptado");
    }//GEN-LAST:event_btnConectarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnSa;
    private javax.swing.JLabel lbN;
    private javax.swing.JTextField txtN;
    private javax.swing.JLabel txtR;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
