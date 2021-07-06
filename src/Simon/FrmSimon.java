/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simon;

import Sonidos.Sonidos;
import Tiempo.Tiempo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;

/**
 *
 * @author jprod
 */
public class FrmSimon extends javax.swing.JFrame {
    
    JButton btns[]=new JButton[9];
    
    /**
     * Creates new form FrmSimon
     */
    public FrmSimon() {
        initComponents();
        //Modifica el Spinner para que no sea editable
        ((JSpinner.DefaultEditor)this.txtNivel.getEditor()).getTextField().setEditable(false);
        //Establece el Spinner en normal
        this.txtNivel.getModel().setValue("Normal");
        
        //Agrega los botones al vector de botones
        this.btns[1]=this.btnVerde;
        this.btns[2]=this.btnRojo;
        this.btns[3]=this.btnAzul;
        this.btns[4]=this.btnAmarillo;
        this.btns[5]=this.btnMorado;
        this.btns[6]=this.btnAnaranjado;
        this.btns[7]=this.btnRosado;
        this.btns[8]=this.btnNegro;        
    }
    
    private void deshabilitar(){
        for (int i = 1; i <= 8; i++) {
            this.btns[i].setEnabled(false);
        }
    }
    
    private void habilitar(){
        for (int i = 1; i <= 8; i++) {
            this.btns[i].setEnabled(true);
        }
    }
    
    private void mostrarBoton(int color){
        this.btns[color].setEnabled(true);
        Sonidos.reproducir(Sonidos.notas[color]);
    }
    
    private void mostrarSecuencia(){
        deshabilitar();
        int color=Simon.obtenerSecuencia();
        if (color!=0){
            this.mostrarBoton(color);
        }else{
            this.timerSecuencia.stop();
            habilitar();
        }
    }
    
    Timer timerSecuencia = new Timer (1000, new ActionListener (){
        public void actionPerformed(ActionEvent e){
            mostrarSecuencia();
        }
    });
    
    private void iniciarSecuencia(){
        Simon.agregarSecuencia();
        this.timerSecuencia.setDelay(Simon.nivel);
        this.timerSecuencia.start();
    }
    
    
    Timer timer = new Timer (1000, new ActionListener (){
        public void actionPerformed(ActionEvent e){
            Tiempo.avanzar();
            mostrar();
        }
    });
    
    private void mostrar(){
        lblTiempo.setText(Tiempo.obtenerTiempo());
        lblPuntos.setText(String.valueOf(Simon.puntaje));
    }
    
    private void actionPerformedGenerico(int color){
        Sonidos.reproducir(Sonidos.notas[color]);
        if (!Simon.compararSecuencia(color)){
            JOptionPane.showMessageDialog(this,"Lo siento!","Perdiste",JOptionPane.ERROR_MESSAGE);
            if(Simon.mayorPuntaje<Simon.puntaje){
                Simon.mayorPuntaje=Simon.puntaje;
                this.lblPuntosMax.setText(String.valueOf(Simon.mayorPuntaje));
            }
            Simon.reiniciar();
            Tiempo.reiniciar();
            timer.stop();
        }else{
            if (Simon.indice==Simon.secuencia.size()){    
                Simon.puntaje++;
                iniciarSecuencia();
            }
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
        btnVerde = new javax.swing.JButton();
        btnRojo = new javax.swing.JButton();
        btnAmarillo = new javax.swing.JButton();
        btnAzul = new javax.swing.JButton();
        btnAnaranjado = new javax.swing.JButton();
        btnMorado = new javax.swing.JButton();
        btnRosado = new javax.swing.JButton();
        btnNegro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTiempo = new javax.swing.JLabel();
        txtNivel = new javax.swing.JSpinner();
        lblTiempo1 = new javax.swing.JLabel();
        lblTiempo2 = new javax.swing.JLabel();
        lblTiempo4 = new javax.swing.JLabel();
        lblTiempo5 = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblPuntosMax = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnVerde.setBackground(java.awt.Color.green);
        btnVerde.setEnabled(false);
        btnVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerdeActionPerformed(evt);
            }
        });

        btnRojo.setBackground(java.awt.Color.red);
        btnRojo.setEnabled(false);
        btnRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRojoActionPerformed(evt);
            }
        });

        btnAmarillo.setBackground(java.awt.Color.yellow);
        btnAmarillo.setEnabled(false);
        btnAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmarilloActionPerformed(evt);
            }
        });

        btnAzul.setBackground(java.awt.Color.blue);
        btnAzul.setEnabled(false);
        btnAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzulActionPerformed(evt);
            }
        });

        btnAnaranjado.setBackground(java.awt.Color.orange);
        btnAnaranjado.setEnabled(false);
        btnAnaranjado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaranjadoActionPerformed(evt);
            }
        });

        btnMorado.setBackground(java.awt.Color.magenta);
        btnMorado.setEnabled(false);
        btnMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoradoActionPerformed(evt);
            }
        });

        btnRosado.setBackground(java.awt.Color.pink);
        btnRosado.setEnabled(false);
        btnRosado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRosadoActionPerformed(evt);
            }
        });

        btnNegro.setBackground(java.awt.Color.black);
        btnNegro.setEnabled(false);
        btnNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegroActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setText("00:00");
        lblTiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNivel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtNivel.setModel(new javax.swing.SpinnerListModel(new String[] {"Rapido", "Normal", "Lento"}));
        txtNivel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtNivelStateChanged(evt);
            }
        });

        lblTiempo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTiempo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTiempo1.setText("Nivel: ");

        lblTiempo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTiempo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo2.setText("Tiempo");

        lblTiempo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTiempo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTiempo4.setText("Puntaje:");

        lblTiempo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTiempo5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTiempo5.setText("Mejor Puntaje:");

        lblPuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setText("0");

        lblPuntosMax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuntosMax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntosMax.setText("0");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTiempo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTiempo4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTiempo5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPuntosMax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTiempo1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTiempo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTiempo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNivel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuntos)
                    .addComponent(lblTiempo4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuntosMax)
                    .addComponent(lblTiempo5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnIniciar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerde, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnAmarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAzul, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnMorado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnaranjado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRosado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNegro, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerde, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAmarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMorado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRosado, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnAnaranjado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdeActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_VERDE);
    }//GEN-LAST:event_btnVerdeActionPerformed

    private void btnRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRojoActionPerformed
       this.actionPerformedGenerico(Simon.COLOR_ROJO);
    }//GEN-LAST:event_btnRojoActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        timer.start();
        iniciarSecuencia();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzulActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_AZUL);
    }//GEN-LAST:event_btnAzulActionPerformed

    private void btnAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmarilloActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_AMARILLO);
    }//GEN-LAST:event_btnAmarilloActionPerformed

    private void btnMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoradoActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_MORADO);
    }//GEN-LAST:event_btnMoradoActionPerformed

    private void btnAnaranjadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaranjadoActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_ANARANJADO);
    }//GEN-LAST:event_btnAnaranjadoActionPerformed

    private void btnRosadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRosadoActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_ROSADO);
    }//GEN-LAST:event_btnRosadoActionPerformed

    private void btnNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegroActionPerformed
        this.actionPerformedGenerico(Simon.COLOR_NEGRO);
    }//GEN-LAST:event_btnNegroActionPerformed

    private void txtNivelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtNivelStateChanged
        switch (txtNivel.getValue().toString()) {
            case "Rapido" -> Simon.nivel=Simon.NIVEL_RAPIDO;
            case "Normal" -> Simon.nivel=Simon.NIVEL_NORMAL;
            case "Lento" -> Simon.nivel=Simon.NIVEL_LENTO;
        }
    }//GEN-LAST:event_txtNivelStateChanged

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
            java.util.logging.Logger.getLogger(FrmSimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSimon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmarillo;
    private javax.swing.JButton btnAnaranjado;
    private javax.swing.JButton btnAzul;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnMorado;
    private javax.swing.JButton btnNegro;
    private javax.swing.JButton btnRojo;
    private javax.swing.JButton btnRosado;
    private javax.swing.JButton btnVerde;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblPuntosMax;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempo1;
    private javax.swing.JLabel lblTiempo2;
    private javax.swing.JLabel lblTiempo4;
    private javax.swing.JLabel lblTiempo5;
    private javax.swing.JSpinner txtNivel;
    // End of variables declaration//GEN-END:variables
}
